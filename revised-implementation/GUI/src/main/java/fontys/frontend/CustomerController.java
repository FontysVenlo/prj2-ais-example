package fontys.frontend;

import businessentities.Customer;
import businesslogic.CustomerManager;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import nl.homberghp.fxuiscraper.FXUIScraper;

public class CustomerController implements FXUIScraper {
    
    @FXML
    Parent root;
    
    @FXML
    TextField customerName, dateOfBirth;
    
    Customer customer;
    private final Supplier<SceneManager> sceneManagerSupplier;
    private final CustomerManager customerManager;
    
    public CustomerController( Supplier<SceneManager> sceneManagerSupplier,
                               CustomerManager customerManager ) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.customerManager = customerManager;
    }
    
    @FXML
    void switchToSecondary() {
        sceneManagerSupplier.get().changeScene( "secondary" );
    }
    
    final Predicate<Node> pred = n -> ( null != n.getId() )
            && ( n instanceof TextInputControl );
    
    @FXML
    void storeCustomer() {
        System.out.println( "customerManager = " + customerManager );
        Map<String, String> keyValues = this.getKeyValues( pred );
        keyValues.put( "_command", "save" );
        keyValues.keySet().forEach( System.out::println );
        customerManager.addCustomer(keyValues ).get();
    }
    
    @Override
    public Parent getRoot() {
        return root;
    }
    
}
