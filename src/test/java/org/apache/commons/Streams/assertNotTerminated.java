import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class assertNotTerminatedTest {

    private FailableStream<String> stream;

    @BeforeEach
    void setUp() {
        stream = new FailableStream<>(Arrays.stream(new String[] { "a", "b", "c" }));
    }

    @Test
    @DisplayName("Test assertNotTerminated throws exception when the stream is terminated")
    void testAssertNotTerminatedThrowsException() {
        stream.makeTerminated();
        assertThrows(IllegalStateException.class, () -> stream.assertNotTerminated());
    }

    @Test
    @DisplayName("Test assertNotTerminated does not throw exception when the stream is not terminated")
    void testAssertNotTerminatedDoesNotThrowException() {
        stream.assertNotTerminated();
    }
}