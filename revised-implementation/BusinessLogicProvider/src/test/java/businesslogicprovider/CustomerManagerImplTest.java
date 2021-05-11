package businesslogicprovider;

import businessentities.Customer;
import businesslogic.CustomerManager;
import genericdao.pgdao.PGDAOFactory;
import genericdao.pgdao.PGJDBCUtils;
import java.time.LocalDate;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Pieter van den Hombergh {@code Pieter.van.den.Hombergh@gmail.com}
 */
public class CustomerManagerImplTest {

    static DataSource ds = PGJDBCUtils.getDataSource( "simpledao" );
    static PGDAOFactory daof;

    //@Disabled("Think TDD")
    @Test
    void tSaveElon() {
        Customer elon = new Customer( null, "Elon Musk", LocalDate.of( 1971, 06,
                                                                       28 ) );
        CustomerManager man = new CustomerManagerImpl(daof );
        
        int countCustomers = man.countCustomers();
        man.add( elon );
        
        assertThat(man.countCustomers()).isGreaterThan( countCustomers );
        

        fail( "method SaveElon completed succesfully; you know what to do" );
    }
}
