/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogic;

import businessentities.Customer;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface AssemblerDelegate {
    public abstract Function<Map<String,String>,Customer> getCustomerManager();
}
