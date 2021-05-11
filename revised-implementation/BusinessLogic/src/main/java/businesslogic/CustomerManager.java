/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import java.time.LocalDate;
import businessentities.Customer;
import genericdao.dao.DAOFactory;
import java.util.Optional;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface CustomerManager {

    Optional<Customer> add( Customer c );
    Customer createCustomer( String name, LocalDate dob );
}
