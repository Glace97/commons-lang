import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class isCheckedTest {

    @Test
    void isChecked_NullInput_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(null));
    }

    @Test
    void isChecked_RuntimeException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new RuntimeException()));
    }

    @Test
    void isChecked_Error_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new Error()));
    }

    @Test
    void isChecked_CheckedSubclass_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new Exception()));
    }

    @Test
    void isChecked_UncheckedSubclass_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new IllegalArgumentException()));
    }

    @Test
    void isChecked_CustomCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new CustomCheckedException()));
    }

    @Test
    void isChecked_CustomUncheckedException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new CustomUncheckedException()));
    }

    @Test
    void isChecked_CustomError_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new CustomError()));
    }

    private static class CustomCheckedException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    private static class CustomUncheckedException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

    private static class CustomError extends Error {
        private static final long serialVersionUID = 1L;
    }
}