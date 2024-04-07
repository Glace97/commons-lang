
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    private DiffBuilder.Builder<Integer> builder;

    @BeforeEach
    void setUp() {
        builder = DiffBuilder.builder();
    }

    @Test
    void testBuild() {
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertNotNull(diffBuilder);
    }

    @Test
    void testSetLeft() {
        int left = 5;
        builder.setLeft(left);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(left, diffBuilder.getLeft());
    }

    @Test
    void testSetRight() {
        int right = 10;
        builder.setRight(right);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(right, diffBuilder.getRight());
    }

    @Test
    void testSetStyle() {
        ToStringStyle style = ToStringStyle.SHORT_PREFIX_STYLE;
        builder.setStyle(style);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(style, diffBuilder.getStyle());
    }

    @Test
    void testSetStyleNull() {
        builder.setStyle(null);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(ToStringStyle.DEFAULT_STYLE, diffBuilder.getStyle());
    }

    @Test
    void testSetTestObjectsEquals() {
        builder.setTestObjectsEquals(false);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertFalse(diffBuilder.getTestObjectsEquals());
    }

    @Test
    void testSetToStringFormat() {
        String toStringFormat = "Left: %s, Right: %s";
        builder.setToStringFormat(toStringFormat);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(toStringFormat, diffBuilder.getToStringFormat());
    }

    @Test
    void testSetToStringFormatNull() {
        builder.setToStringFormat(null);
        DiffBuilder<Integer> diffBuilder = builder.build();
        assertEquals(DiffBuilder.TO_STRING_FORMAT, diffBuilder.getToStringFormat());
    }
}
