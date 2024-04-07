import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang3.arch.Processor;

@TestInstance(Lifecycle.PER_CLASS)
class init_X86_32BitTest {
    
    private ArchUtils archUtils;
    
    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }
    
    @Test
    void testInit_X86_32Bit() {
        archUtils.init_X86_32Bit();
        
        Map<String, Processor> expectedArchToProcessor = new HashMap<>();
        expectedArchToProcessor.put("x86", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        expectedArchToProcessor.put("i386", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        expectedArchToProcessor.put("i486", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        expectedArchToProcessor.put("i586", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        expectedArchToProcessor.put("i686", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        expectedArchToProcessor.put("pentium", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
        
        assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
    }
}