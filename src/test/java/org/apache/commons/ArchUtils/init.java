import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

class initTest {

    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
        archUtils.init();
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map is not null after initialization")
    void testInit_ARCH_TO_PROCESSORNotNull() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertNotNull(ARCH_TO_PROCESSOR);
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains X86_32Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsX86_32Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("X86_32Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains X86_64Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsX86_64Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("X86_64Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains IA64_32Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsIA64_32Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("IA64_32Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains IA64_64Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsIA64_64Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("IA64_64Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains PPC_32Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsPPC_32Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("PPC_32Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains PPC_64Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsPPC_64Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("PPC_64Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains Aarch_64Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsAarch_64Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("Aarch_64Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains RISCV_32Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsRISCV_32Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("RISCV_32Bit"));
    }

    @Test
    @DisplayName("Test if ARCH_TO_PROCESSOR map contains RISCV_64Bit after initialization")
    void testInit_ARCH_TO_PROCESSORContainsRISCV_64Bit() {
        Map<String, Processor> ARCH_TO_PROCESSOR = archUtils.ARCH_TO_PROCESSOR;
        assertTrue(ARCH_TO_PROCESSOR.containsKey("RISCV_64Bit"));
    }
}