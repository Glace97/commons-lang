import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class buildTest {

    @Test
    void testBuildWithDefaultStyle() {
        Object object = new Object();
        ToStringBuilder builder = new ToStringBuilder(object);
        String expected = object.toString();
        String actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuildWithCustomStyle() {
        Object object = new Object();
        ToStringStyle style = new ToStringStyle() {
            @Override
            public void appendStart(StringBuffer buffer, Object object) {
                buffer.append("Custom start");
            }
        };
        ToStringBuilder builder = new ToStringBuilder(object, style);
        String expected = "Custom start" + object.toString();
        String actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuildWithCustomStyleAndBuffer() {
        Object object = new Object();
        ToStringStyle style = new ToStringStyle() {
            @Override
            public void appendStart(StringBuffer buffer, Object object) {
                buffer.append("Custom start");
            }
        };
        StringBuffer buffer = new StringBuffer();
        ToStringBuilder builder = new ToStringBuilder(object, style, buffer);
        String expected = "Custom start" + object.toString();
        String actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuildWithNullObject() {
        ToStringBuilder builder = new ToStringBuilder(null);
        String expected = "null";
        String actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuildWithNullStyle() {
        Object object = new Object();
        ToStringBuilder builder = new ToStringBuilder(object, null);
        String expected = object.toString();
        String actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuildWithNullBuffer() {
        Object object = new Object();
        ToStringBuilder builder = new ToStringBuilder(object, null, null);
        String expected = object.toString();
        String actual = builder.build();
        assertEquals(expected, actual);
    }
}