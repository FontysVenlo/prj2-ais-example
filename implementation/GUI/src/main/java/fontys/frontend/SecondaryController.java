package fontys.frontend;

import java.util.function.Supplier;
import javafx.fxml.FXML;

public class SecondaryController {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    
    @FXML
    private void switchToPrimary() {
        sceneManagerSupplier.get().changeScene("customerView");
    }
}