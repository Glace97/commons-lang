import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class getLeftTest {

    DiffResult<String> diffResult;

    @BeforeEach
    void setUp() {
        List<Diff<?>> diffList = new ArrayList<>();
        String lhs = "left";
        String rhs = "right";
        ToStringStyle style = ToStringStyle.DEFAULT_STYLE;
        String toStringFormat = "%s differs from %s";
        diffResult = new DiffResult<>(lhs, rhs, diffList, style, toStringFormat);
    }

    @Nested
    @DisplayName("When getLeft is called")
    class WhenGetLeft {

        @Test
        @DisplayName("should return the left-hand side object")
        void shouldReturnLeftObject() {
            assertEquals("left", diffResult.getLeft());
        }
    }
}