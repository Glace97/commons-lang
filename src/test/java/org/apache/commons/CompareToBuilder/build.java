import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class buildTest {

    @Test
    void testBuild() {
        // Test case 1: comparison is 0
        CompareToBuilder builder1 = new CompareToBuilder();
        assertEquals(0, builder1.build());

        // Test case 2: comparison is negative
        CompareToBuilder builder2 = new CompareToBuilder();
        builder2.comparison = -1;
        assertEquals(-1, builder2.build());

        // Test case 3: comparison is positive
        CompareToBuilder builder3 = new CompareToBuilder();
        builder3.comparison = 1;
        assertEquals(1, builder3.build());
    }
}