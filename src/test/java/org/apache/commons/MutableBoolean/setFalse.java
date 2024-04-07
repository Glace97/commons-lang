import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setFalseTest {

    @Test
    void testSetFalse() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());

        mutableBoolean = new MutableBoolean(false);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());

        mutableBoolean = new MutableBoolean(Boolean.TRUE);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());

        mutableBoolean = new MutableBoolean(Boolean.FALSE);
        mutableBoolean.setFalse();
        assertFalse(mutableBoolean.getValue());
    }
}