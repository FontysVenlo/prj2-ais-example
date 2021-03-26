package fontys.frontend;

import businessentitiesapi.Customer;
import businessentitiesapi.CustomerManager;
import java.time.LocalDate;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    TextField customerName, dateOfBirth;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final CustomerManager customerManager;
    
    public CustomerController( Supplier<SceneManager> sceneManagerSupplier, CustomerManager customerManager ) {
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRR");
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.customerManager = customerManager;
        System.out.println("CUSTOMERMANAGER " + customerManager);
    }
    
    @FXML
    public void initialize(){
        System.out.println("INITIALIZED");
        System.out.println("CUSTNAME IN CONTROLLER " + System.identityHashCode( customerName) );
        
    }

    @FXML
    private void switchToSecondary() {
        sceneManagerSupplier.get().changeScene( "secondary" );
    }

    @FXML
    private void storeCustomer() {
        System.out.println("STORE CUSTOMER EXECUTED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Customer c = customerManager.createCustomer( 
                customerName.getText(), LocalDate.parse( dateOfBirth.getText() ) );
        
        System.out.println("PASS To customerManager: " + c.getName() + " " + c.getDateOfBirth());
        customerManager.add( c );
    }
}
