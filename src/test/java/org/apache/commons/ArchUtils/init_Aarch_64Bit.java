import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class init_Aarch_64BitTest {
    
    @Mock
    private ArchUtils archUtils;
    
    @BeforeEach
    void setup() {
        archUtils = new ArchUtils();
    }
    
    @Test
    void testInit_Aarch_64Bit() {
        archUtils.init_Aarch_64Bit();
        
        Map<String, Processor> expectedArchToProcessor = new HashMap<>();
        expectedArchToProcessor.put("aarch64", new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64));
        
        assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
    }
}