import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class forEachTest {

    private forEach forEachInstance;
    private List<String> list;

    @BeforeEach
    void setUp() {
        forEachInstance = new forEach();
        list = new ArrayList<>();
    }

    @Test
    void testForEach_emptyList() {
        forEachInstance.forEach(list, System.out::println);
        assertTrue(list.isEmpty());
    }

    @Test
    void testForEach_oneElement() {
        list.add("element");
        forEachInstance.forEach(list, System.out::println);
        assertEquals(1, list.size());
        assertEquals("element", list.get(0));
    }

    @Test
    void testForEach_multipleElements() {
        list.add("element1");
        list.add("element2");
        list.add("element3");
        forEachInstance.forEach(list, System.out::println);
        assertEquals(3, list.size());
        assertEquals("element1", list.get(0));
        assertEquals("element2", list.get(1));
        assertEquals("element3", list.get(2));
    }

    @Test
    void testForEach_nullAction() {
        list.add("element");
        assertThrows(NullPointerException.class, () -> forEachInstance.forEach(list, null));
    }

    @Test
    void testForEach_mockAction() {
        list.add("element1");
        list.add("element2");
        list.add("element3");

        Consumer<String> action = mock(Consumer.class);
        forEachInstance.forEach(list, action);

        verify(action, times(3)).accept(anyString());
        verify(action).accept("element1");
        verify(action).accept("element2");
        verify(action).accept("element3");
    }

    @Test
    void testForEach_emptyEnumeration() {
        Enumeration<String> enumeration = mock(Enumeration.class);
        forEachInstance.forEach(enumeration, System.out::println);
        verify(enumeration, never()).hasMoreElements();
        verify(enumeration, never()).nextElement();
    }

    @Test
    void testForEach_oneElementEnumeration() {
        Enumeration<String> enumeration = mock(Enumeration.class);
        when(enumeration.hasMoreElements()).thenReturn(true);
        when(enumeration.nextElement()).thenReturn("element");

        forEachInstance.forEach(enumeration, System.out::println);

        verify(enumeration).hasMoreElements();
        verify(enumeration).nextElement();
    }

    @Test
    void testForEach_multipleElementsEnumeration() {
        Enumeration<String> enumeration = mock(Enumeration.class);
        when(enumeration.hasMoreElements()).thenReturn(true, true, true, false);
        when(enumeration.nextElement()).thenReturn("element1", "element2", "element3");

        forEachInstance.forEach(enumeration, System.out::println);

        verify(enumeration, times(4)).hasMoreElements();
        verify(enumeration, times(3)).nextElement();
    }

    @Test
    void testForEach_nullEnumeration() {
        assertThrows(NullPointerException.class, () -> forEachInstance.forEach(null, System.out::println));
    }

    @Test
    void testForEach_nullEnumerationAction() {
        Enumeration<String> enumeration = mock(Enumeration.class);
        when(enumeration.hasMoreElements()).thenReturn(true);
        when(enumeration.nextElement()).thenReturn("element");

        assertThrows(NullPointerException.class, () -> forEachInstance.forEach(enumeration, null));
    }

    @Test
    void testForEach_emptyIterator() {
        Iterator<String> iterator = mock(Iterator.class);
        forEachInstance.forEach(iterator, System.out::println);
        verify(iterator, never()).hasNext();
        verify(iterator, never()).next();
    }

    @Test
    void testForEach_oneElementIterator() {
        Iterator<String> iterator = mock(Iterator.class);
        when(iterator.hasNext()).thenReturn(true);
        when(iterator.next()).thenReturn("element");

        forEachInstance.forEach(iterator, System.out::println);

        verify(iterator).hasNext();
        verify(iterator).next();
    }

    @Test
    void testForEach_multipleElementsIterator() {
        Iterator<String> iterator = mock(Iterator.class);
        when(iterator.hasNext()).thenReturn(true, true, true, false);
        when(iterator.next()).thenReturn("element1", "element2", "element3");

        forEachInstance.forEach(iterator, System.out::println);

        verify(iterator, times(4)).hasNext();
        verify(iterator, times(3)).next();
    }

    @Test
    void testForEach_nullIterator() {
        assertThrows(NullPointerException.class, () -> forEachInstance.forEach(null, System.out::println));
    }

    @Test
    void testForEach_nullIteratorAction() {
        Iterator<String> iterator = mock(Iterator.class);
        when(iterator.hasNext()).thenReturn(true);
        when(iterator.next()).thenReturn("element");

        assertThrows(NullPointerException.class, () -> forEachInstance.forEach(iterator, null));
    }
}