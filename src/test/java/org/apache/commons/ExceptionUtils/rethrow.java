
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class rethrowTest {

    @Test
    void rethrow_ShouldThrowRuntimeException_WhenThrowableIsCheckedException() {
        Exception checkedException = new Exception("Checked Exception");

        Assertions.assertThrows(RuntimeException.class, () -> ExceptionUtils.rethrow(checkedException));
    }

    @Test
    void rethrow_ShouldThrowUndeclaredThrowableException_WhenThrowableIsRuntimeException() {
        RuntimeException runtimeException = new RuntimeException("Runtime Exception");

        Assertions.assertThrows(UndeclaredThrowableException.class, () -> ExceptionUtils.rethrow(runtimeException));
    }

    @Test
    void rethrow_ShouldThrowNullPointerException_WhenThrowableIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> ExceptionUtils.rethrow(null));
    }

    @Test
    void rethrow_ShouldThrowOriginalException_WhenThrowableIsError() {
        Error error = new Error("Error");

        Assertions.assertThrows(Error.class, () -> ExceptionUtils.rethrow(error));
    }

    @Test
    void rethrow_ShouldThrowOriginalException_WhenThrowableIsSubclassOfRuntimeException() {
        CustomRuntimeException customRuntimeException = new CustomRuntimeException("Custom Runtime Exception");

        Assertions.assertThrows(CustomRuntimeException.class, () -> ExceptionUtils.rethrow(customRuntimeException));
    }

    private static class CustomRuntimeException extends RuntimeException {
        public CustomRuntimeException(String message) {
            super(message);
        }
    }
}
