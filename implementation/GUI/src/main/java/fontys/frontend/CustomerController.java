package fontys.frontend;

import businessentitiesapi.Customer;
import businesslogic.CustomerManager;
import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    TextField customerName, dateOfBirth;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final CustomerManager customerManager;
    
    public CustomerController( Supplier<SceneManager> sceneManagerSupplier, CustomerManager customerManager ) {  
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.customerManager = customerManager;
    }

    @FXML
    private void switchToSecondary() {
        Consumer<SecondaryController> consumer =
                (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene( "secondary", consumer );
    }

    @FXML
    private void storeCustomer() {
        Customer c = customerManager.createCustomer( 
                customerName.getText(), LocalDate.parse( dateOfBirth.getText() ) );

        customerManager.add( c );
    }
}
