import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class byteToBinaryTest {

    @Test
    void testByteToBinary() {
        Conversion conversion = new Conversion();

        // Test case 1: nBools = 0
        byte src1 = 0b01100101;
        int srcPos1 = 2;
        boolean[] dst1 = new boolean[8];
        int dstPos1 = 0;
        int nBools1 = 0;
        assertArrayEquals(dst1, conversion.byteToBinary(src1, srcPos1, dst1, dstPos1, nBools1));

        // Test case 2: nBools = 8
        byte src2 = 0b01100101;
        int srcPos2 = 2;
        boolean[] dst2 = new boolean[8];
        int dstPos2 = 0;
        int nBools2 = 8;
        boolean[] expected2 = new boolean[]{false, true, false, true, true, false, true, true};
        assertArrayEquals(expected2, conversion.byteToBinary(src2, srcPos2, dst2, dstPos2, nBools2));

        // Test case 3: nBools = 5
        byte src3 = 0b01100101;
        int srcPos3 = 2;
        boolean[] dst3 = new boolean[5];
        int dstPos3 = 0;
        int nBools3 = 5;
        boolean[] expected3 = new boolean[]{false, true, false, true, true};
        assertArrayEquals(expected3, conversion.byteToBinary(src3, srcPos3, dst3, dstPos3, nBools3));

        // Test case 4: nBools = 4
        byte src4 = 0b01100101;
        int srcPos4 = 2;
        boolean[] dst4 = new boolean[4];
        int dstPos4 = 0;
        int nBools4 = 4;
        boolean[] expected4 = new boolean[]{false, true, false, true};
        assertArrayEquals(expected4, conversion.byteToBinary(src4, srcPos4, dst4, dstPos4, nBools4));

        // Test case 5: nBools - 1 + srcPos >= 8
        byte src5 = 0b01100101;
        int srcPos5 = 6;
        boolean[] dst5 = new boolean[8];
        int dstPos5 = 0;
        int nBools5 = 4;
        assertThrows(IllegalArgumentException.class, () -> conversion.byteToBinary(src5, srcPos5, dst5, dstPos5, nBools5));

        // Test case 6: dst is null
        byte src6 = 0b01100101;
        int srcPos6 = 2;
        boolean[] dst6 = null;
        int dstPos6 = 0;
        int nBools6 = 4;
        assertThrows(NullPointerException.class, () -> conversion.byteToBinary(src6, srcPos6, dst6, dstPos6, nBools6));

        // Test case 7: dstPos + nBools > dst.length
        byte src7 = 0b01100101;
        int srcPos7 = 2;
        boolean[] dst7 = new boolean[4];
        int dstPos7 = 1;
        int nBools7 = 4;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> conversion.byteToBinary(src7, srcPos7, dst7, dstPos7, nBools7));
    }
}