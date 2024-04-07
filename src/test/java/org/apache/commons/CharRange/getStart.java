
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getStartTest {

    @Test
    void testGetStart() {
        // Test when start is less than end
        CharRange range1 = new CharRange('a', 'z', false);
        Assertions.assertEquals('a', range1.getStart());

        // Test when start is greater than end
        CharRange range2 = new CharRange('z', 'a', false);
        Assertions.assertEquals('a', range2.getStart());

        // Test when start and end are the same
        CharRange range3 = new CharRange('a', 'a', false);
        Assertions.assertEquals('a', range3.getStart());

        // Test negated range
        CharRange range4 = new CharRange('a', 'z', true);
        Assertions.assertEquals('a', range4.getStart());
    }

}
