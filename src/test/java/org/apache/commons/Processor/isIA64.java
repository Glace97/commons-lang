import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isIA64Test {

    @Test
    void testIsIA64WithIA64Type() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        assertTrue(processor.isIA64());
    }

    @Test
    void testIsIA64WithNonIA64Type() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        assertFalse(processor.isIA64());
    }

    @Test
    void testIsIA64WithUnknownType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertFalse(processor.isIA64());
    }

    @Test
    void testIsIA64WithDifferentArchType() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64);
        assertFalse(processor.isIA64());
    }

    @Test
    void testIsIA64WithDifferentArchAndType() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_64);
        assertFalse(processor.isIA64());
    }

    @Test
    void testIsIA64WithUnknownArchAndType() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(processor.isIA64());
    }
}