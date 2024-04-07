import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class toSupplierTest {
    private Validate validate;

    @BeforeEach
    void setUp() {
        validate = new Validate();
    }

    @Test
    void toSupplier_withMessageAndValues_shouldReturnSupplierWithCorrectMessage() {
        String message = "This is a test message";
        Object[] values = {1, "test"};
        Supplier<String> supplier = validate.toSupplier(message, values);
        assertEquals("This is a test message", supplier.get());
    }

    @Test
    void toSupplier_withEmptyMessageAndValues_shouldReturnSupplierWithEmptyMessage() {
        String message = "";
        Object[] values = {};
        Supplier<String> supplier = validate.toSupplier(message, values);
        assertEquals("", supplier.get());
    }

    @Test
    void toSupplier_withNullMessageAndValues_shouldReturnSupplierWithNullMessage() {
        String message = null;
        Object[] values = {};
        Supplier<String> supplier = validate.toSupplier(message, values);
        assertEquals(null, supplier.get());
    }
}