
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppendTest {

    private HashCodeBuilder hashCodeBuilder;

    @BeforeEach
    void setUp() {
        hashCodeBuilder = new HashCodeBuilder();
    }

    @Test
    void appendBooleanTrue() {
        hashCodeBuilder.append(true);
        assertEquals(34, hashCodeBuilder.iTotal);
    }

    @Test
    void appendBooleanFalse() {
        hashCodeBuilder.append(false);
        assertEquals(17, hashCodeBuilder.iTotal);
    }

    @Test
    void appendBooleanArrayNull() {
        hashCodeBuilder.append((boolean[]) null);
        assertEquals(17, hashCodeBuilder.iTotal);
    }

    @Test
    void appendBooleanArrayEmpty() {
        hashCodeBuilder.append(new boolean[0]);
        assertEquals(17, hashCodeBuilder.iTotal);
    }

    @Test
    void appendBooleanArray() {
        hashCodeBuilder.append(new boolean[]{true, false, true});
        assertEquals(53, hashCodeBuilder.iTotal);
    }

    // Add tests for other append methods

}
