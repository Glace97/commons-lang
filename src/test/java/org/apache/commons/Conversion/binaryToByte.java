import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class binaryToByteTest {

    @Test
    void testEmptySrc() {
        boolean[] src = {};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 0;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(dstInit, result);
    }
    
    @Test
    void testZeroNBools() {
        boolean[] src = {true, true, true, true};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 0;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(dstInit, result);
    }
    
    @Test
    void testInvalidNBools() {
        boolean[] src = {true, true, true, true};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 5;
        
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        });
    }
    
    @Test
    void testAllTrueBits() {
        boolean[] src = {true, true, true, true};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(-1, result);
    }
    
    @Test
    void testAllFalseBits() {
        boolean[] src = {false, false, false, false};
        int srcPos = 0;
        byte dstInit = -1;
        int dstPos = 0;
        int nBools = 4;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(0, result);
    }
    
    @Test
    void testMixedBits() {
        boolean[] src = {true, false, true, false};
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(10, result);
    }
    
    @Test
    void testSrcPosGreaterThanSrcLength() {
        boolean[] src = {true, true, true, true};
        int srcPos = 5;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        });
    }
    
    @Test
    void testFullCoverage() {
        boolean[] src = Conversion.TTTT;
        int srcPos = 0;
        byte dstInit = 0;
        int dstPos = 0;
        int nBools = 4;
        
        byte result = Conversion.binaryToByte(src, srcPos, dstInit, dstPos, nBools);
        
        assertEquals(-1, result);
    }
}