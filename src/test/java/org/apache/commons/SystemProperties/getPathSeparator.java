import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class getPathSeparatorTest {

    @Test
    void testPathSeparator() {
        String pathSeparator = System.getProperty("path.separator");
        assertEquals(pathSeparator, SystemProperties.getPathSeparator());
    }
    
    @Test
    void testPathSeparatorNull() {
        String pathSeparator = System.getProperty("path.separator");
        assertEquals(pathSeparator, SystemProperties.getPathSeparator());
    }
    
    @Test
    void testPathSeparatorEmpty() {
        String pathSeparator = System.getProperty("path.separator");
        assertEquals(pathSeparator, SystemProperties.getPathSeparator());
    }
    
    @Test
    void testPathSeparatorDifferentValue() {
        String pathSeparator = System.getProperty("path.separator");
        assertEquals(pathSeparator, SystemProperties.getPathSeparator());
    }
}