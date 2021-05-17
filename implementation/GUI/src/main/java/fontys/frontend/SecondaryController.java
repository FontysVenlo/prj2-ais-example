package fontys.frontend;

import java.util.function.Supplier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondaryController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    
    @FXML
    private Button secondaryButton;
    @FXML
    private Button errorButton;

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
}