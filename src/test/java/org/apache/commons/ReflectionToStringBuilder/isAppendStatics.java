import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAppendStaticsTest {

    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Nested
    @DisplayName("isAppendStatics method")
    class isAppendStaticsMethod {

        @Test
        @DisplayName("should return false by default")
        void shouldReturnFalseByDefault() {
            assertFalse(builder.isAppendStatics());
        }

        @Test
        @DisplayName("should return true after setting it to true")
        void shouldReturnTrueAfterSettingToTrue() {
            builder.setAppendStatics(true);
            assertTrue(builder.isAppendStatics());
        }
    }
}