import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setUpToClassTest {

    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    @DisplayName("Test setting upToClass to null")
    void testSetUpToClassNull() {
        builder.setUpToClass(null);
        assertNull(builder.upToClass);
    }

    @Test
    @DisplayName("Test setting upToClass to a valid class")
    void testSetUpToClassValid() {
        builder.setUpToClass(Object.class);
        assertEquals(Object.class, builder.upToClass);
    }

    @Test
    @DisplayName("Test setting upToClass to an invalid class")
    void testSetUpToClassInvalid() {
        assertThrows(IllegalArgumentException.class, () -> builder.setUpToClass(String.class));
    }
}