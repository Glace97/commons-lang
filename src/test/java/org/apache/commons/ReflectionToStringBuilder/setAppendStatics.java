import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setAppendStaticsTest {
    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void setAppendStatics_True() {
        builder.setAppendStatics(true);
        assertTrue(builder.appendStatics);
    }

    @Test
    void setAppendStatics_False() {
        builder.setAppendStatics(false);
        assertFalse(builder.appendStatics);
    }
}