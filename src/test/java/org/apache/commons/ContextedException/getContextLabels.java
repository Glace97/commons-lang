import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getContextLabelsTest {

    private ContextedException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    void testEmptyContextLabels() {
        Set<String> contextLabels = exception.getContextLabels();
        assertNotNull(contextLabels);
        assertTrue(contextLabels.isEmpty());
    }

    @Test
    void testSingleContextLabel() {
        exception.exceptionContext.addContextLabel("label1");
        Set<String> contextLabels = exception.getContextLabels();
        assertNotNull(contextLabels);
        assertEquals(1, contextLabels.size());
        assertTrue(contextLabels.contains("label1"));
    }

    @Test
    void testMultipleContextLabels() {
        exception.exceptionContext.addContextLabel("label1");
        exception.exceptionContext.addContextLabel("label2");
        exception.exceptionContext.addContextLabel("label3");
        Set<String> contextLabels = exception.getContextLabels();
        assertNotNull(contextLabels);
        assertEquals(3, contextLabels.size());
        assertTrue(contextLabels.contains("label1"));
        assertTrue(contextLabels.contains("label2"));
        assertTrue(contextLabels.contains("label3"));
    }
}