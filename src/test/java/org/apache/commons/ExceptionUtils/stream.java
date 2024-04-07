import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StreamTest {

    @Nested
    @DisplayName("stream method")
    class StreamMethodTests {
        
        @Test
        @DisplayName("Stream is not null")
        void testStreamNotNull() {
            Stream<Throwable> stream = ExceptionUtils.stream(new Throwable());
            assertNotNull(stream);
        }
        
        @Test
        @DisplayName("Stream contains expected number of elements")
        void testStreamSize() {
            Stream<Throwable> stream = ExceptionUtils.stream(new Throwable());
            assertEquals(1, stream.count());
        }
        
        @Test
        @DisplayName("Stream contains Throwable")
        void testStreamContainsThrowable() {
            Stream<Throwable> stream = ExceptionUtils.stream(new Throwable());
            assertTrue(stream.anyMatch(Objects::nonNull));
        }
        
        @Test
        @DisplayName("Stream contains cause Throwable")
        void testStreamContainsCauseThrowable() {
            Throwable cause = new Throwable();
            Throwable throwable = new Throwable(cause);
            
            Stream<Throwable> stream = ExceptionUtils.stream(throwable);
            assertTrue(stream.anyMatch(t -> t == cause));
        }
        
        @Test
        @DisplayName("Stream is empty for null Throwable")
        void testStreamEmptyForNullThrowable() {
            Stream<Throwable> stream = ExceptionUtils.stream(null);
            assertEquals(0, stream.count());
        }
    }
}