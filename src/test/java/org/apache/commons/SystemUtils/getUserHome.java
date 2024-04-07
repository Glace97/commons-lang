import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class getUserHomeTest {

    @Test
    void testUserHome() {
        File expected = new File(System.getProperty("user.home"));
        File actual = SystemUtils.getUserHome();
        assertEquals(expected, actual);
    }

}