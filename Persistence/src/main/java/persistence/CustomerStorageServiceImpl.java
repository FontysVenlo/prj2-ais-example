/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package persistence;

import businessentitiesapi.Customer;
import genericdao.dao.DAOFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
class CustomerStorageServiceImpl implements CustomerStorageService {
    
    private final DAOFactory daoFactory;

    public CustomerStorageServiceImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    @Override
    public Optional<Customer> add( Customer c ) {
        System.out.println( "DO SMART THINGS TO STORE A CUSTOMER" );
        var customerDao = daoFactory.createDao(Customer.class);
        return customerDao.save(c);
    }
    
    @Override
    public List<Customer> getAll(){
        
        // DB handling, returns resultset
        // for each entry in resultset, make customerobject using factory method in CustomerManager.
        // For now, simulate DB result:
        
        Customer dummy1 = new Customer(0, "Lisa", LocalDate.of(1980, 8, 1));
        Customer dummy2 = new Customer(1, "Jack", LocalDate.of(1960, 1, 8));
        
        return new ArrayList<>( Arrays.asList( dummy1, dummy2 ));
        
        //return Collections.emptyList();
    }
    
}
