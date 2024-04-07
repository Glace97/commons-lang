import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class isUncheckedTest {
    
    @Test
    void testIsUncheckedWithNull() {
        assertFalse(ExceptionUtils.isUnchecked(null));
    }
    
    @Test
    void testIsUncheckedWithError() {
        assertTrue(ExceptionUtils.isUnchecked(new Error()));
    }
    
    @Test
    void testIsUncheckedWithRuntimeException() {
        assertTrue(ExceptionUtils.isUnchecked(new RuntimeException()));
    }
    
    @Test
    void testIsUncheckedWithException() {
        assertFalse(ExceptionUtils.isUnchecked(new Exception()));
    }
    
    @Test
    void testIsUncheckedWithThrowable() {
        assertFalse(ExceptionUtils.isUnchecked(new Throwable()));
    }
    
    @Test
    void testIsUncheckedWithCustomUncheckedException() {
        class CustomUncheckedException extends RuntimeException {
            private static final long serialVersionUID = 1L;
        }
        
        assertTrue(ExceptionUtils.isUnchecked(new CustomUncheckedException()));
    }
    
    @Test
    void testIsUncheckedWithCustomCheckedException() {
        class CustomCheckedException extends Exception {
            private static final long serialVersionUID = 1L;
        }
        
        assertFalse(ExceptionUtils.isUnchecked(new CustomCheckedException()));
    }
    
}