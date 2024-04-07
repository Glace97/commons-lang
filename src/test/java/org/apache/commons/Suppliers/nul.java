import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;

class nulTest {

    @Test
    void testNul() {
        Supplier<Object> supplier = Suppliers.nul();
        assertNull(supplier.get());
    }
}