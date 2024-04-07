
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppendTest {

    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        Object object = new Object();
        ToStringStyle style = new ToStringStyle();
        StringBuffer buffer = new StringBuffer();
        toStringBuilder = new ToStringBuilder(object, style, buffer);
    }

    @Test
    void append_booleanValue_shouldAppendToBuffer() {
        boolean value = true;
        ToStringBuilder result = toStringBuilder.append(value);
        assertEquals("true", result.buffer.toString());
    }

    @Test
    void append_booleanArray_shouldAppendToBuffer() {
        boolean[] array = {true, false};
        ToStringBuilder result = toStringBuilder.append(array);
        assertEquals("[true, false]", result.buffer.toString());
    }

    // More test cases for other types of append methods...

    @Test
    void append_stringFieldNameAndBooleanValue_shouldAppendToBufferWithFieldName() {
        String fieldName = "field";
        boolean value = true;
        ToStringBuilder result = toStringBuilder.append(fieldName, value);
        assertEquals("field=true", result.buffer.toString());
    }

    @Test
    void append_stringFieldNameAndBooleanArray_shouldAppendToBufferWithFieldName() {
        String fieldName = "field";
        boolean[] array = {true, false};
        ToStringBuilder result = toStringBuilder.append(fieldName, array);
        assertEquals("field=[true, false]", result.buffer.toString());
    }

    // More test cases for other types of append methods...

}
