import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAppendTransientsTest {
    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void isAppendTransients_ShouldReturnFalse_WhenDefaultConstructorCalled() {
        assertFalse(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnTrue_WhenSetToTrue() {
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }

    @Test
    void isAppendTransients_ShouldReturnFalse_WhenSetToFalse() {
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }
}