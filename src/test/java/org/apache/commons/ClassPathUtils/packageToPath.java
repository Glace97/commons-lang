import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class packageToPathTest {

    @Test
    @DisplayName("Tests converting a valid package name to path")
    void testPackageToPath_ValidPackageName() {
        String packageName = "com.example.package";
        String expectedPath = "com/example/package";
        
        String actualPath = ClassPathUtils.packageToPath(packageName);
        
        Assertions.assertEquals(expectedPath, actualPath);
    }
    
    @Test
    @DisplayName("Tests converting a package name with null value")
    void testPackageToPath_NullPackageName() {
        String packageName = null;
        
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.packageToPath(packageName);
        });
    }
    
    @Test
    @DisplayName("Tests converting an empty package name to path")
    void testPackageToPath_EmptyPackageName() {
        String packageName = "";
        String expectedPath = "";
        
        String actualPath = ClassPathUtils.packageToPath(packageName);
        
        Assertions.assertEquals(expectedPath, actualPath);
    }
    
    @Test
    @DisplayName("Tests converting a package name with leading/trailing spaces to path")
    void testPackageToPath_PackageNameWithSpaces() {
        String packageName = " com.example.package ";
        String expectedPath = "/com/example/package/";
        
        String actualPath = ClassPathUtils.packageToPath(packageName);
        
        Assertions.assertEquals(expectedPath, actualPath);
    }
    
    @Test
    @DisplayName("Tests converting a package name with multiple consecutive dots to path")
    void testPackageToPath_PackageNameWithConsecutiveDots() {
        String packageName = "com..example.package";
        String expectedPath = "com//example/package";
        
        String actualPath = ClassPathUtils.packageToPath(packageName);
        
        Assertions.assertEquals(expectedPath, actualPath);
    }
    
    @Test
    @DisplayName("Tests converting a package name with special characters to path")
    void testPackageToPath_PackageNameWithSpecialCharacters() {
        String packageName = "com.example.package@123";
        String expectedPath = "com/example/package@123";
        
        String actualPath = ClassPathUtils.packageToPath(packageName);
        
        Assertions.assertEquals(expectedPath, actualPath);
    }
}