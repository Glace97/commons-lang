import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class getIncludeFieldNamesTest {
    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setup() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void testGetIncludeFieldNames() {
        String[] expected = {};
        String[] actual = builder.getIncludeFieldNames();
        assertArrayEquals(expected, actual);
    }
}