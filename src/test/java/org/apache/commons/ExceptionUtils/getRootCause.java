import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;

class getRootCauseTest {

    @Test
    void testGetRootCause_NullThrowable_ReturnsNull() {
        Throwable throwable = null;
        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        assertNull(rootCause);
    }

    @Test
    void testGetRootCause_NoCause_ReturnsThrowable() {
        Throwable throwable = new Throwable("Test Exception");
        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        assertEquals(throwable, rootCause);
    }

    @Test
    void testGetRootCause_SingleCause_ReturnsRootCause() {
        Throwable cause = new RuntimeException("Cause Exception");
        Throwable throwable = new Throwable(cause);
        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        assertEquals(cause, rootCause);
    }

    @Test
    void testGetRootCause_MultipleCauses_ReturnsRootCause() {
        Throwable cause1 = new RuntimeException("Cause 1 Exception");
        Throwable cause2 = new NullPointerException("Cause 2 Exception");
        Throwable throwable = new Throwable(cause1);
        cause1.initCause(cause2);
        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        assertEquals(cause2, rootCause);
    }

    @Test
    void testGetRootCause_CircularCauses_ReturnsElementBeforeLoop() {
        Throwable cause1 = new RuntimeException("Cause 1 Exception");
        Throwable cause2 = new NullPointerException("Cause 2 Exception");
        Throwable throwable = new Throwable(cause1);
        cause1.initCause(cause2);
        cause2.initCause(throwable);
        Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        assertEquals(cause1, rootCause);
    }
}