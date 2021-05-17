/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.frontend;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import javafx.fxml.Initializable;

/**
 *
 * @author fontys
 */
public class ErrorController implements Initializable{
    
    private final Supplier<SceneManager> sceneManagerSupplier;

    public ErrorController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
