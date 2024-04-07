import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isOSMatchTest {

    @Test
    void testIsOSMatch() {
        // Test when the operating system matches
        assertTrue(SystemUtils.isOSMatch("Windows 10", "10.0", "Windows", "10"));
        assertTrue(SystemUtils.isOSMatch("Mac OS X 10.15", "10.15", "Mac OS X", "10.15"));
        assertTrue(SystemUtils.isOSMatch("Linux", "", "Linux", ""));

        // Test when the operating system does not match
        assertFalse(SystemUtils.isOSMatch("Windows 7", "6.1", "Windows", "10"));
        assertFalse(SystemUtils.isOSMatch("Mac OS X 10.11", "10.11", "Mac OS X", "10.12"));
        assertFalse(SystemUtils.isOSMatch("Linux", "", "Windows", ""));

        // Test when the operating system name or version is null
        assertFalse(SystemUtils.isOSMatch(null, "10.0", "Windows", "10"));
        assertFalse(SystemUtils.isOSMatch("Windows 10", null, "Windows", "10"));
        assertFalse(SystemUtils.isOSMatch(null, null, "Windows", "10"));
    }
}