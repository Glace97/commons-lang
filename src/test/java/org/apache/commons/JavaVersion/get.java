import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getTest {

    @Test
    void testGet_NullInput_ReturnsNull() {
        // Arrange
        String versionStr = null;

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertNull(result);
    }

    @Test
    void testGet_ValidVersionStr_ReturnsCorrectJavaVersion() {
        // Arrange
        String versionStr = "1.8";

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertEquals(JavaVersion.JAVA_1_8, result);
    }

    @Test
    void testGet_UnknownVersionStr_ReturnsNull() {
        // Arrange
        String versionStr = "2.0";

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertNull(result);
    }

    @Test
    void testGet_DecimalsGreaterThan9_ReturnsRecentJavaVersion() {
        // Arrange
        String versionStr = "1.9";

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertEquals(JavaVersion.JAVA_RECENT, result);
    }

    @Test
    void testGet_VersionGreaterThan10_ReturnsRecentJavaVersion() {
        // Arrange
        String versionStr = "11";

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertEquals(JavaVersion.JAVA_RECENT, result);
    }

    @Test
    void testGet_VersionWithCommaGreaterThan9_ReturnsRecentJavaVersion() {
        // Arrange
        String versionStr = "1,9";

        // Act
        JavaVersion result = JavaVersion.get(versionStr);

        // Assert
        assertEquals(JavaVersion.JAVA_RECENT, result);
    }
}