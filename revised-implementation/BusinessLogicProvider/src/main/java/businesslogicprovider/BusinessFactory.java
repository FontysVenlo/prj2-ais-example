/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package businesslogicprovider;

import businesslogic.AssemblerDelegate;
import businesslogic.CustomerManager;
import genericdao.dao.DAOFactory;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class BusinessFactory implements AssemblerDelegate {

    final DAOFactory persistenceAPI;

    public BusinessFactory( DAOFactory persistenceAPI ) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public CustomerManager getCustomerManager() {
        return new CustomerManagerImpl( persistenceAPI );
    }

}
