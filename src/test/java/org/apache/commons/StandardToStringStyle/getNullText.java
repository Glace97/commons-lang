import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getNullTextTest {

    private StandardToStringStyle style;

    @Test
    void shouldReturnDefaultNullText() {
        style = new StandardToStringStyle();
        String nullText = style.getNullText();
        Assertions.assertEquals("null", nullText);
    }
}