import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class getProcessorTest {

    @Test
    void testGetProcessor() {
        // Initialize the ARCH_TO_PROCESSOR map
        ArchUtils.ARCH_TO_PROCESSOR = new HashMap<>();
        ArchUtils.ARCH_TO_PROCESSOR.put("x86", new Processor("x86"));
        ArchUtils.ARCH_TO_PROCESSOR.put("x86_64", new Processor("x86_64"));
        ArchUtils.ARCH_TO_PROCESSOR.put("arm", new Processor("arm"));
        
        // Test valid input
        assertEquals(new Processor("x86"), ArchUtils.getProcessor("x86"));
        assertEquals(new Processor("x86_64"), ArchUtils.getProcessor("x86_64"));
        assertEquals(new Processor("arm"), ArchUtils.getProcessor("arm"));
        
        // Test invalid input
        assertNull(ArchUtils.getProcessor("invalid_arch"));
        
        // Test null input
        assertNull(ArchUtils.getProcessor(null));
    }
    
    @Test
    void testGetProcessorFromSystemProperties() {
        // Initialize the ARCH_TO_PROCESSOR map
        ArchUtils.ARCH_TO_PROCESSOR = new HashMap<>();
        ArchUtils.ARCH_TO_PROCESSOR.put("x86", new Processor("x86"));
        ArchUtils.ARCH_TO_PROCESSOR.put("x86_64", new Processor("x86_64"));
        ArchUtils.ARCH_TO_PROCESSOR.put("arm", new Processor("arm"));
        
        // Test valid input
        SystemProperties.setOsArch("x86");
        assertEquals(new Processor("x86"), ArchUtils.getProcessor());
        
        SystemProperties.setOsArch("x86_64");
        assertEquals(new Processor("x86_64"), ArchUtils.getProcessor());
        
        SystemProperties.setOsArch("arm");
        assertEquals(new Processor("arm"), ArchUtils.getProcessor());
        
        // Test invalid input
        SystemProperties.setOsArch("invalid_arch");
        assertNull(ArchUtils.getProcessor());
        
        // Test null input
        SystemProperties.setOsArch(null);
        assertNull(ArchUtils.getProcessor());
    }
}