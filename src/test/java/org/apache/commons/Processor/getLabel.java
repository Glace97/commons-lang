import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class getLabelTest {

    @Test
    @DisplayName("Test getLabel for Arch with BIT_32")
    public void testGetLabelArchBit32() {
        Processor.Arch arch = Processor.Arch.BIT_32;
        String expectedLabel = "32-bit";
        
        assertEquals(expectedLabel, arch.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Arch with BIT_64")
    public void testGetLabelArchBit64() {
        Processor.Arch arch = Processor.Arch.BIT_64;
        String expectedLabel = "64-bit";
        
        assertEquals(expectedLabel, arch.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Arch with UNKNOWN")
    public void testGetLabelArchUnknown() {
        Processor.Arch arch = Processor.Arch.UNKNOWN;
        String expectedLabel = "Unknown";
        
        assertEquals(expectedLabel, arch.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with AARCH_64")
    public void testGetLabelTypeAarch64() {
        Processor.Type type = Processor.Type.AARCH_64;
        String expectedLabel = "AArch64";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with X86")
    public void testGetLabelTypeX86() {
        Processor.Type type = Processor.Type.X86;
        String expectedLabel = "x86";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with IA_64")
    public void testGetLabelTypeIa64() {
        Processor.Type type = Processor.Type.IA_64;
        String expectedLabel = "IA-64";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with PPC")
    public void testGetLabelTypePpc() {
        Processor.Type type = Processor.Type.PPC;
        String expectedLabel = "PPC";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with RISC_V")
    public void testGetLabelTypeRiscV() {
        Processor.Type type = Processor.Type.RISC_V;
        String expectedLabel = "RISC-V";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Type with UNKNOWN")
    public void testGetLabelTypeUnknown() {
        Processor.Type type = Processor.Type.UNKNOWN;
        String expectedLabel = "Unknown";
        
        assertEquals(expectedLabel, type.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Processor with BIT_32 and AARCH_64")
    public void testGetLabelProcessorBit32Aarch64() {
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.AARCH_64;
        String expectedLabel = "32-bit";
        Processor processor = new Processor(arch, type);
        
        assertEquals(expectedLabel, processor.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Processor with BIT_64 and X86")
    public void testGetLabelProcessorBit64X86() {
        Processor.Arch arch = Processor.Arch.BIT_64;
        Processor.Type type = Processor.Type.X86;
        String expectedLabel = "64-bit";
        Processor processor = new Processor(arch, type);
        
        assertEquals(expectedLabel, processor.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel for Processor with UNKNOWN and IA_64")
    public void testGetLabelProcessorUnknownIa64() {
        Processor.Arch arch = Processor.Arch.UNKNOWN;
        Processor.Type type = Processor.Type.IA_64;
        String expectedLabel = "Unknown";
        Processor processor = new Processor(arch, type);
        
        assertEquals(expectedLabel, processor.getLabel());
    }
}