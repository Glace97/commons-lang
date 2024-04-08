package org.apache.commons.lang3.arch;

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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ProcessorTest {
    @Test
    public void testIsRISCVReturnsTrueForRISCVType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V);
        boolean result = processor.isRISCV();
        assertTrue(result);
    }
    
    @Test
    public void testIsRISCVReturnsFalseForNonRISCVType() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        boolean result = processor.isRISCV();
        assertFalse(result);
    }
    
    @Test
    public void testIsRISCVReturnsFalseForUnknownType() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        boolean result = processor.isRISCV();
        assertFalse(result);
    }
    
    @Test
    public void testIsRISCVReturnsFalseForDifferentArchitectures() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V);
        boolean result = processor.isRISCV();
        assertFalse(result);
    }
    @Test
    @DisplayName("Returns true when arch is BIT_32")
    void returnsTrueWhenArchIs32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertTrue(processor.is32Bit());
    }
    
    @Test
    @DisplayName("Returns false when arch is not BIT_32")
    void returnsFalseWhenArchIsNot32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertFalse(processor.is32Bit());
    }
    
    @Test
    @DisplayName("Returns false when arch is UNKNOWN")
    void returnsFalseWhenArchIsUnknown() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertFalse(processor.is32Bit());
    }
    void testIsPPC() {
        assertTrue(processor.isPPC());
    }
    
    void testIsPPCFalse() {
        Processor nonPPCProcessor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertFalse(nonPPCProcessor.isPPC());
    }
    
    void testIsPPCUnknown() {
        Processor unknownProcessor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(unknownProcessor.isPPC());
    }
    @Test
    @DisplayName("Test getLabel")
    void testGetLabel() {
        assertEquals("32-bit", processor.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel - 64-bit")
    void testGetLabel64Bit() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertEquals("64-bit", processor.getLabel());
    }
    
    @Test
    @DisplayName("Test getLabel - Unknown")
    void testGetLabelUnknown() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertEquals("Unknown", processor.getLabel());
    }
    @Test
    public void testIsX86_ReturnsTrue_WhenTypeIsX86() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        Assertions.assertTrue(processor.isX86());
    }
    
    @Test
    public void testIsX86_ReturnsFalse_WhenTypeIsNotX86() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        Assertions.assertFalse(processor.isX86());
    }
    
    @Test
    public void testIsX86_ReturnsFalse_WhenTypeIsUnknown() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.UNKNOWN);
        Assertions.assertFalse(processor.isX86());
    }
    
    @Test
    public void testIsX86_ReturnsFalse_WhenArchIsNotBit32() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        Assertions.assertFalse(processor.isX86());
    }
    @Test
    public void testIs64Bit_returnsTrueWhenArchitectureIs64Bit() {
        assertTrue(processor.is64Bit());
    }
    
    @Test
    public void testIs64Bit_returnsFalseWhenArchitectureIsNot64Bit() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor.is64Bit());
    }
    
    @Test
    public void testIs64Bit_returnsFalseWhenArchitectureIsUnknown() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertFalse(processor.is64Bit());
    }
    
    @Test
    public void testIs64Bit_returnsFalseWhenArchitectureIsNull() {
        processor = new Processor(null, Processor.Type.X86);
        assertFalse(processor.is64Bit());
    }
    
    @Test
    public void testIs64Bit_returnsFalseWhenTypeIsNotNull() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        assertFalse(processor.is64Bit());
    }
    
    @Test
    public void testIs64Bit_returnsFalseWhenTypeIsNull() {
        processor = new Processor(Processor.Arch.BIT_64, null);
        assertFalse(processor.is64Bit());
    }
    @Test
    public void testIsAarch64() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        assertTrue(processor.isAarch64());
    }
    
    @Test
    public void testIsNotAarch64() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor.isAarch64());
    }
    
    @Test
    public void testIsNotAarch64UnknownType() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertFalse(processor.isAarch64());
    }
    
    @Test
    public void testIsNotAarch64UnknownArch() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.AARCH_64);
        assertFalse(processor.isAarch64());
    }
    
    @Test
    public void testIsNotAarch64UnknownArchAndType() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(processor.isAarch64());
    }
    // Test functions:
    
    @Test
    @DisplayName("Returns 32-bit architecture")
    void testGetArch_32BitArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertEquals(Processor.Arch.BIT_32, processor.getArch());
    }
    
    @Test
    @DisplayName("Returns 64-bit architecture")
    void testGetArch_64BitArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }
    
    @Test
    @DisplayName("Returns unknown architecture")
    void testGetArch_UnknownArchitecture() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertEquals(Processor.Arch.UNKNOWN, processor.getArch());
    }
    @Test
    public void testToString() {
        Processor processor1 = new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_64);
        Assertions.assertEquals("AArch64 32-bit", processor1.toString());
        
        Processor processor2 = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        Assertions.assertEquals("x86 64-bit", processor2.toString());
        
        Processor processor3 = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        Assertions.assertEquals("Unknown Unknown", processor3.toString());
    }
    @Test
    public void testIsIA64ReturnsTrue() {
        assertEquals(true, processorIA64.isIA64());
    }
    
    @Test
    public void testIsIA64ReturnsFalse() {
        Processor processorOtherType = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertEquals(false, processorOtherType.isIA64());
    }
    @Test
    public void testGetType_Arch32Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_64);
        Assertions.assertEquals(Processor.Type.AARCH_64, processor.getType());
    }
    
    @Test
    public void testGetType_Arch64Bit() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        Assertions.assertEquals(Processor.Type.X86, processor.getType());
    }
    
    @Test
    public void testGetType_UnknownArch() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.IA_64);
        Assertions.assertEquals(Processor.Type.IA_64, processor.getType());
    }
    
    @Test
    public void testGetType_ArchUnknownType() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.UNKNOWN);
        Assertions.assertEquals(Processor.Type.UNKNOWN, processor.getType());
    }

}