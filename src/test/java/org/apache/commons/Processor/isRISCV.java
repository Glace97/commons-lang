import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class isRISCVTest {

    @Test
    @DisplayName("Test isRISCV method with RISC_V type")
    public void testIsRISCVWithRISC_VType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V);
        assertTrue(processor.isRISCV());
    }

    @Test
    @DisplayName("Test isRISCV method with non-RISC_V type")
    public void testIsRISCVWithNonRISC_VType() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor.isRISCV());
    }
    
    @Test
    @DisplayName("Test isRISCV method with UNKNOWN type")
    public void testIsRISCVWithUnknownType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertFalse(processor.isRISCV());
    }
    
    @Test
    @DisplayName("Test isRISCV method with null type")
    public void testIsRISCVWithNullType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, null);
        assertFalse(processor.isRISCV());
    }
    
    @Test
    @DisplayName("Test isRISCV method with null arch and type")
    public void testIsRISCVWithNullArchAndType() {
        Processor processor = new Processor(null, null);
        assertFalse(processor.isRISCV());
    }
}