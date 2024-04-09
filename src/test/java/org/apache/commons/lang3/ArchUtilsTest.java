package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ArchUtilsTest {

    private ArchUtils archUtils;

//    @BeforeEach
//    void setUp() {
//        ArchUtils.init_PPC_32Bit();
////    }
//    @Test
//    void testInit() {
//        assertDoesNotThrow(() -> ArchUtils.init());
//    }
//
//    @Test
//    void testInit_X86_32Bit() {
//        assertDoesNotThrow(() -> archUtils.init_X86_32Bit());
//    }
//
//    @Test
//    void testInit_X86_64Bit() {
//        assertDoesNotThrow(() -> archUtils.init_X86_64Bit());
//    }
//
//    @Test
//    void testInit_IA64_32Bit() {
//        assertDoesNotThrow(() -> archUtils.init_IA64_32Bit());
//    }
//
//    @Test
//    void testInit_IA64_64Bit() {
//        assertDoesNotThrow(() -> archUtils.init_IA64_64Bit());
//    }
//
//    @Test
//    void testInit_PPC_32Bit() {
//        assertDoesNotThrow(() -> archUtils.init_PPC_32Bit());
//    }
//
//    @Test
//    void testInit_PPC_64Bit() {
//        assertDoesNotThrow(() -> archUtils.init_PPC_64Bit());
//    }
//
//    @Test
//    void testInit_Aarch_64Bit() {
//        assertDoesNotThrow(() -> archUtils.init_Aarch_64Bit());
//    }
//
//    @Test
//    void testInit_RISCV_32Bit() {
//        assertDoesNotThrow(() -> archUtils.init_RISCV_32Bit());
//    }
//
//    @Test
//    void testInit_RISCV_64Bit() {
//        assertDoesNotThrow(() -> archUtils.init_RISCV_64Bit());
//    }
//    // Your Java code here
//
//    @Test
//    void testInitRISCV32Bit() {
//        ArchUtils.init_RISCV_32Bit();
//
//        Map<String, Processor> archToProcessor = ArchUtils.ARCH_TO_PROCESSOR;
//
//        assertNotNull(archToProcessor);
//        assertEquals(1, archToProcessor.size());
//
//        Processor riscv32Processor = archToProcessor.get("riscv32");
//        assertNotNull(riscv32Processor);
//        assertEquals(Processor.Arch.BIT_32, riscv32Processor.getArch());
//        assertEquals(Processor.Type.RISC_V, riscv32Processor.getType());
//    }

    @Test
    void testGetProcessor_ReturnsProcessorWhenSupported() {
        Processor processor = archUtils.getProcessor("x86");
        assertNotNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsNullWhenProcessorNotSupported() {
        Processor processor = archUtils.getProcessor("unknown");
        assertNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsNullWhenValueIsNull() {
        Processor processor = archUtils.getProcessor(null);
        assertNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsProcessorForCurrentJVM() {
        Processor processor = archUtils.getProcessor();
        assertNotNull(processor);
    }

//    @Test
//    @DisplayName("Test init_Aarch_64Bit with valid input")
//    void testInit_Aarch_64Bit_ValidInput() {
//        ArchUtils.init_Aarch_64Bit();
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("aarch64"));
//        assertNotNull(archUtils.ARCH_TO_PROCESSOR.get("aarch64"));
//        assertEquals(Processor.Arch.BIT_64, archUtils.ARCH_TO_PROCESSOR.get("aarch64").getArch());
//        assertEquals(Processor.Type.AARCH_64, archUtils.ARCH_TO_PROCESSOR.get("aarch64").getType());
//    }
//
//    @Test
//    @DisplayName("Test init_Aarch_64Bit with existing key")
//    void testInit_Aarch_64Bit_ExistingKey() {
//        archUtils.ARCH_TO_PROCESSOR.put("aarch64", new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_32));
//        ArchUtils.init_Aarch_64Bit();
//        assertNotNull(archUtils.ARCH_TO_PROCESSOR.get("aarch64"));
//        assertEquals(Processor.Arch.BIT_64, archUtils.ARCH_TO_PROCESSOR.get("aarch64").getArch());
//        assertEquals(Processor.Type.AARCH_64, archUtils.ARCH_TO_PROCESSOR.get("aarch64").getType());
//    }
//
//    @Test
//    @DisplayName("Test init_Aarch_64Bit with null key")
//    void testInit_Aarch_64Bit_NullKey() {
//        archUtils.ARCH_TO_PROCESSOR.put(null, new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_32));
//        assertThrows(NullPointerException.class, () -> ArchUtils.init_Aarch_64Bit());
//        assertNull(archUtils.ARCH_TO_PROCESSOR.get("aarch64")); // Key should not be added
//    }
//
//    @Test
//    @DisplayName("Test init_Aarch_64Bit with null Processor")
//    void testInit_Aarch_64Bit_NullProcessor() {
//        archUtils.ARCH_TO_PROCESSOR.put("aarch64", null);
//        assertDoesNotThrow(() -> ArchUtils.init_Aarch_64Bit());
//        assertNull(archUtils.ARCH_TO_PROCESSOR.get("aarch64")); // Processor should not be replaced
//    }
//
//
//    @Test
//    @DisplayName("should add processors to ARCH_TO_PROCESSOR map")
//    void shouldAddProcessorsToMap() {
//        Map<String, Processor> expectedMap = new HashMap<>();
//        expectedMap.put("ppc", new Processor(Processor.Arch.BIT_32, Processor.Type.PPC));
//        expectedMap.put("power", new Processor(Processor.Arch.BIT_32, Processor.Type.PPC));
//        expectedMap.put("powerpc", new Processor(Processor.Arch.BIT_32, Processor.Type.PPC));
//        expectedMap.put("power_pc", new Processor(Processor.Arch.BIT_32, Processor.Type.PPC));
//        expectedMap.put("power_rs", new Processor(Processor.Arch.BIT_32, Processor.Type.PPC));
//
//        assertEquals(expectedMap, archUtils.ARCH_TO_PROCESSOR);
//    }


//    @Test
//    public void testInit_IA64_64Bit() {
//        ArchUtils.init_IA64_64Bit();
//
//        // Verify that the map ARCH_TO_PROCESSOR is initialized
//        assertNotNull(ARCH_TO_PROCESSOR);
//
//        // Verify that the map contains the expected keys
//        assertTrue(ARCH_TO_PROCESSOR.containsKey("ia64"));
//        assertTrue(ARCH_TO_PROCESSOR.containsKey("ia64w"));
//
//        // Verify that the map contains the expected values
//        assertEquals(Processor.Arch.BIT_64, ARCH_TO_PROCESSOR.get("ia64").getArch());
//        assertEquals(Processor.Arch.BIT_64, ARCH_TO_PROCESSOR.get("ia64w").getArch());
//        assertEquals(Processor.Type.IA_64, ARCH_TO_PROCESSOR.get("ia64").getType());
//        assertEquals(Processor.Type.IA_64, ARCH_TO_PROCESSOR.get("ia64w").getType());
//
//        // Verify that the map does not contain any additional keys
//        assertEquals(2, ARCH_TO_PROCESSOR.size());
//    }
//
//    @Test
//    @DisplayName("Should add Processor with x86_64 architecture")
//    void shouldAddX86_64Processor() {
//        ArchUtils.init_X86_64Bit();
//        Processor processor = archUtils.ARCH_TO_PROCESSOR.get("x86_64");
//        assertNotNull(processor);
//        assertEquals(Processor.Arch.BIT_64, processor.getArch());
//        assertEquals(Processor.Type.X86, processor.getType());
//    }
//
//    @Test
//    @DisplayName("Should add Processor with amd64 architecture")
//    void shouldAddAmd64Processor() {
//        ArchUtils.init_X86_64Bit();
//        Processor processor = archUtils.ARCH_TO_PROCESSOR.get("amd64");
//        assertNotNull(processor);
//        assertEquals(Processor.Arch.BIT_64, processor.getArch());
//        assertEquals(Processor.Type.X86, processor.getType());
//    }
//
//    @Test
//    @DisplayName("Should add Processor with em64t architecture")
//    void shouldAddEm64tProcessor() {
//        ArchUtils.init_X86_64Bit();
//        Processor processor = archUtils.ARCH_TO_PROCESSOR.get("em64t");
//        assertNotNull(processor);
//        assertEquals(Processor.Arch.BIT_64, processor.getArch());
//        assertEquals(Processor.Type.X86, processor.getType());
//    }
//
//    @Test
//    @DisplayName("Should add Processor with universal architecture")
//    void shouldAddUniversalProcessor() {
//        ArchUtils.init_X86_64Bit();
//        Processor processor = archUtils.ARCH_TO_PROCESSOR.get("universal");
//        assertNotNull(processor);
//        assertEquals(Processor.Arch.BIT_64, processor.getArch());
//        assertEquals(Processor.Type.X86, processor.getType());
//    }
//
//    @Test
//    @DisplayName("Should not add Processor with non-x86_64 architecture")
//    void shouldNotAddNonX86_64Processor() {
//        ArchUtils.init_X86_64Bit();
//        Processor processor = archUtils.ARCH_TO_PROCESSOR.get("arm64");
//        assertNull(processor);
//    }
//
//    @Test
//    @DisplayName("Test init_X86_32Bit with valid input")
//    void testInit_X86_32Bit_ValidInput() {
//        archUtils.init_X86_32Bit();
//        Map<String, Processor> expectedMap = new HashMap<>();
//        expectedMap.put("x86", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i386", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i486", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i586", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i686", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("pentium", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        assertEquals(expectedMap, archUtils.ARCH_TO_PROCESSOR);
//    }
//
//    @Test
//    @DisplayName("Test init_X86_32Bit with no input")
//    void testInit_X86_32Bit_NoInput() {
//        archUtils.init_X86_32Bit();
//        assertEquals(new HashMap<>(), archUtils.ARCH_TO_PROCESSOR);
//    }
//
//    @Test
//    @DisplayName("Test init_X86_32Bit with duplicate input")
//    void testInit_X86_32Bit_DuplicateInput() {
//        archUtils.init_X86_32Bit();
//        Map<String, Processor> expectedMap = new HashMap<>();
//        expectedMap.put("x86", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i386", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i486", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i586", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("i686", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        expectedMap.put("pentium", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//        archUtils.init_X86_32Bit();
//        assertEquals(expectedMap, archUtils.ARCH_TO_PROCESSOR);
//    }
//
//    @Test
//    @DisplayName("Test init_X86_32Bit with invalid input")
//    void testInit_X86_32Bit_InvalidInput() {
//        archUtils.init_X86_32Bit();
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("invalid"));
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey(""));
//    }
//
//    @Test
//    void testInit_PPC_64Bit() {
//        archUtils = new ArchUtils();
//        archUtils.init_PPC_64Bit();
//
//        Map<String, Processor> expectedArchToProcessor = new HashMap<>();
//        expectedArchToProcessor.put("ppc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
//        expectedArchToProcessor.put("power64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
//        expectedArchToProcessor.put("powerpc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
//        expectedArchToProcessor.put("power_pc64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
//        expectedArchToProcessor.put("power_rs64", new Processor(Processor.Arch.BIT_64, Processor.Type.PPC));
//
//        assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
//    }
//
//    @Test
//    void testInit_PPC_64BitEdgeCases() {
//        archUtils = new ArchUtils();
//        archUtils.init_PPC_64Bit();
//
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("ppc64"));
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("power64"));
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("powerpc64"));
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("power_pc64"));
//        assertTrue(archUtils.ARCH_TO_PROCESSOR.containsKey("power_rs64"));
//
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("ppc32"));
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("power32"));
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("powerpc32"));
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("power_pc32"));
//        assertFalse(archUtils.ARCH_TO_PROCESSOR.containsKey("power_rs32"));
//
//        assertSame(Processor.Arch.BIT_64, archUtils.ARCH_TO_PROCESSOR.get("ppc64").getArch());
//        assertSame(Processor.Type.PPC, archUtils.ARCH_TO_PROCESSOR.get("ppc64").getType());
//    }
//
//    @Test
//    @DisplayName("Should add IA_64 32-bit processor with keys 'ia64_32' and 'ia64n'")
//    void shouldAddIA6432BitProcessor() {
//        ArchUtils.init_IA64_32Bit();
//
//        Map<String, Processor> archToProcessor = archUtils.ARCH_TO_PROCESSOR;
//
//        Assertions.assertTrue(archToProcessor.containsKey("ia64_32"));
//        Assertions.assertTrue(archToProcessor.containsKey("ia64n"));
//
//        Processor ia6432BitProcessor = archToProcessor.get("ia64_32");
//        Assertions.assertNotNull(ia6432BitProcessor);
//        Assertions.assertEquals(Processor.Arch.BIT_32, ia6432BitProcessor.getArch());
//        Assertions.assertEquals(Processor.Type.IA_64, ia6432BitProcessor.getType());
//
//        Processor ia64nProcessor = archToProcessor.get("ia64n");
//        Assertions.assertNotNull(ia64nProcessor);
//        Assertions.assertEquals(Processor.Arch.BIT_32, ia64nProcessor.getArch());
//        Assertions.assertEquals(Processor.Type.IA_64, ia64nProcessor.getType());
//    }
//
//    @Test
//    @DisplayName("Test init_RISCV_64Bit with valid values")
//    void testInit_RISCV_64Bit() {
//        // Arrange
//        ArchUtils archUtils = new ArchUtils();
//        Map<String, Processor> expectedArchToProcessor = new HashMap<>();
//        expectedArchToProcessor.put("riscv64", new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V));
//
//        // Act
//        archUtils.init_RISCV_64Bit();
//
//        // Assert
//        assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
//    }
//
//    @Test
//    @DisplayName("Test init_RISCV_64Bit with existing processors")
//    void testInit_RISCV_64BitWithExistingProcessors() {
//        // Arrange
//        ArchUtils archUtils = new ArchUtils();
//        Map<String, Processor> expectedArchToProcessor = new HashMap<>();
//        expectedArchToProcessor.put("existing_arch", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//
//        // Add existing processor
//        archUtils.ARCH_TO_PROCESSOR = new HashMap<>();
//        archUtils.ARCH_TO_PROCESSOR.put("existing_arch", new Processor(Processor.Arch.BIT_32, Processor.Type.X86));
//
//        // Act
//        archUtils.init_RISCV_64Bit();
//
//        // Assert
//        expectedArchToProcessor.put("riscv64", new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V));
//        assertEquals(expectedArchToProcessor, archUtils.ARCH_TO_PROCESSOR);
//    }

}