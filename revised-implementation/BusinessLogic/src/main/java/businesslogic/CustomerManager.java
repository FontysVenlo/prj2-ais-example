/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import java.time.LocalDate;
import businessentities.Customer;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * ConsumerMananager accepting map of key, value pairs.
 * 
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface CustomerManager extends Function<Map<String,String>,Customer> {

    Optional<Customer> add( Customer c );
    Customer createCustomer( String name, LocalDate dob );

    public int countCustomers();
}
