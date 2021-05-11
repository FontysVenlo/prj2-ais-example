package businessentities;

import businessentities.Customer;
import genericmapper.Mapper;
import java.util.function.Function;

/**
 * Generated code. Do not edit, your changes will be lost.
 */
public class CustomerMapper extends Mapper<Customer, Integer> {

    // No public ctor 
    private CustomerMapper() {
        super( Customer.class, java.lang.invoke.MethodHandles.lookup()  );
    }

    // self register
    static {
        Mapper.register( new CustomerMapper() );
    }

    // the method that it is all about
    @Override
    public Object[] deconstruct(  Customer c ) {
           return new Object[]{
              c.getCustomerid(),
              c.getName(),
              c.getDateOfBirth()
           }; 
    }

    @Override
    public Function<Customer, Integer> keyExtractor() {
        return ( Customer c ) -> c.getCustomerid();
    }

    @Override
    public Class<Integer> keyType() {
        return Integer.class;

    }
}
