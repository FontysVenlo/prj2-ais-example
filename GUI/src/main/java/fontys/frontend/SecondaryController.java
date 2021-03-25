package fontys.frontend;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    private GUIApp guiApp;

    public SecondaryController(GUIApp guiApp) {
        this.guiApp = guiApp;
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        guiApp.setRoot("primary");
    }
}