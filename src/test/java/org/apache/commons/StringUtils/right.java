import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestSuite;

class RightTest {

    @Test
    void testRightWithNullString() {
        String result = StringUtils.right(null, 5);
        Assertions.assertNull(result);
    }

    @Test
    void testRightWithNegativeLength() {
        String result = StringUtils.right("abc", -1);
        Assertions.assertEquals("", result);
    }

    @Test
    void testRightWithEmptyString() {
        String result = StringUtils.right("", 3);
        Assertions.assertEquals("", result);
    }

    @Test
    void testRightWithZeroLength() {
        String result = StringUtils.right("abc", 0);
        Assertions.assertEquals("", result);
    }

    @Test
    void testRightWithStringLengthLessThanLength() {
        String result = StringUtils.right("abc", 5);
        Assertions.assertEquals("abc", result);
    }

    @Test
    void testRightWithStringLengthEqualToLength() {
        String result = StringUtils.right("abc", 3);
        Assertions.assertEquals("abc", result);
    }

    @Test
    void testRightWithStringLengthGreaterThanLength() {
        String result = StringUtils.right("abcde", 2);
        Assertions.assertEquals("de", result);
    }
}

public class RightTestSuite {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RightTest.class);
        return suite;
    }
}

In the above code, I have created a test class named "RightTest" that contains multiple test methods to achieve high coverage and cover all edge cases for the "right" method. Additionally, I have created a test suite class named "RightTestSuite" that includes the "RightTest" class in the test suite.