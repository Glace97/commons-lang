import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.arch.Processor;

class init_RISCV_64BitTest {

    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }

    @Nested
    @DisplayName("When initializing RISCV 64Bit")
    class InitRISCV64Bit {

        @Test
        @DisplayName("should add the RISCV 64Bit processor to the map with the correct key")
        void shouldAddRISCV64BitProcessorToMapWithCorrectKey() {
            // Arrange

            // Act
            ArchUtils.init_RISCV_64Bit();

            // Assert
            assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("riscv64"));
            assertEquals(Processor.Arch.BIT_64, archUtils.ARCH_TO_PROCESSOR.get("riscv64").getArch());
            assertEquals(Processor.Type.RISC_V, archUtils.ARCH_TO_PROCESSOR.get("riscv64").getType());
        }

    }
}