import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class getFirstContextValueTest {

    private ContextedException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    void testGetFirstContextValue_ReturnsNull_WhenLabelIsNull() {
        assertNull(exception.getFirstContextValue(null));
    }

    @Test
    void testGetFirstContextValue_ReturnsNull_WhenContextIsEmpty() {
        assertNull(exception.getFirstContextValue("label"));
    }

    @Test
    void testGetFirstContextValue_ReturnsValue_WhenLabelExistsInContext() {
        exception.exceptionContext.addContextValue("label", "value");
        assertEquals("value", exception.getFirstContextValue("label"));
    }

    @Test
    void testGetFirstContextValue_ReturnsValue_WhenLabelExistsMultipleTimesInContext() {
        exception.exceptionContext.addContextValue("label", "value1");
        exception.exceptionContext.addContextValue("label", "value2");
        assertEquals("value1", exception.getFirstContextValue("label"));
    }

    @Test
    void testGetFirstContextValue_ReturnsValue_WhenLabelExistsInParentContext() {
        ExceptionContext parentContext = new DefaultExceptionContext();
        parentContext.addContextValue("label", "parentValue");
        exception.exceptionContext.setParentContext(parentContext);
        assertEquals("parentValue", exception.getFirstContextValue("label"));
    }

    @Test
    void testGetFirstContextValue_ReturnsNull_WhenLabelDoesNotExistInContextOrParentContext() {
        assertNull(exception.getFirstContextValue("label"));
    }

    @Test
    void testGetFirstContextValue_ReturnsValue_WhenLabelExistsInParentContextButNotInCurrentContext() {
        ExceptionContext parentContext = new DefaultExceptionContext();
        parentContext.addContextValue("label", "parentValue");
        exception.exceptionContext.setParentContext(parentContext);
        exception.exceptionContext.addContextValue("otherLabel", "value");
        assertEquals("parentValue", exception.getFirstContextValue("label"));
    }
}