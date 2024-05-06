package org.apache.commons.lang3.arch;

import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.apache.commons.lang3.arch.Processor.Arch;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.apache.commons.lang3.arch.Processor.Type;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {

    @Test
    public void testIs32BitTrue() {
        // Instantiate all necessary variables here
        Processor processor = new Processor(Arch.BIT_32, Type.X86);

        // Test that is32Bit() returns true for 32 bit processor
        assertTrue(processor.is32Bit());
    }

    @Test
    public void testIs32BitFalse() {
        // Instantiate all necessary variables here
        Processor processor = new Processor(Arch.BIT_64, Type.X86);

        // Test that is32Bit() returns false for 64 bit processor
        assertFalse(processor.is32Bit());
    }

    @Test
    public void testIs32BitUnknown() {
        // Instantiate all necessary variables here
        Processor processor = new Processor(Arch.UNKNOWN, Type.X86);

        // Test that is32Bit() returns false for unknown architecture
        assertFalse(processor.is32Bit());
    }

    @Test
    public void testGetArch_32Bit() {
        Processor processor = new Processor(Arch.BIT_32, Type.X86);
        assertEquals(Arch.BIT_32, processor.getArch());
    }

    @Test
    public void testGetArch_64Bit() {
        Processor processor = new Processor(Arch.BIT_64, Type.X86);
        assertEquals(Arch.BIT_64, processor.getArch());
    }

    @Test
    public void testGetArch_Unknown() {
        Processor processor = new Processor(Arch.UNKNOWN, Type.X86);
        assertEquals(Arch.UNKNOWN, processor.getArch());
    }

    @Test
    public void is64BitShouldReturnTrueWhenProcessorIs64Bit() {
        // Instantiate all necessary variables here
        Processor.Arch arch = Processor.Arch.BIT_64;
        Processor.Type type = Processor.Type.X86;
        Processor processor = new Processor(arch, type);

        // Write the test code here following the given rules
        assertTrue(processor.is64Bit());
    }

    @Test
    public void is64BitShouldReturnFalseWhenProcessorIsNot64Bit() {
        // Instantiate all necessary variables here
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.X86;
        Processor processor = new Processor(arch, type);

        // Write the test code here following the given rules
        assertFalse(processor.is64Bit());
    }

    @Test
    public void is64BitShouldReturnFalseWhenProcessorIsUnknown() {
        // Instantiate all necessary variables here
        Processor.Arch arch = Processor.Arch.UNKNOWN;
        Processor.Type type = Processor.Type.X86;
        Processor processor = new Processor(arch, type);

        // Write the test code here following the given rules
        assertFalse(processor.is64Bit());
    }



    @Test
    public void testIsAarch64True() {
        Processor processor = new Processor(Arch.BIT_64, Type.AARCH_64);
        assertTrue(processor.isAarch64());
    }

    @Test
    public void testIsAarch64False() {
        Processor processor = new Processor(Arch.BIT_64, Type.X86);
        assertFalse(processor.isAarch64());
    }
    
    @Test
    public void testIsAarch64FalseWith32Bit() {
        Processor processor = new Processor(Arch.BIT_32, Type.AARCH_64);
        assertTrue(processor.isAarch64());
    }

    @Test
    public void testIsAarch64FalseWithUnknownArch() {
        Processor processor = new Processor(Arch.UNKNOWN, Type.AARCH_64);
        assertTrue(processor.isAarch64());
    }

    @Test
    public void testIsAarch64FalseWithUnknownType() {
        Processor processor = new Processor(Arch.BIT_64, Type.UNKNOWN);
        assertFalse(processor.isAarch64());
    }



    private Processor processor;

    @BeforeEach
    public void setUp() {
        // Instantiate all necessary variables here
        Arch arch = Arch.BIT_32;
        Type type = Type.PPC;
        processor = new Processor(arch, type);
    }

    @Test
    public void isPPC_ShouldReturnTrue_WhenProcessorTypeIsPPC() {
        // Write the test code here following the given rules
        assertTrue(processor.isPPC());
    }

    @Test
    public void isPPC_ShouldReturnFalse_WhenProcessorTypeIsNotPPC() {
        // Change the type to something else
        processor = new Processor(Arch.BIT_32, Type.RISC_V);

        assertFalse(processor.isPPC());
    }




    @Test
    @DisplayName("Should return correct processor type")
    public void getTypeTest() {
        // Instantiate all necessary variables here
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.X86;
        
        // Instantiate the Processor object with the above variables
        Processor processor = new Processor(arch, type);

        // Test if the getType method returns the correct processor type
        assertEquals(type, processor.getType(), "Processor type should be X86");
    }

    @Test
    @DisplayName("Should return UNKNOWN if processor type is not known")
    public void getTypeUnknownTest() {
        // Instantiate all necessary variables here
        Processor.Arch arch = Processor.Arch.BIT_64;

        // Instantiate the Processor object with unknown type
        Processor processor = new Processor(arch, Processor.Type.UNKNOWN);

        // Test if the getType method returns UNKNOWN if processor type is not known
        assertEquals(Processor.Type.UNKNOWN, processor.getType(), "Processor type should be UNKNOWN");
    }





    @Test
    public void testIsX86ReturnsTrue() {
        // Instantiate necessary variables
        Processor.Arch arch = Processor.Arch.BIT_64;
        Processor.Type type = Processor.Type.X86;

        // Create Processor object
        Processor proc = new Processor(arch, type);

        // Test if processor type is X86
        assertTrue(proc.isX86());
    }

    @Test
    public void testIsX86ReturnsFalse() {
        // Instantiate necessary variables
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.AARCH_64;

        // Create Processor object
        Processor proc = new Processor(arch, type);

        // Test if processor type is not X86
        assertFalse(proc.isX86());
    }



    
    @Test
    public void testIsIA64WhenTypeIsIA64() {
        Processor processor = new Processor(Arch.BIT_64, Type.IA_64);
        assertTrue(processor.isIA64());
    }

    @Test
    public void testIsIA64WhenTypeIsNotIA64() {
        Processor processor = new Processor(Arch.BIT_64, Type.AARCH_64);
        assertFalse(processor.isIA64());
        
        processor = new Processor(Arch.BIT_64, Type.X86);
        assertFalse(processor.isIA64());
        
        processor = new Processor(Arch.BIT_64, Type.PPC);
        assertFalse(processor.isIA64());

        processor = new Processor(Arch.BIT_64, Type.RISC_V);
        assertFalse(processor.isIA64());
        
        processor = new Processor(Arch.BIT_64, Type.UNKNOWN);
        assertFalse(processor.isIA64());
    }




    @Test
    public void testToString_32Bit_x86() {
        Processor processor = new Processor(Arch.BIT_32, Type.X86);
        String expected = "x86 32-bit";
        assertEquals(expected, processor.toString());
    }

    @Test
    public void testToString_64Bit_aarch64() {
        Processor processor = new Processor(Arch.BIT_64, Type.AARCH_64);
        String expected = "AArch64 64-bit";
        assertEquals(expected, processor.toString());
    }

    @Test
    public void testToString_UnknownBit_UnknownType() {
        Processor processor = new Processor(Arch.UNKNOWN, Type.UNKNOWN);
        String expected = "Unknown Unknown";
        assertEquals(expected, processor.toString());
    }




    @Test
    public void whenTypeIsRISCV_thenIsRISCVReturnsTrue() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V);
        assertTrue(processor.isRISCV());
    }

    @Test
    public void whenTypeIsNotRISCV_thenIsRISCVReturnsFalse() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.AARCH_64);
        assertFalse(processor.isRISCV());
    }

    @Test
    public void whenTypeIsNull_thenIsRISCVReturnsFalse() {
        Processor processor = new Processor(Processor.Arch.BIT_32, null);
        assertFalse(processor.isRISCV());
    }

    @Test
    public void whenArchIsNull_thenIsRISCVStillWorks() {
        Processor processor = new Processor(null, Processor.Type.RISC_V);
        assertTrue(processor.isRISCV());
    }

    @Test
    public void whenBothArchAndTypeAreNull_thenIsRISCVReturnsFalse() {
        Processor processor = new Processor(null, null);
        assertFalse(processor.isRISCV());
    }

}