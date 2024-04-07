import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toHashCodeTest {
    private HashCodeBuilder hashCodeBuilder;

    @BeforeEach
    void setUp() {
        hashCodeBuilder = new HashCodeBuilder();
    }

    @Test
    void testToHashCode_DefaultValues() {
        int expectedHashCode = 17;
        int actualHashCode = hashCodeBuilder.toHashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    void testToHashCode_CustomValues() {
        int initialOddNumber = 31;
        int multiplierOddNumber = 43;
        hashCodeBuilder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);

        int expectedHashCode = initialOddNumber;
        int actualHashCode = hashCodeBuilder.toHashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }
}