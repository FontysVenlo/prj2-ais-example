package businesslogicprovider;

import businessentities.Customer;
import businesslogic.CustomerManager;
import genericdao.pgdao.PGDAOFactory;
import genericdao.pgdao.PGJDBCUtils;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assumptions.assumeThat;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class CustomerManagerImplTest {

    static DataSource ds = PGJDBCUtils.getDataSource( "simpledao" );
    static PGDAOFactory daof;
    private static final Logger logger = Logger.getLogger(
            CustomerManagerImplTest.class.getName() );

    @BeforeAll
    static void setupDaoFactory() {
        assumeThat( ds ).isNotNull();
        daof = new PGDAOFactory( ds );
    }

    //@Disabled("Think TDD")
    @Test
    void tSaveElon() {
        Customer elon = new Customer( null, "Elon Musk", LocalDate.of( 1971, 06,
                                                                       28 ),null );
        CustomerManager man = new CustomerManagerImpl( daof );
        try {
            int countCustomers = man.countCustomers();
            man.add( elon );
            assertThat( man.countCustomers() ).isGreaterThan( countCustomers );
        } catch ( Exception ex ) {
            ex.printStackTrace();//logger.severe(() -> "ex = " + ex );
//            throw ex;
        }

//        fail( "method SaveElon completed succesfully; you know what to do" );
    }
}
