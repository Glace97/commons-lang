import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class init_IA64_32BitTest {

    private ArchUtils archUtils;

    @BeforeEach
    void setUp() {
        archUtils = new ArchUtils();
        archUtils.ARCH_TO_PROCESSOR = new HashMap<>();
    }

    @Test
    @DisplayName("Adding processors for IA64 32-bit architecture")
    void testInit_IA64_32Bit() {
        // Arrange

        // Act
        ArchUtils.init_IA64_32Bit();

        // Assert
        Processor processor1 = archUtils.ARCH_TO_PROCESSOR.get("ia64_32");
        Processor processor2 = archUtils.ARCH_TO_PROCESSOR.get("ia64n");

        assertNotNull(processor1);
        assertNotNull(processor2);
        assertEquals(Processor.Type.IA_64, processor1.getType());
        assertEquals(Processor.Type.IA_64, processor2.getType());
        assertEquals(Processor.Arch.BIT_32, processor1.getArch());
        assertEquals(Processor.Arch.BIT_32, processor2.getArch());
    }

    @Nested
    @DisplayName("When processors are already added")
    @TestInstance(Lifecycle.PER_CLASS)
    class WhenProcessorsAlreadyAdded {

        @BeforeEach
        void setUp() {
            archUtils.ARCH_TO_PROCESSOR.put("existing_arch", mock(Processor.class));
        }

        @Test
        @DisplayName("Adding processors for IA64 32-bit architecture does not remove existing processors")
        void testInit_IA64_32Bit() {
            // Arrange

            // Act
            ArchUtils.init_IA64_32Bit();

            // Assert
            Processor existingProcessor = archUtils.ARCH_TO_PROCESSOR.get("existing_arch");
            assertNotNull(existingProcessor);
        }
    }
}