import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class init_X86_64BitTest {
    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
    }

    @Nested
    @DisplayName("Tests for init_X86_64Bit method")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Init_X86_64BitTests {
        @Test
        @DisplayName("Should add processors with 64-bit X86 architecture")
        void shouldAddProcessorsWith64BitX86Architecture() {
            // Arrange
            Map<String, Processor> expectedArchToProcessor = new HashMap<>();
            expectedArchToProcessor.put("x86_64", new Processor(Processor.Arch.BIT_64, Processor.Type.X86));
            expectedArchToProcessor.put("amd64", new Processor(Processor.Arch.BIT_64, Processor.Type.X86));
            expectedArchToProcessor.put("em64t", new Processor(Processor.Arch.BIT_64, Processor.Type.X86));
            expectedArchToProcessor.put("universal", new Processor(Processor.Arch.BIT_64, Processor.Type.X86));

            // Act
            ArchUtils.init_X86_64Bit();

            // Assert
            assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
        }
    }
}