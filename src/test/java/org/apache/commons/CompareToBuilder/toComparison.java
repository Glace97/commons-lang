import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toComparisonTest {

    @Test
    void testEqualObjects() {
        CompareToBuilder builder = new CompareToBuilder();
        int result = builder.toComparison();
        assertEquals(0, result);
    }

    @Test
    void testLessThan() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append fields to make left-hand side less than right-hand side
        builder.append(1, 2);
        int result = builder.toComparison();
        assertTrue(result < 0);
    }

    @Test
    void testGreaterThan() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append fields to make left-hand side greater than right-hand side
        builder.append(2, 1);
        int result = builder.toComparison();
        assertTrue(result > 0);
    }

    @Test
    void testNullComparison() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append null fields to test null comparison
        builder.append(null, null);
        int result = builder.toComparison();
        assertEquals(0, result);
    }

    @Test
    void testNullLessThan() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append null as left-hand side to test null comparison
        builder.append(null, 1);
        int result = builder.toComparison();
        assertTrue(result < 0);
    }

    @Test
    void testNullGreaterThan() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append null as right-hand side to test null comparison
        builder.append(1, null);
        int result = builder.toComparison();
        assertTrue(result > 0);
    }

    @Test
    void testDifferentTypes() {
        CompareToBuilder builder = new CompareToBuilder();
        // Append fields of different types to test type comparison
        builder.append(1, "1");
        int result = builder.toComparison();
        assertTrue(result < 0);
    }
}
