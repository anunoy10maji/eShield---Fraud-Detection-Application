package org.proj.Controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.proj.Dtos.ApiResponseMessage;
import org.proj.Dtos.CustomerData;
import org.proj.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/customer/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<CustomerData> createRequest(@Valid @RequestBody CustomerData customerData){
        CustomerData customer=customerService.createCustomer(customerData);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CustomerData> updateRequest(@PathVariable("id") String id,@Valid @RequestBody CustomerData customerData){
        CustomerData customer=customerService.updateCustomer(id,customerData);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerData> getRequest(@PathVariable("id") String id){
        CustomerData customer=customerService.getCustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseMessage> deleteRequest(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
        ApiResponseMessage message=ApiResponseMessage.builder().
                message("Customer deleted successfully").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<CustomerData> getRequestByEmail(@PathVariable("email") String email){
        CustomerData customer=customerService.searchByEmail(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<List<CustomerData>> getAllRequest(){
        List<CustomerData> customers=customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/get/{accountNo}")
    public ResponseEntity<CustomerData> getRequestByAccountNo(@PathVariable("accountNo") String accountNo){
        CustomerData customer=customerService.searchByAccountNo(accountNo);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
