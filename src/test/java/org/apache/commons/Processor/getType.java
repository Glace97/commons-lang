import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class getTypeTest {

    private Processor processor;

    @BeforeEach
    void setUp() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
    }

    @Test
    void testGetType() {
        assertEquals(Processor.Type.X86, processor.getType());
    }

    @Test
    void testGetTypeWithAARCH64() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        assertEquals(Processor.Type.AARCH_64, processor.getType());
    }

    @Test
    void testGetTypeWithIA64() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        assertEquals(Processor.Type.IA_64, processor.getType());
    }

    @Test
    void testGetTypeWithPPC() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        assertEquals(Processor.Type.PPC, processor.getType());
    }

    @Test
    void testGetTypeWithRISC_V() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V);
        assertEquals(Processor.Type.RISC_V, processor.getType());
    }

    @Test
    void testGetTypeWithUnknown() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertEquals(Processor.Type.UNKNOWN, processor.getType());
    }
}