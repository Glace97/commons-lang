import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getObjectTest {

    @Test
    void testGetObjectNotNull() {
        ToStringBuilder builder = new ToStringBuilder("test");
        assertNotNull(builder.getObject());
    }

    @Test
    void testGetObjectNull() {
        ToStringBuilder builder = new ToStringBuilder(null);
        assertNull(builder.getObject());
    }

}