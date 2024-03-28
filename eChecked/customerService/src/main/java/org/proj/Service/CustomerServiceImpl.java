package org.proj.Service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.proj.Dtos.CustomerData;
import org.proj.Entity.Customer;
import org.proj.Exceptions.ResourceNotFound;
import org.proj.Fraud.FraudCheckClient;
import org.proj.Fraud.FraudResult;
import org.proj.Notification.NotificationRequest;
import org.proj.Notification.NotificationSendClient;
import org.proj.Repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    private Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FraudCheckClient fraudCheckClient;

    @Autowired
    private NotificationSendClient notificationSendClient;
    @Override
    public CustomerData createCustomer(CustomerData customerData) {

        Customer customer=mapper.map(customerData,Customer.class);
        String id= UUID.randomUUID().toString();
        customer.setCustomerId(id);
        customerRepo.saveAndFlush(customer);
        FraudResult fraudResult=fraudCheckClient.checkFraud(customer.getCustomerId(),customer.getFunctionCode(),
                customer.getGetTransactionType(),customer.getCountry());
        String token= UUID.randomUUID().toString();
        if(fraudResult.isFraud()){
            //Send Notification
            NotificationRequest notificationRequest = NotificationRequest.builder().sent_to_customerId(customer.getCustomerId())
                    .message("Hi , "+ customer.getCustomerName() + "Marked as Fraud. Verification needed")
                    .sent_from("DoNotReplyeChecked.in")
                    .sent_to_email(customer.getEmail()).sent_at(LocalDateTime.now()).token("-vError").build();
            notificationSendClient.sendNotification(notificationRequest);
        }else{
            //Send Notification
            NotificationRequest notificationRequest = NotificationRequest.builder().sent_to_customerId(customer.getCustomerId())
                    .message("Welcome , "+ customer.getCustomerName() + " to  eChecked.Verified successfully. Please save the token for future purpose")
                    .sent_from("DoNotReplyeChecked.in")
                    .sent_to_email(customer.getEmail()).sent_at(LocalDateTime.now()).token(token).build();
            notificationSendClient.sendNotification(notificationRequest);
        }

        return mapper.map(customer,CustomerData.class);
    }

    @Override
    public CustomerData updateCustomer(String customerId, CustomerData customerData)
    {
        Customer customer=customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFound("Given Id not found!"));
        customer.setCustomerName(customerData.getCustomerName());
        customer.setAccountNo(customerData.getAccountNo());
        customer.setEmail(customerData.getEmail());
        customer.setCountry(customerData.getCountry());
        customer.setFunctionCode(customerData.getFunctionCode());
        customer.setTransactionAmount(customerData.getTransactionAmount());
        customer.setGetTransactionType(customerData.getGetTransactionType());
        customerRepo.save(customer);
        return mapper.map(customer,CustomerData.class);
    }

    @Override
    public List<CustomerData> getAllCustomers() {
        List<Customer> customers=customerRepo.findAll();
        List<CustomerData> customerData=customers.stream().map(object->
                mapper.map(object,CustomerData.class)).collect(Collectors.toList());
        return customerData;
    }

    @Override
    public CustomerData getCustomer(String customerId) {
        Customer customer=customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFound("Given Id not found!"));
        return mapper.map(customer,CustomerData.class);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer=customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFound("Given Id not found!"));
        customerRepo.delete(customer);
    }

    @Override
    public CustomerData searchByEmail(String email) {
        Customer customer=customerRepo.findByEmail(email);
        if(customer==null){
            throw new ResourceNotFound("Customer not found!");
        }
        return mapper.map(customer,CustomerData.class);
    }

    @Override
    public CustomerData searchByAccountNo(String accountNo) {
        Customer customer=customerRepo.findByAccountNo(accountNo);
        if(customer==null){
            throw new ResourceNotFound("Customer not found!");
        }
        return mapper.map(customer,CustomerData.class);
    }
}
