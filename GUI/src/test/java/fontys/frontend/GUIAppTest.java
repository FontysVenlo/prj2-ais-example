package fontys.frontend;

import businessentitiesapi.Customer;
import businessentitiesapi.CustomerManager;
import businesslogic.BusinessLogicAPI;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@ExtendWith(ApplicationExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
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
    
    CustomerManager customerManager;
    BusinessLogicAPI businessLogic;

    @Start
    void start(Stage stage) throws IOException {
        
        customerManager = mock(CustomerManager.class);
        businessLogic = () -> customerManager;
       
        System.out.println("MOCK: " + System.identityHashCode(businessLogic));
        
        new GUIApp(businessLogic).init(false).start(stage);
    }

    //@Disabled("Think TDD")
    @Test
    void testAddCustomer(FxRobot robot) {

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);

        TextField tf = (TextField)robot.lookup("#customerName").query();
        tf.setText("Elon Musk");
        System.out.println("CUSTNAME IN TEST " + System.identityHashCode( tf) );
        
        ((TextField) robot.lookup("#dateOfBirth").query()).setText("1971-06-28");

        Node query = robot.lookup("#storeCustomer").query();
        robot.clickOn((Button) query);

        verify(customerManager).add(customerCaptor.capture());

        System.out.println("CAPTOR: " + customerCaptor);
        System.out.println( customerCaptor.getAllValues());
        
        assertThat(customerCaptor.getValue().getName()).isEqualTo("Elon Musk");
        assertThat(customerCaptor.getValue().getDateOfBirth()).isEqualTo("");

        robot
                .clickOn("#customerName")
                .write("Donald")
                .clickOn("#dateOfBirth")
                .write( "1990-01-01" );
        

//        NodeQuery dobLookup = robot.lookup("#dateOfBirth");
//        TextField dobTextField = (TextField) dobLookup.query();
//        assumeThat(dobTextField).isNotNull();
//        robot.clickOn(dobTextField).write("1990-01-01");
//        NodeQuery buttonLookup = robot.lookup("#StoreCustomer");
//        Button submit = (Button) buttonLookup.query();
//        robot.clickOn(submit);
        //fail( "method SwitchToCustomer completed succesfully; you know what to do" );
    }

}
