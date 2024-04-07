import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class setStyleTest {

    private DiffBuilder<String> diffBuilder;

    @BeforeEach
    void setUp() {
        diffBuilder = new DiffBuilder<>();
    }

    @Test
    void testSetStyleWithNonNullStyle() {
        ToStringStyle style = ToStringStyle.JSON_STYLE;
        DiffBuilder<String>.Builder<String> builder = diffBuilder.setStyle(style);
        Assertions.assertEquals(style, builder.getStyle());
    }

    @Test
    void testSetStyleWithNullStyle() {
        DiffBuilder<String>.Builder<String> builder = diffBuilder.setStyle(null);
        Assertions.assertEquals(ToStringStyle.DEFAULT_STYLE, builder.getStyle());
    }
}