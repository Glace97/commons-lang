import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.UUID;

class byteArrayToShortTest {
  
  @Test
  @DisplayName("Test when src array is empty and nBytes is 0")
  void testEmptySrcArrayAndZeroNBytes() {
    byte[] src = {};
    int srcPos = 0;
    short dstInit = 10;
    int dstPos = 0;
    int nBytes = 0;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(dstInit, result);
  }
  
  @Test
  @DisplayName("Test when src array is empty and nBytes is not 0")
  void testEmptySrcArrayAndNonZeroNBytes() {
    byte[] src = {};
    int srcPos = 0;
    short dstInit = 10;
    int dstPos = 0;
    int nBytes = 2;
    
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    });
  }
  
  @Test
  @DisplayName("Test when nBytes-1*8+dstPos >= 16")
  void testInvalidDstPos() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 10;
    int dstPos = 8;
    int nBytes = 2;
    
    assertThrows(IllegalArgumentException.class, () -> {
      Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    });
  }
  
  @Test
  @DisplayName("Test when src array has enough elements")
  void testValidSrcArray() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 0;
    int dstPos = 0;
    int nBytes = 2;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(513, result);
  }
  
  @Test
  @DisplayName("Test when src array has enough elements and srcPos is not 0")
  void testValidSrcArrayWithSrcPos() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 1;
    short dstInit = 0;
    int dstPos = 0;
    int nBytes = 2;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(770, result);
  }
  
  @Test
  @DisplayName("Test when dstInit is not 0")
  void testNonZeroDstInit() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 100;
    int dstPos = 0;
    int nBytes = 2;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(613, result);
  }
  
  @Test
  @DisplayName("Test when dstPos is not 0")
  void testNonZeroDstPos() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 0;
    int dstPos = 4;
    int nBytes = 2;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(2068, result);
  }
  
  @Test
  @DisplayName("Test when nBytes is the maximum value")
  void testMaxNBytes() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 0;
    int dstPos = 0;
    int nBytes = 4;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(16909060, result);
  }
  
  @Test
  @DisplayName("Test when src array has only one element")
  void testSingleElementSrcArray() {
    byte[] src = {1};
    int srcPos = 0;
    short dstInit = 0;
    int dstPos = 0;
    int nBytes = 1;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(1, result);
  }
  
  @Test
  @DisplayName("Test when src array has multiple elements but nBytes is 0")
  void testZeroNBytesWithMultipleSrcElements() {
    byte[] src = {1, 2, 3, 4};
    int srcPos = 0;
    short dstInit = 0;
    int dstPos = 0;
    int nBytes = 0;
    
    short result = Conversion.byteArrayToShort(src, srcPos, dstInit, dstPos, nBytes);
    
    assertEquals(dstInit, result);
  }
  
}
