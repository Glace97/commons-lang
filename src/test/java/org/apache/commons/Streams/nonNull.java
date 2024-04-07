
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class nonNullTest {

    @Test
    @DisplayName("Test nonNull with collection containing null elements")
    void testNonNullWithCollectionContainingNullElements() {
        Collection<String> collection = Arrays.asList("a", null, "b", null, "c");
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(collection).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with collection containing no null elements")
    void testNonNullWithCollectionContainingNoNullElements() {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(collection).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with empty collection")
    void testNonNullWithEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        
        List<String> actual = Streams.nonNull(collection).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with array containing null elements")
    void testNonNullWithArrayContainingNullElements() {
        String[] array = {"a", null, "b", null, "c"};
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(array).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with array containing no null elements")
    void testNonNullWithArrayContainingNoNullElements() {
        String[] array = {"a", "b", "c"};
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(array).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with empty array")
    void testNonNullWithEmptyArray() {
        String[] array = new String[0];
        List<String> expected = new ArrayList<>();
        
        List<String> actual = Streams.nonNull(array).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with stream containing null elements")
    void testNonNullWithStreamContainingNullElements() {
        Stream<String> stream = Stream.of("a", null, "b", null, "c");
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(stream).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with stream containing no null elements")
    void testNonNullWithStreamContainingNoNullElements() {
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");
        
        List<String> actual = Streams.nonNull(stream).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test nonNull with empty stream")
    void testNonNullWithEmptyStream() {
        Stream<String> stream = Stream.empty();
        List<String> expected = new ArrayList<>();
        
        List<String> actual = Streams.nonNull(stream).collect(Collectors.toList());
        
        assertEquals(expected, actual);
    }
}
