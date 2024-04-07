import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.math.RoundingMode;

class toScaledBigDecimalTest {
    private NumberUtils numberUtils;

    @BeforeEach
    void setUp() {
        numberUtils = new NumberUtils();
    }

    @Test
    void testToScaledBigDecimalWithNullValue() {
        BigDecimal result = numberUtils.toScaledBigDecimal(null);

        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testToScaledBigDecimalWithNullValueAndCustomScale() {
        BigDecimal result = numberUtils.toScaledBigDecimal(null, 4, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testToScaledBigDecimalWithNonNullValue() {
        BigDecimal value = new BigDecimal("10.123456");
        BigDecimal result = numberUtils.toScaledBigDecimal(value);

        Assertions.assertEquals(new BigDecimal("10.12"), result);
    }

    @Test
    void testToScaledBigDecimalWithNonNullValueAndCustomScale() {
        BigDecimal value = new BigDecimal("10.123456");
        BigDecimal result = numberUtils.toScaledBigDecimal(value, 4, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(new BigDecimal("10.1235"), result);
    }

    @Test
    void testToScaledBigDecimalWithDoubleValue() {
        Double value = 10.123456;
        BigDecimal result = numberUtils.toScaledBigDecimal(value);

        Assertions.assertEquals(new BigDecimal("10.12"), result);
    }

    @Test
    void testToScaledBigDecimalWithDoubleValueAndCustomScale() {
        Double value = 10.123456;
        BigDecimal result = numberUtils.toScaledBigDecimal(value, 4, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(new BigDecimal("10.1235"), result);
    }

    @Test
    void testToScaledBigDecimalWithFloatValue() {
        Float value = 10.123456f;
        BigDecimal result = numberUtils.toScaledBigDecimal(value);

        Assertions.assertEquals(new BigDecimal("10.12"), result);
    }

    @Test
    void testToScaledBigDecimalWithFloatValueAndCustomScale() {
        Float value = 10.123456f;
        BigDecimal result = numberUtils.toScaledBigDecimal(value, 4, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(new BigDecimal("10.1235"), result);
    }

    @Test
    void testToScaledBigDecimalWithStringValue() {
        String value = "10.123456";
        BigDecimal result = numberUtils.toScaledBigDecimal(value);

        Assertions.assertEquals(new BigDecimal("10.12"), result);
    }

    @Test
    void testToScaledBigDecimalWithStringValueAndCustomScale() {
        String value = "10.123456";
        BigDecimal result = numberUtils.toScaledBigDecimal(value, 4, RoundingMode.HALF_EVEN);

        Assertions.assertEquals(new BigDecimal("10.1235"), result);
    }
}