/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import businessentities.Customer;
import java.util.Map;
import java.util.Optional;

/**
 * ConsumerMananager accepting map of key, value pairs.
 * 
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface CustomerManager {

    Optional<Customer> addCustomer( Map<String,String> keyValues );

    public int countCustomers();
}
