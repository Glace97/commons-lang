import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class hashCodeHexTest {

    @Test
    void testHashCodeHexWithNullObject() {
        String expected = "0";
        String actual = ObjectUtils.hashCodeHex(null);
        assertEquals(expected, actual, "Hash code of null object should be '0'");
    }

    @Test
    void testHashCodeHexWithNonNullObject() {
        String expected = Integer.toHexString(123456);
        String actual = ObjectUtils.hashCodeHex(123456);
        assertEquals(expected, actual, "Hash code of non-null object should be hexadecimal representation of its hash code");
    }

    @Test
    void testHashCodeHexWithDifferentObjects() {
        String expected1 = Integer.toHexString(123);
        String actual1 = ObjectUtils.hashCodeHex(123);
        assertEquals(expected1, actual1, "Hash code of object 123 should be hexadecimal representation of its hash code");

        String expected2 = Integer.toHexString("abc".hashCode());
        String actual2 = ObjectUtils.hashCodeHex("abc");
        assertEquals(expected2, actual2, "Hash code of object 'abc' should be hexadecimal representation of its hash code");

        Map<String, Integer> map = new HashMap<>();
        map.put("key", 456);
        String expected3 = Integer.toHexString(map.hashCode());
        String actual3 = ObjectUtils.hashCodeHex(map);
        assertEquals(expected3, actual3, "Hash code of object map should be hexadecimal representation of its hash code");
    }
}