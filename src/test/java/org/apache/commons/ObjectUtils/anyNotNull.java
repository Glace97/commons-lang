
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class anyNotNullTest {

    @Test
    void testAnyNotNullWithNonNullValues() {
        assertTrue(ObjectUtils.anyNotNull("value1", "value2"));
        assertTrue(ObjectUtils.anyNotNull(1, 2, 3));
        assertTrue(ObjectUtils.anyNotNull(new Object(), new Object()));
    }

    @Test
    void testAnyNotNullWithNullValues() {
        assertFalse(ObjectUtils.anyNotNull(null, null));
        assertFalse(ObjectUtils.anyNotNull(null));
        assertFalse(ObjectUtils.anyNotNull());
    }

    @Test
    void testAnyNotNullWithMixedValues() {
        assertTrue(ObjectUtils.anyNotNull(null, "value"));
        assertTrue(ObjectUtils.anyNotNull("value", null));
        assertTrue(ObjectUtils.anyNotNull(null, 1));
        assertTrue(ObjectUtils.anyNotNull(1, null));
    }

}
