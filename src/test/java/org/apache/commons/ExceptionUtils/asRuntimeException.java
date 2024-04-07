import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class asRuntimeExceptionTest {

    private ExceptionUtils exceptionUtils;

    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }

    @Test
    void testAsRuntimeException_withCheckedException_shouldThrowRuntimeException() {
        Exception checkedException = new Exception("Checked Exception");
        
        assertThrows(RuntimeException.class, () -> exceptionUtils.asRuntimeException(checkedException));
    }

    @Test
    void testAsRuntimeException_withRuntimeException_shouldNotThrowException() {
        RuntimeException runtimeException = new RuntimeException("Runtime Exception");

        assertDoesNotThrow(() -> exceptionUtils.asRuntimeException(runtimeException));
    }

    @Test
    void testAsRuntimeException_withError_shouldNotThrowException() {
        Error error = new Error("Error");

        assertDoesNotThrow(() -> exceptionUtils.asRuntimeException(error));
    }

    @Test
    void testAsRuntimeException_withThrowable_shouldThrowRuntimeException() {
        Throwable throwable = new Throwable("Throwable");

        assertThrows(RuntimeException.class, () -> exceptionUtils.asRuntimeException(throwable));
    }

    @Test
    void testAsRuntimeException_withNullThrowable_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> exceptionUtils.asRuntimeException(null));
    }
}