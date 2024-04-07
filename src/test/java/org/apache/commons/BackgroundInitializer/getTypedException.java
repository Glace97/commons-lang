import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class getTypedExceptionTest {

    @Test
    void testGetTypedException() {
        BackgroundInitializer backgroundInitializer = new BackgroundInitializer();
        Exception exception = new Exception("Test Exception");
        Exception typedException = backgroundInitializer.getTypedException(exception);
        
        assertTrue(typedException instanceof Exception);
        assertEquals(exception, typedException);
    }
}