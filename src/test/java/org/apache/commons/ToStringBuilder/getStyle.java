import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getStyleTest {
    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        toStringBuilder = new ToStringBuilder(mock(Object.class));
    }

    @Test
    void testGetStyle_DefaultStyle() {
        ToStringStyle expected = ToStringStyle.DEFAULT_STYLE;
        ToStringStyle actual = toStringBuilder.getStyle();
        assertEquals(expected, actual);
    }

    @Test
    void testGetStyle_CustomStyle() {
        ToStringStyle customStyle = new ToStringStyle() {
            // Custom implementation of ToStringStyle
        };
        ToStringBuilder customToStringBuilder = new ToStringBuilder(mock(Object.class), customStyle);
        ToStringStyle expected = customStyle;
        ToStringStyle actual = customToStringBuilder.getStyle();
        assertEquals(expected, actual);
    }

    @Test
    void testGetStyle_NullStyle() {
        ToStringStyle expected = ToStringStyle.DEFAULT_STYLE;
        ToStringBuilder nullStyleToStringBuilder = new ToStringBuilder(mock(Object.class), null);
        ToStringStyle actual = nullStyleToStringBuilder.getStyle();
        assertEquals(expected, actual);
    }
}