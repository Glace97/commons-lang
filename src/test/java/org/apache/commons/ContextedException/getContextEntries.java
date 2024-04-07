import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getContextEntriesTest {
    
    private ContextedException exception;
    private ExceptionContext context;
    
    @BeforeEach
    void setUp() {
        context = mock(ExceptionContext.class);
        exception = new ContextedException(null, null, context);
    }
    
    @Test
    void testEmptyContextEntries() {
        when(context.getContextEntries()).thenReturn(List.of());
        
        List<Pair<String, Object>> entries = exception.getContextEntries();
        
        assertEquals(0, entries.size());
    }
    
    @Test
    void testSingleContextEntry() {
        Pair<String, Object> entry = Pair.of("key", "value");
        when(context.getContextEntries()).thenReturn(List.of(entry));
        
        List<Pair<String, Object>> entries = exception.getContextEntries();
        
        assertEquals(1, entries.size());
        assertEquals(entry, entries.get(0));
    }
    
    @Test
    void testMultipleContextEntries() {
        Pair<String, Object> entry1 = Pair.of("key1", "value1");
        Pair<String, Object> entry2 = Pair.of("key2", "value2");
        Pair<String, Object> entry3 = Pair.of("key3", "value3");
        when(context.getContextEntries()).thenReturn(List.of(entry1, entry2, entry3));
        
        List<Pair<String, Object>> entries = exception.getContextEntries();
        
        assertEquals(3, entries.size());
        assertEquals(entry1, entries.get(0));
        assertEquals(entry2, entries.get(1));
        assertEquals(entry3, entries.get(2));
    }
    
    @Test
    void testNullContext() {
        exception = new ContextedException(null, null, null);
        
        List<Pair<String, Object>> entries = exception.getContextEntries();
        
        assertEquals(0, entries.size());
    }
}