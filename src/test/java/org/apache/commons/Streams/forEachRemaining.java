
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class forEachRemainingTest {

    private Streams streams;

    @BeforeEach
    void setUp() {
        streams = new Streams();
    }

    @Nested
    @DisplayName("When there are elements in the enumeration")
    class WhenElementsExist {

        @Test
        @DisplayName("Should execute the action for each element")
        void shouldExecuteActionForEachElement() {
            // Arrange
            Enumeration<String> enumeration = mock(Enumeration.class);
            when(enumeration.hasMoreElements()).thenReturn(true, true, true, false);
            when(enumeration.nextElement()).thenReturn("one", "two", "three");

            List<String> elements = new ArrayList<>();
            streams.forEachRemaining(enumeration, elements::add);

            // Assert
            assertEquals(3, elements.size());
            assertEquals("one", elements.get(0));
            assertEquals("two", elements.get(1));
            assertEquals("three", elements.get(2));
            verify(enumeration, times(3)).nextElement();
        }
    }

    @Nested
    @DisplayName("When there are no elements in the enumeration")
    class WhenNoElementsExist {

        @Test
        @DisplayName("Should not execute the action")
        void shouldNotExecuteAction() {
            // Arrange
            Enumeration<String> enumeration = mock(Enumeration.class);
            when(enumeration.hasMoreElements()).thenReturn(false);

            List<String> elements = new ArrayList<>();
            streams.forEachRemaining(enumeration, elements::add);

            // Assert
            assertEquals(0, elements.size());
            verify(enumeration, never()).nextElement();
        }
    }

    @Nested
    @DisplayName("When the enumeration throws an exception")
    class WhenEnumerationThrowsException {

        @Test
        @DisplayName("Should throw the same exception")
        void shouldThrowSameException() {
            // Arrange
            Enumeration<String> enumeration = mock(Enumeration.class);
            when(enumeration.hasMoreElements()).thenReturn(true);
            when(enumeration.nextElement()).thenThrow(new NoSuchElementException());

            // Assert
            assertThrows(NoSuchElementException.class, () -> streams.forEachRemaining(enumeration, System.out::println));
        }
    }
}
