import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.function.Supplier;

class getTest {

    @Test
    void testGetReturnsNullForNullSupplier() {
        Supplier<String> supplier = null;
        Assertions.assertNull(Suppliers.get(supplier));
    }

    @Test
    void testGetReturnsResultForNonNullSupplier() {
        Supplier<String> supplier = () -> "Result";
        Assertions.assertEquals("Result", Suppliers.get(supplier));
    }

    @Test
    void testGetReturnsNullForSupplierThatReturnsNull() {
        Supplier<String> supplier = () -> null;
        Assertions.assertNull(Suppliers.get(supplier));
    }

    @Test
    void testGetThrowsExceptionForSupplierThatThrowsException() {
        Supplier<String> supplier = () -> {
            throw new RuntimeException("Exception");
        };
        Executable executable = () -> Suppliers.get(supplier);
        Assertions.assertThrows(RuntimeException.class, executable);
    }
}