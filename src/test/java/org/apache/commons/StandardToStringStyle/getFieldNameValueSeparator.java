import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class getFieldNameValueSeparatorTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setup() {
        style = new StandardToStringStyle();
    }

    @Test
    void testGetFieldNameValueSeparator() {
        String separator = style.getFieldNameValueSeparator();
        Assertions.assertEquals("=", separator);
    }

    @Test
    void testGetFieldNameValueSeparatorWithCustomSeparator() {
        // Set a custom separator
        style.setFieldNameValueSeparator(":");
        String separator = style.getFieldNameValueSeparator();

        Assertions.assertEquals(":", separator);
    }

    @Test
    void testGetFieldNameValueSeparatorWithNullSeparator() {
        // Set null separator
        style.setFieldNameValueSeparator(null);
        String separator = style.getFieldNameValueSeparator();

        Assertions.assertNull(separator);
    }

    @Test
    void testGetFieldNameValueSeparatorWithEmptySeparator() {
        // Set empty separator
        style.setFieldNameValueSeparator("");
        String separator = style.getFieldNameValueSeparator();

        Assertions.assertEquals("", separator);
    }
}