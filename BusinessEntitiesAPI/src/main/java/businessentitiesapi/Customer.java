/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businessentitiesapi;

import java.time.LocalDate;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Customer{
    
    private final String name;
    private final LocalDate dateOfBirth;

    public Customer( String name, LocalDate dob ) {
        this.name = name;
        this.dateOfBirth = dob;
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
