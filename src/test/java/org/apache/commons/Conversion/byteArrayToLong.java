
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class byteArrayToLongTest {

    private Conversion conversion;

    @BeforeAll
    void setUp() {
        conversion = new Conversion();
    }

    @Test
    void testByteArrayToLong_emptyArrayAndZeroLength_shouldReturnDstInit() {
        byte[] src = {};
        int srcPos = 0;
        long dstInit = 123456789L;
        int dstPos = 0;
        int nBytes = 0;

        long result = Conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);

        Assertions.assertEquals(dstInit, result);
    }

    @Test
    void testByteArrayToLong_invalidPositionAndLength_shouldThrowIllegalArgumentException() {
        byte[] src = {1, 2, 3};
        int srcPos = 2;
        long dstInit = 0;
        int dstPos = 0;
        int nBytes = 2;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);
        });
    }

    @Test
    void testByteArrayToLong_validArguments_shouldReturnExpectedResult() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nBytes = 4;

        long result = Conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);

        Assertions.assertEquals(0x04030201L, result);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testByteArrayToLong_edgeCases_shouldReturnExpectedResult(byte[] src, int srcPos, long dstInit, int dstPos, int nBytes, long expected) {
        long result = Conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(conversion.TTTT, 0, 0, 0, 4, 0x0F0F0F0FL),
                Arguments.of(conversion.FTTT, 0, 0, 0, 4, 0x0F0F0F0EL),
                Arguments.of(conversion.TFTT, 0, 0, 0, 4, 0x0F0F0F0DL),
                Arguments.of(conversion.FFTT, 0, 0, 0, 4, 0x0F0F0F0CL),
                Arguments.of(conversion.TTFT, 0, 0, 0, 4, 0x0F0F0F0BL),
                Arguments.of(conversion.FTFT, 0, 0, 0, 4, 0x0F0F0F0AL),
                Arguments.of(conversion.TFFT, 0, 0, 0, 4, 0x0F0F0F09L),
                Arguments.of(conversion.FFFT, 0, 0, 0, 4, 0x0F0F0F08L),
                Arguments.of(conversion.TTTF, 0, 0, 0, 4, 0x0F0F0F07L),
                Arguments.of(conversion.FTTF, 0, 0, 0, 4, 0x0F0F0F06L),
                Arguments.of(conversion.TFTF, 0, 0, 0, 4, 0x0F0F0F05L),
                Arguments.of(conversion.FFTF, 0, 0, 0, 4, 0x0F0F0F04L),
                Arguments.of(conversion.TTFF, 0, 0, 0, 4, 0x0F0F0F03L),
                Arguments.of(conversion.FTFF, 0, 0, 0, 4, 0x0F0F0F02L),
                Arguments.of(conversion.TFFF, 0, 0, 0, 4, 0x0F0F0F01L),
                Arguments.of(conversion.FFFF, 0, 0, 0, 4, 0x0F0F0F00L)
        );
    }
}
