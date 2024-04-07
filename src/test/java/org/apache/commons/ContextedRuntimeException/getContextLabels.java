import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getContextLabelsTest {

    private ContextedRuntimeException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedRuntimeException();
    }

    @Test
    void testEmptyContextLabels() {
        Set<String> expected = new HashSet<>();
        Set<String> actual = exception.getContextLabels();
        assertEquals(expected, actual);
    }

    @Test
    void testNonEmptyContextLabels() {
        exception.exceptionContext.addContextLabel("label1");
        exception.exceptionContext.addContextLabel("label2");

        Set<String> expected = new HashSet<>();
        expected.add("label1");
        expected.add("label2");

        Set<String> actual = exception.getContextLabels();
        assertEquals(expected, actual);
    }

    @Test
    void testNullContextLabels() {
        exception.exceptionContext = null;

        Set<String> expected = new HashSet<>();
        Set<String> actual = exception.getContextLabels();
        assertEquals(expected, actual);
    }

    @Test
    void testContextLabelsInheritedFromSuperclass() {
        exception.exceptionContext.addContextLabel("label1");
        exception.exceptionContext.addContextLabel("label2");

        String message = "Test Message";
        Throwable cause = new Throwable();
        ContextedRuntimeException exceptionWithCause = new ContextedRuntimeException(message, cause);

        Set<String> expected = new HashSet<>();
        expected.add("label1");
        expected.add("label2");

        Set<String> actual = exceptionWithCause.getContextLabels();
        assertEquals(expected, actual);
    }

    @Test
    void testContextLabelsInheritedFromSuperclassWithNullContext() {
        exception.exceptionContext.addContextLabel("label1");
        exception.exceptionContext.addContextLabel("label2");

        String message = "Test Message";
        Throwable cause = new Throwable();
        ContextedRuntimeException exceptionWithNullContext = new ContextedRuntimeException(message, cause, null);

        Set<String> expected = new HashSet<>();
        expected.add("label1");
        expected.add("label2");

        Set<String> actual = exceptionWithNullContext.getContextLabels();
        assertEquals(expected, actual);
    }
}