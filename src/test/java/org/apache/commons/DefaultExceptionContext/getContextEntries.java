import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class getContextEntriesTest {

    private DefaultExceptionContext defaultContext;

    @BeforeEach
    public void setUp() {
        defaultContext = new DefaultExceptionContext();
    }

    @Test
    @DisplayName("Test getContextEntries returns correct list")
    public void testGetContextEntriesReturnsCorrectList() {
        List<Pair<String, Object>> contextEntries = defaultContext.getContextEntries();
        assertEquals(0, contextEntries.size());
    }

    @Test
    @DisplayName("Test getContextEntries adds entries correctly")
    public void testGetContextEntriesAddsEntriesCorrectly() {
        Pair<String, Object> entry1 = ImmutablePair.of("key1", "value1");
        Pair<String, Object> entry2 = ImmutablePair.of("key2", 123);
        Pair<String, Object> entry3 = ImmutablePair.of("key3", true);

        defaultContext.contextValues.add(entry1);
        defaultContext.contextValues.add(entry2);
        defaultContext.contextValues.add(entry3);

        List<Pair<String, Object>> contextEntries = defaultContext.getContextEntries();
        assertEquals(3, contextEntries.size());
        assertTrue(contextEntries.contains(entry1));
        assertTrue(contextEntries.contains(entry2));
        assertTrue(contextEntries.contains(entry3));
    }

    @Test
    @DisplayName("Test getContextEntries returns a defensive copy")
    public void testGetContextEntriesReturnsDefensiveCopy() {
        Pair<String, Object> entry1 = ImmutablePair.of("key1", "value1");
        Pair<String, Object> entry2 = ImmutablePair.of("key2", 123);
        Pair<String, Object> entry3 = ImmutablePair.of("key3", true);

        defaultContext.contextValues.add(entry1);
        defaultContext.contextValues.add(entry2);
        defaultContext.contextValues.add(entry3);

        List<Pair<String, Object>> contextEntries = defaultContext.getContextEntries();

        // Modify the original list
        defaultContext.contextValues.clear();

        assertEquals(3, contextEntries.size());
        assertTrue(contextEntries.contains(entry1));
        assertTrue(contextEntries.contains(entry2));
        assertTrue(contextEntries.contains(entry3));
    }

}