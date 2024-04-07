import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToStringTest {

    private JavaVersion javaVersion;

    @BeforeEach
    void setUp() {
        javaVersion = new JavaVersion();
    }

    @Test
    void testToString() {
        String expected = "1.5";
        String actual = javaVersion.toString();
        assertEquals(expected, actual);
    }
}