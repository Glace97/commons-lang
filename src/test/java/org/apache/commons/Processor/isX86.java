import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class isX86Test {

    @Test
    public void testIsX86() {
        Processor processor;
        
        // Test case 1: Processor is type x86
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertTrue(processor.isX86());
        
        // Test case 2: Processor is not type x86
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        assertFalse(processor.isX86());
        
        // Test case 3: Processor type is unknown
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(processor.isX86());
        
        // Test case 4: Processor type is AArch64
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        assertFalse(processor.isX86());
        
        // Test case 5: Processor type is IA-64
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        assertFalse(processor.isX86());
        
        // Test case 6: Processor type is RISC-V
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V);
        assertFalse(processor.isX86());
    }
}