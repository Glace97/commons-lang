
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToStringTest {

    @Test
    void testToStringWithNullArray() {
        Object array = null;
        String expected = "{}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringWithEmptyArray() {
        Object array = new Object[0];
        String expected = "{}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringWithBooleanArray() {
        boolean[] array = {true, false, true};
        String expected = "{true, false, true}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringWithByteArray() {
        byte[] array = {1, 2, 3};
        String expected = "{1, 2, 3}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    // Repeat the same test method for all other primitive array types

    @Test
    void testToStringWithObjectArray() {
        Object[] array = {"a", "b", "c"};
        String expected = "{\"a\", \"b\", \"c\"}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    // Repeat the same test method for all other Object array types

    @Test
    void testToStringWithMultiDimensionalArray() {
        Object[][] array = {{"a", "b"}, {"c", "d"}};
        String expected = "{{\"a\", \"b\"}, {\"c\", \"d\"}}";
        String actual = ArrayUtils.toString(array);
        Assertions.assertEquals(expected, actual);
    }

    // Add more test methods to cover edge cases and achieve high coverage

}
