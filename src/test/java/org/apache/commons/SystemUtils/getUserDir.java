import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getUserDirTest {
    
    @Test
    void testGetUserDir() {
        String userDir = System.getProperty("user.dir");
        assertEquals(userDir, SystemUtils.getUserDir().getAbsolutePath());
    }
    
}