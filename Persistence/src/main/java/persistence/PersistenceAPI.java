/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package persistence;


/**
 * Facade that provides all persistence/storage services to the business logic.
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public interface PersistenceAPI {
    
    /**
     * Get CustomerStorageService.
     * Provides a storage object that knows how to store and retrieve customers.
     * Implemented by a default method, to enable creation of customized 
     * PersistenceFacade implementations with limited services, for test purposes. 
     * 
     * @param customerManager
     * @return CustomerStorageService object that knows how to store and retrieve customers.
     */
    default CustomerStorageService getCustomerStorageService( ){
        return null;
    }
    
    // This interface can be extended with all services that need to be made
    // available to the business logic, e.g. to store Products:
    // 
    // ProductStorageService getProductStorageService( ProductManager productManager );
    
}
