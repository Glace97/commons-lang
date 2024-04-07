import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class pathToPackageTest {

    @Test
    @DisplayName("Test pathToPackage with valid path")
    void testPathToPackageValidPath() {
        String path = "com/example/package";
        String expectedPackage = "com.example.package";
        assertEquals(expectedPackage, ClassPathUtils.pathToPackage(path));
    }

    @Test
    @DisplayName("Test pathToPackage with null path")
    void testPathToPackageNullPath() {
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.pathToPackage(null);
        });
    }

    @Test
    @DisplayName("Test pathToPackage with empty path")
    void testPathToPackageEmptyPath() {
        String path = "";
        String expectedPackage = "";
        assertEquals(expectedPackage, ClassPathUtils.pathToPackage(path));
    }

    @Test
    @DisplayName("Test pathToPackage with path containing trailing slash")
    void testPathToPackagePathWithTrailingSlash() {
        String path = "com/example/package/";
        String expectedPackage = "com.example.package.";
        assertEquals(expectedPackage, ClassPathUtils.pathToPackage(path));
    }

    @Test
    @DisplayName("Test pathToPackage with path containing leading slash")
    void testPathToPackagePathWithLeadingSlash() {
        String path = "/com/example/package";
        String expectedPackage = ".com.example.package";
        assertEquals(expectedPackage, ClassPathUtils.pathToPackage(path));
    }
}