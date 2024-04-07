import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class toArrayTest {
    
    @Test
    void testEmptyList() {
        List<Integer> list = new ArrayList<>();
        Integer[] expected = new Integer[0];
        Integer[] actual = Streams.of(list.iterator()).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testSingleElementList() {
        List<Integer> list = Arrays.asList(5);
        Integer[] expected = {5};
        Integer[] actual = Streams.of(list.iterator()).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testMultipleElementList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] actual = Streams.of(list.iterator()).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testEmptySet() {
        Set<String> set = new HashSet<>();
        String[] expected = new String[0];
        String[] actual = Streams.of(set.iterator()).toArray(String.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testSingleElementSet() {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        String[] expected = {"Hello"};
        String[] actual = Streams.of(set.iterator()).toArray(String.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testMultipleElementSet() {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("!");
        String[] expected = {"Hello", "World", "!"};
        String[] actual = Streams.of(set.iterator()).toArray(String.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testEmptyEnumeration() {
        Enumeration<Integer> enumeration = Collections.emptyEnumeration();
        Integer[] expected = new Integer[0];
        Integer[] actual = Streams.of(enumeration).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testSingleElementEnumeration() {
        Enumeration<Integer> enumeration = Collections.enumeration(Arrays.asList(10));
        Integer[] expected = {10};
        Integer[] actual = Streams.of(enumeration).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    void testMultipleElementEnumeration() {
        Enumeration<Integer> enumeration = Collections.enumeration(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] actual = Streams.of(enumeration).toArray(Integer.class);
        Assertions.assertArrayEquals(expected, actual);
    }
}