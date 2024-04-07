import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class hashCodeTest {
    private HashCodeBuilder hashCodeBuilder;

    @BeforeEach
    void setUp() {
        hashCodeBuilder = new HashCodeBuilder();
    }

    @Test
    void testHashCode_defaultValues() {
        int expectedHashCode = 17;
        int actualHashCode = hashCodeBuilder.hashCode();
        Assertions.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testHashCode_customValues() {
        int initialOddNumber = 3;
        int multiplierOddNumber = 5;
        hashCodeBuilder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);

        int expectedHashCode = initialOddNumber;
        int actualHashCode = hashCodeBuilder.hashCode();
        Assertions.assertEquals(expectedHashCode, actualHashCode);
    }
}