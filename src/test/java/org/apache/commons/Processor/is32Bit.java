import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class is32BitTest {

    private Processor processor32Bit;
    private Processor processor64Bit;
    private Processor processorUnknown;

    @BeforeEach
    void setUp() {
        processor32Bit = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        processor64Bit = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        processorUnknown = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
    }

    @Test
    void testIs32Bit() {
        assertTrue(processor32Bit.is32Bit());
        assertFalse(processor64Bit.is32Bit());
        assertFalse(processorUnknown.is32Bit());
    }
}