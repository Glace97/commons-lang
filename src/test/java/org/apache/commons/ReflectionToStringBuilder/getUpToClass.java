
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getUpToClassTest {
    private ReflectionToStringBuilder reflectionToStringBuilder;

    @BeforeEach
    void setUp() {
        reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void testGetUpToClass() {
        assertNull(reflectionToStringBuilder.getUpToClass());
    }
}
