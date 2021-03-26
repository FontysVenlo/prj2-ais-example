package fxtest;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    TextField customerName, dateOfBirth;

    BusinessLogic bl;

    public CustomerController( BusinessLogic bl ) {
        this.bl = bl;
    }

    @FXML
    private void switchToSecondary() throws IOException {
       
//        GUIApp.setRoot( "secondary" );
    }

    @FXML
    private void storeCustomer() {
        bl.addCustomer( customerName.getText(), dateOfBirth.getText());
    }
}
