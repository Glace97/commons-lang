import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class getContextLabelsTest {

    DefaultExceptionContext context;

    @BeforeEach
    void setUp() {
        context = new DefaultExceptionContext();
    }

    @Test
    void testEmptyContext() {
        Set<String> expectedLabels = new HashSet<>();
        Set<String> actualLabels = context.getContextLabels();
        assertEquals(expectedLabels, actualLabels);
    }

    @Test
    void testContextWithOneLabel() {
        context.contextValues.add(new ImmutablePair<>("label1", "data1"));

        Set<String> expectedLabels = new HashSet<>();
        expectedLabels.add("label1");

        Set<String> actualLabels = context.getContextLabels();
        assertEquals(expectedLabels, actualLabels);
    }

    @Test
    void testContextWithMultipleLabels() {
        context.contextValues.add(new ImmutablePair<>("label1", "data1"));
        context.contextValues.add(new ImmutablePair<>("label2", "data2"));
        context.contextValues.add(new ImmutablePair<>("label3", "data3"));

        Set<String> expectedLabels = new HashSet<>();
        expectedLabels.add("label1");
        expectedLabels.add("label2");
        expectedLabels.add("label3");

        Set<String> actualLabels = context.getContextLabels();
        assertEquals(expectedLabels, actualLabels);
    }

    @Test
    void testContextWithDuplicateLabels() {
        context.contextValues.add(new ImmutablePair<>("label1", "data1"));
        context.contextValues.add(new ImmutablePair<>("label1", "data2"));
        context.contextValues.add(new ImmutablePair<>("label2", "data3"));

        Set<String> expectedLabels = new HashSet<>();
        expectedLabels.add("label1");
        expectedLabels.add("label2");

        Set<String> actualLabels = context.getContextLabels();
        assertEquals(expectedLabels, actualLabels);
    }
}