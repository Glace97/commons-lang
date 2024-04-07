import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setTestTransientsTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void testSetTestTransientsTrue() {
        equalsBuilder.setTestTransients(true);
        assertTrue(equalsBuilder.testTransients);
    }

    @Test
    void testSetTestTransientsFalse() {
        equalsBuilder.setTestTransients(false);
        assertFalse(equalsBuilder.testTransients);
    }
}