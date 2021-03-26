package fontys.frontend;

import businessentitiesapi.CustomerManager;
import businesslogic.BusinessLogicAPI;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static org.assertj.core.api.Assumptions.assumeThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.service.query.NodeQuery;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GUIAppTest {

    static {
        if (Boolean.getBoolean("SERVER")) {
            System.setProperty("java.awt.headless", "true");
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("monocle.platform", "Headless");
        }
    }

    @Mock
    CustomerManager customerManager;

    BusinessLogicAPI businessLogic = new BusinessLogicAPI() {
        @Override
        public CustomerManager getCustomerManager() {
            return customerManager;
        }
    };

    @Start
    void start(Stage stage) throws IOException {
        new GUIApp( businessLogic, false ).start( stage );
    }

    //@Disabled("Think TDD")
    @Test
    void tSwitchToCustomer(FxRobot robot) {

        NodeQuery nameLookup;
        nameLookup = robot.lookup("#customerName");
        TextField nametextField = (TextField) nameLookup.query();
        assumeThat(nametextField).isNotNull();
        robot.clickOn(nametextField).write("Donald");
        
        NodeQuery dobLookup = robot.lookup("#dateOfBirth");
        TextField dobTextField = (TextField) dobLookup.query();
        assumeThat(dobTextField).isNotNull();
        robot.clickOn(dobTextField).write("1990-01-01");
        
        NodeQuery buttonLookup = robot.lookup("#StoreCustomer");
        Button submit = (Button) buttonLookup.query();
        robot.clickOn(submit);
        //fail( "method SwitchToCustomer completed succesfully; you know what to do" );
    }

}
