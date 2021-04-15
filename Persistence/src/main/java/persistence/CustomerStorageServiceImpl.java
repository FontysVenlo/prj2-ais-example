/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package persistence;

import businessentitiesapi.Customer;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
class CustomerStorageServiceImpl implements CustomerStorageService{
    
    @Override
    public void add( Customer c ) {
        System.out.println( "DO SMART THINGS TO STORE A CUSTOMER" );
    }
    
    @Override
    public List<Customer> getAll(){
        
        // DB handling, returns resultset
        // for each entry in resultset, make customerobject using factory method in CustomerManager.
        // For now, simulate DB result:
        
        Customer dummy1 = new Customer("Lisa", LocalDate.of(1980, 8, 1));
        Customer dummy2 = new Customer("Jack", LocalDate.of(1960, 1, 8));
        
        return new ArrayList<>( Arrays.asList( dummy1, dummy2 ));
        
        //return Collections.emptyList();
    }
    
}
