import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.stream.Streams;

class init_PPC_64BitTest {
    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }

    @Nested
    @DisplayName("Tests for init_PPC_64Bit method")
    class Init_PPC_64BitMethodTests {
        @Test
        @DisplayName("Test if ARCH_TO_PROCESSOR is initialized correctly")
        void testInit_PPC_64Bit() {
            // Call the method to be tested
            ArchUtils.init_PPC_64Bit();

            // Verify that the ARCH_TO_PROCESSOR map is initialized correctly
            Map<String, Processor> expectedMap = new HashMap<>();
            expectedMap.put("ppc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
            expectedMap.put("power64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
            expectedMap.put("powerpc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
            expectedMap.put("power_pc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
            expectedMap.put("power_rs64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));

            assertEquals(expectedMap, archUtils.ARCH_TO_PROCESSOR, "ARCH_TO_PROCESSOR is not initialized correctly");
        }
    }
}