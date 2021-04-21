package assembler;

import businesslogic.BusinessLogicAPI;
import persistence.PersistenceAPI;
import businesslogic.BusinessLogicImplementationProvider;
import fontys.frontend.GUIApp;
import genericdao.pgdao.PGDAOFactory;
import genericdao.pgdao.PGJDBCUtils;
import persistence.PersistenceImplementationProvider;
import javax.sql.DataSource;


/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Main {
    
    public static void main( String[] args ) {
        
        DataSource ds = PGJDBCUtils.getDataSource( "simpledao" );
        PGDAOFactory daoFactory = new PGDAOFactory(ds);
        PersistenceAPI persistenceAPI = PersistenceImplementationProvider.getImplementation(daoFactory);
        BusinessLogicAPI businesslogicAPI = BusinessLogicImplementationProvider.getImplementation( persistenceAPI );
        
        new GUIApp( businesslogicAPI ).show();

    }
    
}
