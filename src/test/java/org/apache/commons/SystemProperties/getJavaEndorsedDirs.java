import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getJavaEndorsedDirsTest {

    @Test
    void testGetJavaEndorsedDirs() {
        SystemProperties systemProperties = new SystemProperties();
        
        // Test when JAVA_ENDORSED_DIRS is set to a valid directory path
        System.setProperty("java.endorsed.dirs", "/path/to/endorsed/dirs");
        String expected1 = "/path/to/endorsed/dirs";
        String actual1 = systemProperties.getJavaEndorsedDirs();
        assertEquals(expected1, actual1);
        
        // Test when JAVA_ENDORSED_DIRS is set to an empty string
        System.setProperty("java.endorsed.dirs", "");
        String expected2 = "";
        String actual2 = systemProperties.getJavaEndorsedDirs();
        assertEquals(expected2, actual2);
        
        // Test when JAVA_ENDORSED_DIRS is not set
        System.clearProperty("java.endorsed.dirs");
        String expected3 = null;
        String actual3 = systemProperties.getJavaEndorsedDirs();
        assertEquals(expected3, actual3);
        
        // Test when JAVA_ENDORSED_DIRS is set to null
        System.setProperty("java.endorsed.dirs", null);
        String expected4 = null;
        String actual4 = systemProperties.getJavaEndorsedDirs();
        assertEquals(expected4, actual4);
    }
}