
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class doubleValueTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte((byte) 10);
    }

    @Test
    void testDoubleValue() {
        assertEquals(10.0, mutableByte.doubleValue());
    }
}
