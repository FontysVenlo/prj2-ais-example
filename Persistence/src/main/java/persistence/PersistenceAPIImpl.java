/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package persistence;

import genericdao.dao.DAOFactory;


/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
class PersistenceAPIImpl implements PersistenceImplementationProvider, PersistenceAPI {
    
    private final DAOFactory daoFactory;

    public PersistenceAPIImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public CustomerStorageService getCustomerStorageService() {
        return new CustomerStorageServiceImpl( daoFactory );
    }
    
}
