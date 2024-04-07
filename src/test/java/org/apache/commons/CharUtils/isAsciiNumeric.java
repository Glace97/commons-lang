import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isAsciiNumericTest {

    @Test
    void testAsciiNumeric() {
        Assertions.assertTrue(CharUtils.isAsciiNumeric('0'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('1'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('2'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('3'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('4'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('5'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('6'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('7'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('8'));
        Assertions.assertTrue(CharUtils.isAsciiNumeric('9'));
    }

    @Test
    void testNonAsciiNumeric() {
        Assertions.assertFalse(CharUtils.isAsciiNumeric('a'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('A'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('-'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('\n'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('\r'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('\0'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('&'));
        Assertions.assertFalse(CharUtils.isAsciiNumeric('©'));
    }
}