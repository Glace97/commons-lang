import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class shortToBinaryTest {

    private Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }

    @Test
    void testShortToBinary_SrcPosZero_NBoolsZero() {
        boolean[] expected = new boolean[4];
        boolean[] actual = conversion.shortToBinary((short) 0, 0, expected, 0, 0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_SrcPosZero_NBoolsOne() {
        boolean[] expected = new boolean[4];
        expected[0] = true;
        boolean[] actual = conversion.shortToBinary((short) 1, 0, new boolean[4], 0, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_SrcPosZero_NBoolsFour() {
        boolean[] expected = {false, false, false, true};
        boolean[] actual = conversion.shortToBinary((short) 1, 0, new boolean[4], 0, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_SrcPosZero_NBoolsFive_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.shortToBinary((short) 1, 0, new boolean[4], 0, 5);
        });
    }

    @Test
    void testShortToBinary_SrcPosFifteen_NBoolsOne() {
        boolean[] expected = new boolean[4];
        expected[3] = true;
        boolean[] actual = conversion.shortToBinary((short) 1, 15, new boolean[4], 0, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_SrcPosFifteen_NBoolsFour() {
        boolean[] expected = {true, true, true, true};
        boolean[] actual = conversion.shortToBinary((short) 1, 15, new boolean[4], 0, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_SrcPosFifteen_NBoolsFive_ExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.shortToBinary((short) 1, 15, new boolean[4], 0, 5);
        });
    }

    @Test
    void testShortToBinary_DstPosZero() {
        boolean[] expected = {true, false, false, false};
        boolean[] actual = conversion.shortToBinary((short) 1, 0, new boolean[4], 0, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_DstPosOne() {
        boolean[] expected = {false, true, false, false};
        boolean[] actual = conversion.shortToBinary((short) 1, 0, new boolean[4], 1, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testShortToBinary_DstPosThree() {
        boolean[] expected = {false, false, false, true};
        boolean[] actual = conversion.shortToBinary((short) 1, 0, new boolean[4], 3, 4);
        assertArrayEquals(expected, actual);
    }
}