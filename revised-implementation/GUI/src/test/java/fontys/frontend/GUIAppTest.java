package fontys.frontend;

import businessentities.Customer;
import businesslogic.AssemblerDelegate;
import businesslogic.CustomerManager;

import java.io.IOException;
import java.time.LocalDate;
import static java.time.LocalDate.of;
import java.time.Month;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import javafx.stage.Stage;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 *
 * @author hvd/hom
 */
@ExtendWith( ApplicationExtension.class )
@TestMethodOrder( MethodOrderer.OrderAnnotation.class )
public class GUIAppTest {

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

    Function<Map<String,String>,Customer> customerManager;

    @Start
    void start( Stage stage ) throws IOException {

        customerManager = mock( Function.class );
        AssemblerDelegate assemblerDelegate = mock( AssemblerDelegate.class );
        when( assemblerDelegate.getCustomerManager() ).thenReturn(
                customerManager );

        new GUIApp( assemblerDelegate ).init( false ).start( stage );
    }
    private static final Logger logger = Logger.getLogger( GUIAppTest.class
            .getName() );
    //@Disabled("Think TDD")
    @Test
    void testAddCustomer( FxRobot robot ) {

        when( customerManager.apply( anyMap() ) )
                .thenReturn( new Customer( 0, "Elon Musk",
                                           of( 1971, Month.JUNE, 28 ) ) );

        ArgumentCaptor<Map<String, String>> inputCaptor = ArgumentCaptor
                .forClass( Map.class );
        logger.info( () -> "inputCaptor = " + inputCaptor );
        robot
                .clickOn( "#customerName" )
                .write( "Elon Musk" )
                .clickOn( "#dateOfBirth" ) 
                .write( "1971-06-28" )
                .clickOn( "#storeCustomer" );

        verify( customerManager ).apply( inputCaptor.capture() );
        Map<String, String> capture = inputCaptor.getValue();
        System.out.println( "capture = " + capture );
        assertSoftly( softly -> {
            softly.assertThat( capture.get( "customerName" ) ).isEqualTo(
                    "Elon Musk" );
            softly.assertThat( capture.get( "dateOfBirth" ) )
                    .isEqualTo( LocalDate.of( 1971, Month.JUNE, 28 ).toString() );
        } );
    }

}
