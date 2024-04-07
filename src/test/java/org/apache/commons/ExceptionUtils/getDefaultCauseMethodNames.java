import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class getDefaultCauseMethodNamesTest {
    private ExceptionUtils exceptionUtils = new ExceptionUtils();

    @Test
    void testGetDefaultCauseMethodNames() {
        String[] defaultCauseMethodNames = exceptionUtils.getDefaultCauseMethodNames();

        assertNotNull(defaultCauseMethodNames);
        assertEquals(12, defaultCauseMethodNames.length);
        assertArrayEquals(new String[] {
            "getCause",
            "getNextException",
            "getTargetException",
            "getException",
            "getSourceException",
            "getRootCause",
            "getCausedByException",
            "getNested",
            "getLinkedException",
            "getNestedException",
            "getLinkedCause",
            "getThrowable"
        }, defaultCauseMethodNames);
    }
}