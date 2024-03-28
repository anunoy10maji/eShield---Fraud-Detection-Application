package org.proj.Service;

import org.proj.Dtos.CustomerData;

import java.util.List;

public interface CustomerService {

    CustomerData createCustomer(CustomerData customerData);
    CustomerData updateCustomer(String customerId,CustomerData customerData);
    List<CustomerData> getAllCustomers();
    CustomerData getCustomer(String customerId);
    void deleteCustomer(String customerId);
    CustomerData searchByEmail(String email);
    CustomerData searchByAccountNo(String accountNo);
}
