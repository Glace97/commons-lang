import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class makeTerminatedTest {

    @Test
    void testMakeTerminated() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        FailableStream<String> failableStream = new FailableStream<>(list.stream());

        // Test if the stream is terminated after calling makeTerminated()
        failableStream.makeTerminated();
        assertThrows(IllegalStateException.class, () -> failableStream.filter(s -> s.length() > 3));

        // Test if the stream returns the correct result after calling makeTerminated()
        List<String> result = failableStream.stream().collect(Collectors.toList());
        assertEquals(list, result);
    }
}