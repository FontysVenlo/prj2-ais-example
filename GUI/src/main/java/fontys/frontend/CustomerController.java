package fontys.frontend;

import businessentitiesapi.Customer;
import businessentitiesapi.CustomerManager;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    TextField customerName, dateOfBirth;

    private final GUIApp guiApp;
    private final CustomerManager customerManager;
    
    public CustomerController( GUIApp guiApp ) {
        System.out.println("STEP 1 =============================================================");
        this.guiApp = guiApp;
        System.out.println("STEP 2 =============================================================");
        customerManager = guiApp.getBusinessLogicAPI().getCustomerManager();
        System.out.println("STEP 3 =============================================================");
    }

    @FXML
    private void switchToSecondary() throws IOException {
        guiApp.setRoot( "secondary" );
    }

    @FXML
    private void storeCustomer() {
        
        Customer c = customerManager.createCustomer( 
                customerName.getText(), LocalDate.parse( dateOfBirth.getText() ) );
        
        customerManager.add( c );
    }
}
