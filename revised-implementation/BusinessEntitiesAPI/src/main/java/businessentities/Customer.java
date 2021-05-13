/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businessentities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import nl.fontys.sebivenlo.sebiannotations.Generated;
import nl.fontys.sebivenlo.sebiannotations.ID;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Customer implements Serializable {
    
    @ID
    private final Integer customerid;
    private final String name;
    private final LocalDate dateOfBirth;
    @Generated
    private final LocalDateTime since;

    public Customer( Integer customerid, String name, LocalDate dateOfBirth,
                     LocalDateTime since ) {
        this.customerid = customerid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.since = since;
    }

    public Customer( Integer customerid, String name, LocalDate dateOfBirth ) {
        this.customerid = customerid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.since=LocalDateTime.MAX;
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

    public LocalDateTime getSince() {
        return since;
    }

    
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
