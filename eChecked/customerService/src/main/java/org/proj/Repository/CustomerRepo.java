package org.proj.Repository;

import org.proj.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findByAccountNo(String accountNo);
    Customer findByEmail(String email);
}
