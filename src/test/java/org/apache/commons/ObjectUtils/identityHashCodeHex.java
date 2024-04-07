import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class identityHashCodeHexTest {

    @Test
    @DisplayName("Test identityHashCodeHex with null object")
    void testIdentityHashCodeHexWithNullObject() {
        String expected = "0";
        String actual = ObjectUtils.identityHashCodeHex(null);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with non-null object")
    void testIdentityHashCodeHexWithNonNullObject() {
        String expected = Integer.toHexString(System.identityHashCode("test"));
        String actual = ObjectUtils.identityHashCodeHex("test");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with empty string")
    void testIdentityHashCodeHexWithEmptyString() {
        String expected = Integer.toHexString(System.identityHashCode(""));
        String actual = ObjectUtils.identityHashCodeHex("");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with integer")
    void testIdentityHashCodeHexWithInteger() {
        Integer number = 12345;
        String expected = Integer.toHexString(System.identityHashCode(number));
        String actual = ObjectUtils.identityHashCodeHex(number);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with boolean")
    void testIdentityHashCodeHexWithBoolean() {
        Boolean flag = true;
        String expected = Integer.toHexString(System.identityHashCode(flag));
        String actual = ObjectUtils.identityHashCodeHex(flag);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with array")
    void testIdentityHashCodeHexWithArray() {
        int[] array = {1, 2, 3};
        String expected = Integer.toHexString(System.identityHashCode(array));
        String actual = ObjectUtils.identityHashCodeHex(array);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with null object in array")
    void testIdentityHashCodeHexWithNullObjectInArray() {
        Object[] array = new Object[3];
        String expected = Integer.toHexString(System.identityHashCode(array));
        String actual = ObjectUtils.identityHashCodeHex(array);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test identityHashCodeHex with null placeholder")
    void testIdentityHashCodeHexWithNullPlaceholder() {
        String expected = Integer.toHexString(System.identityHashCode(ObjectUtils.NULL));
        String actual = ObjectUtils.identityHashCodeHex(ObjectUtils.NULL);
        assertEquals(expected, actual);
    }
}