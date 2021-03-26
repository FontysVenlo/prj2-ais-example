package assembler;

import businesslogic.BusinessLogicAPI;
import persistence.PersistenceAPI;
import businesslogic.BusinessLogicImplementationProvider;
import fontys.frontend.GUIApp;
import persistence.PersistenceImplementationProvider;


/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Main {
    
    public static void main( String[] args ) {
        
        PersistenceAPI persistenceAPI = PersistenceImplementationProvider.getImplementation();
        BusinessLogicAPI businesslogicAPI = BusinessLogicImplementationProvider.getImplementation( persistenceAPI );
        
        new GUIApp( businesslogicAPI ).show();

    }
    
}
