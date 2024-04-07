import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValuesTest {

    private BooleanUtils booleanUtils;

    @BeforeEach
    void setUp() {
        booleanUtils = new BooleanUtils();
    }

    @Test
    @DisplayName("Test values method")
    void testValues() {
        List<Boolean> expected = List.of(false, true);
        List<Boolean> actual = booleanUtils.values();
        assertEquals(expected, actual);
    }
}