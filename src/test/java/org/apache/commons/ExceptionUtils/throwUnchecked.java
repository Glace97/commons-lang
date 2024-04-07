
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThrowUncheckedTest {

    @Test
    void testThrowUnchecked_withRuntimeException_shouldThrowRuntimeException() {
        RuntimeException exception = new RuntimeException("Test RuntimeException");
        Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.throwUnchecked(exception));
    }

    @Test
    void testThrowUnchecked_withError_shouldThrowError() {
        Error error = new Error("Test Error");
        Assertions.assertThrows(Error.class, () -> ExceptionUtils.throwUnchecked(error));
    }

    @Test
    void testThrowUnchecked_withCheckedException_shouldThrowUndeclaredThrowableException() {
        Exception exception = new Exception("Test Exception");
        Assertions.assertThrows(UndeclaredThrowableException.class, () -> ExceptionUtils.throwUnchecked(exception));
    }

    @Test
    void testThrowUnchecked_withUncheckedException_shouldNotThrowException() {
        IllegalArgumentException exception = new IllegalArgumentException("Test IllegalArgumentException");
        Assertions.assertDoesNotThrow(() -> ExceptionUtils.throwUnchecked(exception));
    }

}
