import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestSuite;

@TestSuite
public class longToHexTest {

    @Test
    public void testEmptyString() {
        long src = 0;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 0;
        
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        Assertions.assertEquals("", result);
    }

    @Test
    public void testSingleHexDigit() {
        long src = 15;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 1;
        
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        Assertions.assertEquals("F", result);
    }

    @Test
    public void testMultipleHexDigits() {
        long src = 123456789;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 8;
        
        String result = Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        
        Assertions.assertEquals("075BCD15", result);
    }

    @Test
    public void testInvalidNHexs() {
        long src = 123;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 9;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    public void testOutOfBoundsDstPos() {
        long src = 123;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 5;
        int nHexs = 1;
        
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }
}