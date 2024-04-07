import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getIfEmptyTest {
    private static final String NULL = "NULL";

    @Test
    void testNullInput() {
        Supplier<String> defaultSupplier = () -> NULL;
        String result = StringUtils.getIfEmpty(null, defaultSupplier);
        assertEquals(NULL, result);
    }

    @Test
    void testEmptyInput() {
        Supplier<String> defaultSupplier = () -> NULL;
        String result = StringUtils.getIfEmpty("", defaultSupplier);
        assertEquals(NULL, result);
    }

    @Test
    void testWhitespaceInput() {
        Supplier<String> defaultSupplier = () -> NULL;
        String result = StringUtils.getIfEmpty(" ", defaultSupplier);
        assertEquals(" ", result);
    }

    @Test
    void testNonEmptyInput() {
        Supplier<String> defaultSupplier = () -> NULL;
        String result = StringUtils.getIfEmpty("bat", defaultSupplier);
        assertEquals("bat", result);
    }

    @Test
    void testEmptyInputWithNullSupplier() {
        String result = StringUtils.getIfEmpty("", null);
        assertNull(result);
    }

    @Test
    void testNullSupplier() {
        String result = StringUtils.getIfEmpty("", null);
        assertNull(result);
    }
}