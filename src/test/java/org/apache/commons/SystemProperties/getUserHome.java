import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getUserHomeTest {

    @Test
    void testGetUserHome() {
        String expected = System.getProperty("user.home");
        String actual = SystemProperties.getUserHome();
        assertEquals(expected, actual);
    }

}