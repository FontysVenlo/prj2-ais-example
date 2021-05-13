/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogicprovider;

import java.time.LocalDate;
import businessentities.Customer;
import businesslogic.CustomerManager;
import genericdao.dao.DAOFactory;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

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

    public Optional<Customer> addCustomer( Map<String, String> input ) {
        var cdao = persistenceAPI.createDao( Customer.class );
        return cdao.save( fromMap( input ) );
    }

    public Customer createCustomer( String name, LocalDate dob ) {
        return new Customer( 0, name, dob, null );
    }

    @Override
    public int countCustomers() {
        return persistenceAPI.createDao( Customer.class ).size();

    }
    private static final Logger logger = Logger.getLogger(
            CustomerManagerImpl.class.getName() );

    Customer fromMap( Map<String, String> values ) {
        System.out.println( "apply " );
        System.out.println( "values = " + values );
        return createCustomer( values.get( "customerName" ), LocalDate
                               .parse( values.get( "dateOfBirth" ) ) );

    }

}
