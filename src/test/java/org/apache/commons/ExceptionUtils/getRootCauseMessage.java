import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class getRootCauseMessageTest {

    @Test
    void testGetRootCauseMessage_NullInput_ReturnsEmptyString() {
        String result = ExceptionUtils.getRootCauseMessage(null);
        Assertions.assertEquals("", result);
    }

    @Test
    void testGetRootCauseMessage_NoRootCause_ReturnsThrowableMessage() {
        Throwable throwable = new Throwable("Test Exception");
        String result = ExceptionUtils.getRootCauseMessage(throwable);
        Assertions.assertEquals("Throwable: Test Exception", result);
    }

    @Test
    void testGetRootCauseMessage_WithRootCause_ReturnsRootCauseMessage() {
        Throwable rootCause = new RuntimeException("Root Cause");
        Throwable throwable = new Exception("Test Exception", rootCause);
        String result = ExceptionUtils.getRootCauseMessage(throwable);
        Assertions.assertEquals("RuntimeException: Root Cause", result);
    }

    @Test
    void testGetRootCauseMessage_WithNestedRootCause_ReturnsRootCauseMessage() {
        Throwable nestedRootCause = new IllegalArgumentException("Nested Root Cause");
        Throwable rootCause = new RuntimeException("Root Cause", nestedRootCause);
        Throwable throwable = new Exception("Test Exception", rootCause);
        String result = ExceptionUtils.getRootCauseMessage(throwable);
        Assertions.assertEquals("IllegalArgumentException: Nested Root Cause", result);
    }

    @Test
    void testGetRootCauseMessage_WithMultipleNestedRootCauses_ReturnsRootCauseMessage() {
        Throwable nestedRootCause1 = new IllegalArgumentException("Nested Root Cause 1");
        Throwable nestedRootCause2 = new NullPointerException("Nested Root Cause 2");
        Throwable rootCause = new RuntimeException("Root Cause", nestedRootCause1);
        Throwable throwable = new Exception("Test Exception", rootCause);
        String result = ExceptionUtils.getRootCauseMessage(throwable);
        Assertions.assertEquals("IllegalArgumentException: Nested Root Cause 1", result);
    }

    @Test
    void testGetRootCauseMessage_WithCircularReference_ReturnsRootCauseMessage() {
        Throwable rootCause = new RuntimeException("Root Cause");
        Throwable throwable = new Exception("Test Exception", rootCause);
        rootCause.initCause(throwable);
        String result = ExceptionUtils.getRootCauseMessage(throwable);
        Assertions.assertEquals("RuntimeException: Root Cause", result);
    }
}