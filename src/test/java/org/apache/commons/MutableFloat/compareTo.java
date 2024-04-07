import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class compareToTest {

    private MutableFloat mutableFloat1;
    private MutableFloat mutableFloat2;

    @BeforeEach
    void setUp() {
        mutableFloat1 = new MutableFloat(5.0f);
        mutableFloat2 = new MutableFloat(10.0f);
    }

    @Test
    @DisplayName("Test compareTo: when comparing with smaller value, should return negative")
    void testCompareToWithSmallerValue() {
        int result = mutableFloat1.compareTo(mutableFloat2);
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Test compareTo: when comparing with greater value, should return positive")
    void testCompareToWithGreaterValue() {
        int result = mutableFloat2.compareTo(mutableFloat1);
        assertTrue(result > 0);
    }

    @Test
    @DisplayName("Test compareTo: when comparing with equal value, should return zero")
    void testCompareToWithEqualValue() {
        int result = mutableFloat1.compareTo(new MutableFloat(5.0f));
        assertEquals(0, result);
    }
}