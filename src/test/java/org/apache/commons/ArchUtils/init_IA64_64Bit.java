import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class init_IA64_64BitTest {

    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }

    @Nested
    @DisplayName("When initializing IA64 64-bit architecture")
    class InitIA6464Bit {

        @BeforeEach
        void initIA6464Bit() {
            ArchUtils.init_IA64_64Bit();
        }

        @Test
        @DisplayName("Should initialize ARCH_TO_PROCESSOR map")
        void shouldInitializeArchToProcessorMap() {
            Map<String, Processor> archToProcessor = archUtils.ARCH_TO_PROCESSOR;
            
            assertNotNull(archToProcessor);
        }

        @Test
        @DisplayName("Should add IA64 64-bit processors to ARCH_TO_PROCESSOR map")
        void shouldAddIA6464BitProcessorsToMap() {
            Map<String, Processor> archToProcessor = archUtils.ARCH_TO_PROCESSOR;
            
            assertTrue(archToProcessor.containsKey("ia64"));
            assertTrue(archToProcessor.containsKey("ia64w"));
            
            Processor ia64Processor = archToProcessor.get("ia64");
            Processor ia64wProcessor = archToProcessor.get("ia64w");
            
            assertNotNull(ia64Processor);
            assertNotNull(ia64wProcessor);
            
            assertEquals(Processor.Arch.BIT_64, ia64Processor.getArch());
            assertEquals(Processor.Type.IA_64, ia64Processor.getType());
            
            assertEquals(Processor.Arch.BIT_64, ia64wProcessor.getArch());
            assertEquals(Processor.Type.IA_64, ia64wProcessor.getType());
        }
    }
}