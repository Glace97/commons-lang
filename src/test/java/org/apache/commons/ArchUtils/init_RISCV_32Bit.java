import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;
import static org.junit.jupiter.api.Assertions.*;

class init_RISCV_32BitTest {

    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }

    @Test
    void addProcessors_shouldAddProcessorToARCH_TO_PROCESSORMap() {
        // Arrange
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V);
        String arch = "riscv32";

        // Act
        archUtils.addProcessors(processor, arch);

        // Assert
        assertEquals(processor, archUtils.ARCH_TO_PROCESSOR.get(arch));
    }

    @Test
    void init_RISCV_32Bit_shouldAddRISCV32ProcessorToARCH_TO_PROCESSORMap() {
        // Arrange
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V);
        String arch = "riscv32";

        // Act
        archUtils.init_RISCV_32Bit();

        // Assert
        assertEquals(processor, archUtils.ARCH_TO_PROCESSOR.get(arch));
    }
}