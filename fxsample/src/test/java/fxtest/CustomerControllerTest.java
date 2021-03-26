package fxtest;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.service.query.NodeQuery;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@ExtendWith( ApplicationExtension.class )
@TestMethodOrder( MethodOrderer.OrderAnnotation.class )
public class CustomerControllerTest {

    private Stage stage;

    static {
        if ( Boolean.getBoolean( "SERVER" ) ) {
            System.setProperty( "java.awt.headless", "true" );
            System.setProperty( "testfx.robot", "glass" );
            System.setProperty( "testfx.headless", "true" );
            System.setProperty( "prism.order", "sw" );
            System.setProperty( "prism.text", "t2k" );
            System.setProperty( "glass.platform", "Monocle" );
            System.setProperty( "monocle.platform", "Headless" );
        }
    }

//    @BeforeEach
//    void setup(){
//        main= new GUIApp().startFrontEnd( bl );
//    }
    @Start
    void start( Stage stage ) throws Exception {
        this.stage = stage;
        Parent parent = loadFXML( "customerView" );
        Scene scene = new Scene( parent );
        stage.setScene( scene );
        stage.show();
//        GUIApp main = new GUIApp();

//        main.start( stage );
    }

    private static Parent loadFXML( String fxml ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( App.class.getResource(
                fxml + ".fxml" ) );
        return fxmlLoader.load();
    }

    //@Disabled("Think TDD")query
//    @ParameterizedTest
    @Test
    void tSwitchToCustomer() {
        FxRobot rob = new FxRobot();
//        TextField editor =
        rob
                .clickOn( "#customerName" )
                .write( "Donald" )
                .clickOn( "#dateOfBirth" )
                .write( "1990-01-01" );
//        TextField customerNameField = lookupNodeByName( rob,"#customerName" );
//        assumeThat( customerNameField ).isNotNull();
//        rob.clickOn( customerNameField ).write( "Hello World" );
//
//        TextField dobTextField =  lookupNodeByName( rob,"#dateOfBirth" );
//        rob.clickOn( dobTextField ).write( "1955-03-18" );
//        NodeQuery buttonLookup = lookupNodeByName( rob,"#StoreCustomer" ); 
//
//        Button submit = (Button) buttonLookup.query();
//        rob.clickOn( submit );
        fail( "method SwitchToCustomer completed succesfully; you know what to do" );
    }

    private <N extends Node> N lookupNodeByName( FxRobot rob, String name ) {
        return rob.lookup( name ).query();
    }

}
