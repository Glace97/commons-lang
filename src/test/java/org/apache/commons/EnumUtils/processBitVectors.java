import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;
import java.util.List;

class processBitVectorsTest {

    private enum TestEnum {
        VALUE1,
        VALUE2,
        VALUE3,
        VALUE4,
        VALUE5
    }

    private EnumUtils enumUtils;

    @BeforeEach
    void setUp() {
        enumUtils = new EnumUtils();
    }

    @Test
    void testProcessBitVectors() {
        long[] bitVectors = {1, 2, 4, 8, 16};
        EnumSet<TestEnum> expected = EnumSet.allOf(TestEnum.class);

        EnumSet<TestEnum> result = enumUtils.processBitVectors(TestEnum.class, bitVectors);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testProcessBitVectorsWithEmptyBitVectors() {
        long[] bitVectors = {};
        EnumSet<TestEnum> expected = EnumSet.noneOf(TestEnum.class);

        EnumSet<TestEnum> result = enumUtils.processBitVectors(TestEnum.class, bitVectors);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testProcessBitVectorsWithNullBitVectors() {
        long[] bitVectors = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            enumUtils.processBitVectors(TestEnum.class, bitVectors);
        });
    }

    @Test
    void testProcessBitVectorsWithInvalidEnumClass() {
        long[] bitVectors = {1, 2, 4, 8, 16};

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            enumUtils.processBitVectors(String.class, bitVectors);
        });
    }

    @Test
    void testProcessBitVectorsWithInvalidEnumValues() {
        long[] bitVectors = {1, 2, 4, 8, 32};

        EnumSet<TestEnum> expected = EnumSet.of(TestEnum.VALUE1, TestEnum.VALUE2, TestEnum.VALUE3, TestEnum.VALUE4);

        EnumSet<TestEnum> result = enumUtils.processBitVectors(TestEnum.class, bitVectors);

        Assertions.assertEquals(expected, result);
    }

}