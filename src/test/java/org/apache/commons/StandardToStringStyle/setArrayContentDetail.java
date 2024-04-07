import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class setArrayContentDetailTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Nested
    @DisplayName("When setting array content detail to true")
    class SetArrayContentDetailTrue {

        @Test
        @DisplayName("should set arrayContentDetail flag to true")
        void shouldSetArrayContentDetailToTrue() {
            style.setArrayContentDetail(true);
            assertTrue(style.getArrayContentDetail());
        }
    }

    @Nested
    @DisplayName("When setting array content detail to false")
    class SetArrayContentDetailFalse {

        @Test
        @DisplayName("should set arrayContentDetail flag to false")
        void shouldSetArrayContentDetailToFalse() {
            style.setArrayContentDetail(false);
            assertFalse(style.getArrayContentDetail());
        }
    }
}