package fxtest;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    TextField customerName, dateOfBirth;


    public CustomerController() {
    }

//    public CustomerController( BusinessLogicAPI logicAPI ) {
//        this.businessLogicAPI = logicAPI;
//    }

    @FXML
    private void switchToSecondary() throws IOException {
//        GUIApp.setRoot( "secondary" );
    }

    @FXML
    private void storeCustomer() {
//        Customer c = businessLogicAPI.getCustomerManager().createCustomer( 
//                customerName.getText(), LocalDate.parse( dateOfBirth.getText() ) );
//        businessLogicAPI.getCustomerManager().add( c );
    }
}
