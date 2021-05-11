/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import java.time.LocalDate;
import persistence.CustomerStorageService;
import businessentitiesapi.Customer;
import java.util.Optional;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class CustomerManager { 
    
    private CustomerStorageService customerStorageService;
    
    // No lists of Customer objects here, to avoid sync problems 

    public void setCustomerStorageService( CustomerStorageService customerStorageService ) {
        this.customerStorageService = customerStorageService;
    }
    
    public Optional<Customer> add(Customer c){
        return customerStorageService.add(c);
    }

    public Customer createCustomer( String name, LocalDate dob ) {
        return new Customer(0, name, dob);
    }
    
}
