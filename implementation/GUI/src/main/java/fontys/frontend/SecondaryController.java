package fontys.frontend;

import java.util.function.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    
    @FXML
    private Button secondaryButton;
    @FXML
    private Button errorButton;
    @FXML
    private Label prevLabel;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void switchToPrimary() {
        sceneManagerSupplier.get().changeScene("customerView");
    }

    @FXML
    private void switchToError(ActionEvent event) {
        sceneManagerSupplier.get().changeScene("errorView");
    }
    
    public void setPreviousView(String view){
        prevLabel.setText(view);
    }
}