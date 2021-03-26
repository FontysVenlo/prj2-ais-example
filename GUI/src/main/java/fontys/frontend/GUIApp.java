package fontys.frontend;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.util.Callback;
import businesslogic.BusinessLogicAPI;
import javafx.application.Platform;

/**
 * JavaFX App
 */
public class GUIApp extends Application {

    private BusinessLogicAPI businessLogicAPI;
    private SceneManager sceneManager;

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {

        switch (c.getName()) {
            case "fontys.frontend.CustomerController":
                return new CustomerController( this::getSceneManager, businessLogicAPI.getCustomerManager());
            case "fontys.frontend.SecondaryController":
                return new SecondaryController( this::getSceneManager );
            default: 
                return null;
        }
    };
    
    public GUIApp( BusinessLogicAPI businessLogicAPI ) {
        this( businessLogicAPI, true );
    }

    GUIApp(BusinessLogicAPI businessLogicAPI, boolean startJavaFXToolkit) {

        if (startJavaFXToolkit) {
            Platform.startup(() -> {
            });
        }

        this.businessLogicAPI = businessLogicAPI;
        sceneManager = new SceneManager(controllerFactory, "customerView");
    }

    @Override
    public void start(Stage stage) throws IOException {
        sceneManager.displayOn(stage, 640, 480);
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }

    public void show() {

        Platform.runLater(() -> {
            Stage stage = new Stage();
            try {
                start(stage);
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        });
    }
}