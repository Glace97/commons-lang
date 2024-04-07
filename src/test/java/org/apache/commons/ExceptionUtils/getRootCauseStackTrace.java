import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getRootCauseStackTraceTest {
    
    private ExceptionUtils exceptionUtils;
    
    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }
    
    @Nested
    @DisplayName("Tests for getRootCauseStackTrace")
    class GetRootCauseStackTraceTests {
        
        @Test
        @DisplayName("Should return an empty array when throwable is null")
        void testGetRootCauseStackTraceWithNullThrowable() {
            // Arrange
            Throwable throwable = null;
            
            // Act
            String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
            
            // Assert
            assertNotNull(result);
            assertEquals(0, result.length);
        }
        
        @Test
        @DisplayName("Should return an array with a single element when throwable has no cause")
        void testGetRootCauseStackTraceWithNoCause() {
            // Arrange
            Throwable throwable = new Throwable("Test Exception");
            
            // Act
            String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
            
            // Assert
            assertNotNull(result);
            assertEquals(1, result.length);
            assertEquals("java.lang.Throwable: Test Exception", result[0]);
        }
        
        @Test
        @DisplayName("Should return an array with all stack trace frames when throwable has a cause")
        void testGetRootCauseStackTraceWithCause() {
            // Arrange
            Throwable cause = new RuntimeException("Cause Exception");
            Throwable throwable = new Exception("Test Exception", cause);
            
            // Act
            String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
            
            // Assert
            assertNotNull(result);
            assertEquals(3, result.length);
            assertEquals("java.lang.Exception: Test Exception", result[0]);
            assertEquals(" [wrapped] ", result[1]);
            assertEquals("java.lang.RuntimeException: Cause Exception", result[2]);
        }
        
        @Test
        @DisplayName("Should return an array with all stack trace frames when throwable has multiple causes")
        void testGetRootCauseStackTraceWithMultipleCauses() {
            // Arrange
            Throwable cause1 = new RuntimeException("Cause Exception 1");
            Throwable cause2 = new NullPointerException("Cause Exception 2");
            Throwable throwable = new Exception("Test Exception", cause1);
            throwable.initCause(cause2);
            
            // Act
            String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
            
            // Assert
            assertNotNull(result);
            assertEquals(5, result.length);
            assertEquals("java.lang.Exception: Test Exception", result[0]);
            assertEquals(" [wrapped] ", result[1]);
            assertEquals("java.lang.RuntimeException: Cause Exception 1", result[2]);
            assertEquals(" [wrapped] ", result[3]);
            assertEquals("java.lang.NullPointerException: Cause Exception 2", result[4]);
        }
    }
}