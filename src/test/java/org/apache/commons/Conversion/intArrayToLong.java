import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("intArrayToLongTest")
class intArrayToLongTest {

    private Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }

    @Test
    @DisplayName("Convert int array to long with default parameters")
    void testIntArrayToLong_DefaultParameters() {
        int[] src = {1, 2, 3};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 3;

        long result = conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(858993459L, result);
    }

    @Test
    @DisplayName("Convert empty int array to long")
    void testIntArrayToLong_EmptyIntArray() {
        int[] src = {};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 0;

        long result = conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Convert int array to long with maximum number of ints")
    void testIntArrayToLong_MaximumInts() {
        int[] src = {1, 2, 3, 4, 5};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 5;

        long result = conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(1162939782297605L, result);
    }

    @Test
    @DisplayName("Convert int array to long with dstPos at maximum value")
    void testIntArrayToLong_MaximumDstPos() {
        int[] src = {1, 2, 3};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 32;
        int nInts = 3;

        long result = conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(8589934592000000000L, result);
    }

    @Test
    @DisplayName("Convert int array to long with nInts at maximum value")
    void testIntArrayToLong_MaximumNInts() {
        int[] src = {1, 2, 3, 4, 5};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 5;

        long result = conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(1162939782297605L, result);
    }

    @Test
    @DisplayName("Convert int array to long with invalid dstPos")
    void testIntArrayToLong_InvalidDstPos() {
        int[] src = {1, 2, 3};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 64;
        int nInts = 3;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        });
    }

    @Test
    @DisplayName("Convert int array to long with invalid srcPos")
    void testIntArrayToLong_InvalidSrcPos() {
        int[] src = {1, 2, 3};
        int srcPos = 4;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 3;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        });
    }

    @Test
    @DisplayName("Convert int array to long with null src")
    void testIntArrayToLong_NullSrc() {
        int[] src = null;
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 3;

        Assertions.assertThrows(NullPointerException.class, () -> {
            conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        });
    }
}