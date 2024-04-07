import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class is64BitTest {

    private Processor processor;

    @BeforeEach
    void setUp() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
    }

    @Test
    void testIs64Bit() {
        assertTrue(processor.is64Bit());
    }

    @Test
    void testIs64BitWithDifferentArch() {
        Processor processor32Bit = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor32Bit.is64Bit());
    }

    @Test
    void testIs64BitWithUnknownArch() {
        Processor processorUnknown = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertFalse(processorUnknown.is64Bit());
    }

    @Test
    void testIs64BitWithDifferentType() {
        Processor processorDifferentType = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        assertTrue(processorDifferentType.is64Bit());
    }

    @Test
    void testIs64BitWithUnknownType() {
        Processor processorUnknownType = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertTrue(processorUnknownType.is64Bit());
    }

    @Test
    void testIs64BitWithDifferentArchAndType() {
        Processor processorDifferentArchAndType = new Processor(Processor.Arch.BIT_32, Processor.Type.PPC);
        assertFalse(processorDifferentArchAndType.is64Bit());
    }
}