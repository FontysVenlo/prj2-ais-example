package fontys.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.util.Callback;
import businesslogic.BusinessLogicAPI;
import javafx.application.Platform;

/**
 * JavaFX App
 */
public class GUIApp extends Application {

    private Scene scene;
    private final BusinessLogicAPI businessLogicAPI;

    public GUIApp(BusinessLogicAPI businessLogicAPI) {
        this.businessLogicAPI = businessLogicAPI;
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("customerView"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    BusinessLogicAPI getBusinessLogicAPI() {
        return businessLogicAPI;
    }

    void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApp.class.getResource(fxml + ".fxml"));

        fxmlLoader.setControllerFactory(controllerFactory);

        return fxmlLoader.load();
    }

    private final Callback<Class<?>, Object> controllerFactory = (Class<?> c)
            -> {

        switch (c.getName()) {

            case "fontys.frontend.CustomerController":
                return new CustomerController(this);
            case "fontys.frontend.SecondaryController":
                return new SecondaryController(this);
        }
        
        return null;

    };

    public static void main(String[] args) {
        launch();
    }

    public void show() {

        Platform.startup(() -> {
            Stage stage = new Stage();
            try {
                start(stage);
            } catch (Exception ex) {
                throw new IllegalStateException(ex);
            }
        });   
    }

}
