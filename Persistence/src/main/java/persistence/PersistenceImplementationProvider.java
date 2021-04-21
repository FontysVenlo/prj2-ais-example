/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import genericdao.dao.DAOFactory;

/**
 *
 * @author hvd
 */
public interface PersistenceImplementationProvider extends PersistenceAPI {
    
    static PersistenceAPI getImplementation( DAOFactory daoFactory ){
        return new PersistenceAPIImpl(daoFactory);
    };
    
}
