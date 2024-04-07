import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class toStringTest {

    @Test
    void testToStringNullInput() {
        Object nullObj = null;
        String result = ObjectUtils.toString(nullObj);
        Assertions.assertEquals("", result);
    }

    @Test
    void testToStringNonNullInput() {
        Object obj = "bat";
        String result = ObjectUtils.toString(obj);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringEmptyStringInput() {
        Object obj = "";
        String result = ObjectUtils.toString(obj);
        Assertions.assertEquals("", result);
    }

    @Test
    void testToStringBooleanTrueInput() {
        Object obj = Boolean.TRUE;
        String result = ObjectUtils.toString(obj);
        Assertions.assertEquals("true", result);
    }

    @Test
    void testToStringWithNullStringNullInput() {
        Object nullObj = null;
        String nullStr = null;
        String result = ObjectUtils.toString(nullObj, nullStr);
        Assertions.assertNull(result);
    }

    @Test
    void testToStringWithNullStringNonNullInput() {
        Object obj = "bat";
        String nullStr = null;
        String result = ObjectUtils.toString(obj, nullStr);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringWithEmptyStringNullInput() {
        Object nullObj = null;
        String nullStr = "";
        String result = ObjectUtils.toString(nullObj, nullStr);
        Assertions.assertEquals("", result);
    }

    @Test
    void testToStringWithEmptyStringNonNullInput() {
        Object obj = "bat";
        String nullStr = "";
        String result = ObjectUtils.toString(obj, nullStr);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringWithBooleanTrueNullInput() {
        Object nullObj = null;
        String nullStr = "null";
        String result = ObjectUtils.toString(nullObj, nullStr);
        Assertions.assertEquals("null", result);
    }

    @Test
    void testToStringWithBooleanTrueNonNullInput() {
        Object obj = Boolean.TRUE;
        String nullStr = "null";
        String result = ObjectUtils.toString(obj, nullStr);
        Assertions.assertEquals("true", result);
    }

    @Test
    void testToStringWithSupplierNullInput() {
        Supplier<Object> objSupplier = () -> null;
        Supplier<String> nullStrSupplier = () -> "null";
        String result = ObjectUtils.toString(objSupplier, nullStrSupplier);
        Assertions.assertEquals("null", result);
    }

    @Test
    void testToStringWithSupplierNonNullInput() {
        Supplier<Object> objSupplier = () -> "bat";
        Supplier<String> nullStrSupplier = () -> "null";
        String result = ObjectUtils.toString(objSupplier, nullStrSupplier);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringWithSupplierNullSupplier() {
        Supplier<Object> objSupplier = () -> "bat";
        Supplier<String> nullStrSupplier = null;
        String result = ObjectUtils.toString(objSupplier, nullStrSupplier);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringWithTypeParameterNullInput() {
        String obj = null;
        Supplier<String> nullStrSupplier = () -> "null";
        String result = ObjectUtils.toString(obj, nullStrSupplier);
        Assertions.assertEquals("null", result);
    }

    @Test
    void testToStringWithTypeParameterNonNullInput() {
        String obj = "bat";
        Supplier<String> nullStrSupplier = () -> "null";
        String result = ObjectUtils.toString(obj, nullStrSupplier);
        Assertions.assertEquals("bat", result);
    }

    @Test
    void testToStringWithTypeParameterNullSupplier() {
        String obj = "bat";
        Supplier<String> nullStrSupplier = null;
        String result = ObjectUtils.toString(obj, nullStrSupplier);
        Assertions.assertEquals("bat", result);
    }
}