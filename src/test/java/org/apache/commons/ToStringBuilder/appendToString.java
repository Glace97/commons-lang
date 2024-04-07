import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class appendToStringTest {

    @Test
    void testAppendToString() {
        ToStringBuilder builder = new ToStringBuilder(null); // Test with null object
        builder.appendToString(null); // Test with null toString
        String toString = "Example toString";
        builder.appendToString(toString); // Test with non-null toString
        String expected = toString;
        String actual = builder.buffer.toString();
        assertEquals(expected, actual);

        builder = new ToStringBuilder(null, null); // Test with null object and null style
        builder.appendToString(null); // Test with null toString
        builder.appendToString(toString); // Test with non-null toString
        expected = toString;
        actual = builder.buffer.toString();
        assertEquals(expected, actual);

        builder = new ToStringBuilder(null, ToStringStyle.SHORT_PREFIX_STYLE); // Test with null object and custom style
        builder.appendToString(null); // Test with null toString
        builder.appendToString(toString); // Test with non-null toString
        expected = toString;
        actual = builder.buffer.toString();
        assertEquals(expected, actual);

        Object object = new Object();
        builder = new ToStringBuilder(object); // Test with non-null object
        builder.appendToString(toString); // Test with non-null toString
        expected = toString;
        actual = builder.buffer.toString();
        assertEquals(expected, actual);

        builder = new ToStringBuilder(object, null); // Test with non-null object and null style
        builder.appendToString(toString); // Test with non-null toString
        expected = toString;
        actual = builder.buffer.toString();
        assertEquals(expected, actual);

        builder = new ToStringBuilder(object, ToStringStyle.SHORT_PREFIX_STYLE); // Test with non-null object and custom style
        builder.appendToString(toString); // Test with non-null toString
        expected = toString;
        actual = builder.buffer.toString();
        assertEquals(expected, actual);
    }
}