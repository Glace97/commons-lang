import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class allNotNullTest {
    @Test
    void testAllNotNull() {
        // Test case: values is null
        assertFalse(ObjectUtils.allNotNull(null));

        // Test case: values is empty
        assertTrue(ObjectUtils.allNotNull());

        // Test case: values contains null
        assertFalse(ObjectUtils.allNotNull(null, "value1", "value2"));

        // Test case: values contains no null
        assertTrue(ObjectUtils.allNotNull("value1", "value2", "value3"));

        // Test case: values contains both null and non-null values
        assertFalse(ObjectUtils.allNotNull("value1", null, "value2"));

        // Test case: values contains multiple null values
        assertFalse(ObjectUtils.allNotNull(null, "value1", null, "value2"));

        // Test case: values contains only null values
        assertFalse(ObjectUtils.allNotNull(null, null, null));

        // Test case: values contains only non-null values
        assertTrue(ObjectUtils.allNotNull("value1", "value2", "value3", "value4"));

        // Test case: values contains multiple types of objects
        assertFalse(ObjectUtils.allNotNull("value1", 123, new Object(), "value2"));

        // Test case: values contains arrays
        assertFalse(ObjectUtils.allNotNull("value1", new int[]{1, 2, 3}, "value2"));
    }
}