/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businessentitiesapi;

import java.time.LocalDate;
import nl.fontys.sebivenlo.sebiannotations.ID;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Customer{
    
    @ID
    private final Integer customerid;
    private final String name;
    private final LocalDate dateOfBirth;

    public Customer( Integer customerid, String name, LocalDate dob ) {
        this.customerid = customerid;
        this.name = name;
        this.dateOfBirth = dob;
    }
    
    public Integer getCustomerid(){
        return customerid;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
