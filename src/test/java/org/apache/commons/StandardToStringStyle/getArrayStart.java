import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getArrayStartTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testGetArrayStart() {
        assertEquals("[", style.getArrayStart());
    }
}