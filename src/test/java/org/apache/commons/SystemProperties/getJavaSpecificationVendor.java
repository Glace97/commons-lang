import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import java.security.Permission;

class SystemPropertiesTest {
    
    private static SecurityManager securityManager;
    
    @BeforeAll
    static void setUp() {
        securityManager = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
            }

            @Override
            public void checkPermission(Permission perm, Object context) {
            }
        });
    }
    
    @Test
    @DisplayName("Test getJavaSpecificationVendor when property exists")
    void testGetJavaSpecificationVendor() {
        SystemProperties systemProperties = new SystemProperties();
        
        String vendor = "Oracle Corporation";
        System.setProperty("java.specification.vendor", vendor);
        
        assertEquals(vendor, systemProperties.getJavaSpecificationVendor());
    }
    
    @Test
    @DisplayName("Test getJavaSpecificationVendor when property does not exist")
    void testGetJavaSpecificationVendorNull() {
        SystemProperties systemProperties = new SystemProperties();
        
        assertEquals(null, systemProperties.getJavaSpecificationVendor());
    }
    
    @Test
    @DisplayName("Test getJavaSpecificationVendor when SecurityException is thrown")
    void testGetJavaSpecificationVendorSecurityException() {
        SystemProperties systemProperties = new SystemProperties();
        
        System.setSecurityManager(securityManager);
        
        assertEquals(null, systemProperties.getJavaSpecificationVendor());
    }
}