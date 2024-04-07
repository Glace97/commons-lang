import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setAppendTransientsTest {

    @Test
    void testSetAppendTransients_True() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        builder.setAppendTransients(true);
        assertTrue(builder.appendTransients);
    }

    @Test
    void testSetAppendTransients_False() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        builder.setAppendTransients(false);
        assertFalse(builder.appendTransients);
    }
}