/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package persistence;


/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
class PersistenceAPIImpl implements PersistenceImplementationProvider, PersistenceAPI {

    @Override
    public CustomerStorageService getCustomerStorageService( ) {
        return new CustomerStorageServiceImpl(  );
    }
    
}
