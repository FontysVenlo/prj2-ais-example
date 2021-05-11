package assembler;

import businesslogic.AssemblerDelegate;
import businesslogicprovider.BusinessFactory;
import fontys.frontend.GUIApp;
import genericdao.pgdao.PGDAOFactory;
import genericdao.pgdao.PGJDBCUtils;
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
        PGDAOFactory persistenceAPI = new PGDAOFactory(ds);
        AssemblerDelegate businesslogicAPI = new BusinessFactory( persistenceAPI );
        
        new GUIApp( businesslogicAPI ).show();

    }
    
}
