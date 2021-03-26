package fxtest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.SoftAssertions.*;
import org.testfx.api.FxRobot;

/**
 * Example of a mock self. Instead of using a mock, implement the
 * business logic interface in this test class.
 * In the tests inspect (assert) the received method parameters
 * in fields, typically strings or collections.
 *
 * The test shows that if the Controller/ GUI is thin, the tests can also be.
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

    /**
     * Implement the business logic in in this class with this method.
     * This method save the received parameters in fields for inspection in the
     * test.
     *
     * @param name
     * @param dob
     */
    @Override
    public void addCustomer( String name, String dob ) {
        this.savedName = name;
        this.dob = dob;
        System.out.println( "received " + name + " " + dob );
    }

    /**
     * Configure the XMLoader with a factory, which injects this as
     * implementation as business logic.
     *
     * @param stage
     * @throws Exception
     */
    @Start
    void start( Stage stage ) throws Exception {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource(
                "customerView.fxml" ) );
        // always return the CustomerController with this as business logic.
        fxmlLoader.setControllerFactory( c -> new CustomerController( this ) );
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
        rob.clickOn( "#customerName" )
                .write( name )
                .clickOn( "#dateOfBirth" )
                .write( dob ).
                clickOn( "#storeCustomer" );
        assertSoftly( softly -> {
            softly.assertThat( this.savedName ).isEqualTo( name );
            softly.assertThat( this.dob ).isEqualTo( dob );
        } );
//        fail( "method SwitchToCustomer completed succesfully; you know what to do" );
    }

}
