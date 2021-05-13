/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogicprovider;

import java.time.LocalDate;
import businessentities.Customer;
import businesslogic.CustomerManager;
import genericdao.dao.DAOFactory;
import java.util.Optional;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class CustomerManagerImpl implements CustomerManager {

    final DAOFactory persistenceAPI;
    // No lists of Customer objects here, to avoid sync problems 

    public CustomerManagerImpl( DAOFactory persistenceAPI ) {
        this.persistenceAPI = persistenceAPI;
    }

    public Optional<Customer> add( Customer c ) {
        var cdao = persistenceAPI.createDao( Customer.class );
        return cdao.save( c );
    }

    public Customer createCustomer( String name, LocalDate dob ) {
        return new Customer( 0, name, dob,null );
    }

    @Override
    public int countCustomers() {
        return persistenceAPI.createDao( Customer.class ).size();

    }

}
