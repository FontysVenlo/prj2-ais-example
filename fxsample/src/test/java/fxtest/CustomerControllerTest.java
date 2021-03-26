package fxtest;

import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;
import org.testfx.api.FxRobot;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
@ExtendWith( ApplicationExtension.class )
@TestMethodOrder( MethodOrderer.OrderAnnotation.class )
public class CustomerControllerTest implements BusinessLogic {

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

    String savedName = null;
    String dob = null;

    @Override
    public void addCustomer( String name, String dob ) {
        this.savedName = name;
        this.dob = dob;
        System.out.println( "received "+name+" "+ dob );
    }

    @Start
    void start( Stage stage ) throws Exception {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource(
                "/fxtest/customerView.fxml" ) );
        fxmlLoader.setControllerFactory( controllerFactory );
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene( parent );
        stage.setScene( scene );
        stage.show();
    }

    //@Disabled("Think TDD")query
    @ParameterizedTest
    @CsvSource( {
        "James Watt,1736-01-19‎",
        "Thomas Edison,1847-02-11"

    } )
    void tSwitchToCustomer( String name, String dob ) {
        FxRobot rob = new FxRobot();
//        TextField editor =
        rob
                .clickOn( "#customerName" )
                .write( name )
                .clickOn( "#dateOfBirth" )
                .write( dob.toString() ).
                clickOn( "#storeCustomer" );
        assertSoftly( softly -> {
            softly.assertThat( this.savedName ).isEqualTo( name );
            softly.assertThat( this.dob ).isEqualTo( dob );
        } );

//        fail( "method SwitchToCustomer completed succesfully; you know what to do" );
    }

    private <N extends Node> N lookupNodeByName( FxRobot rob, String name ) {
        return rob.lookup( name ).query();
    }

    private final Callback<Class<?>, Object> controllerFactory = (
            Class<?> c )
            -> {
        if ( c.getName().equals( "fxtest.CustomerController" ) ) {
            return new CustomerController( this );
        }
        return null;

    };
}
