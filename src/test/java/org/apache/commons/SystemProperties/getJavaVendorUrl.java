import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.security.Permission;

class getJavaVendorUrlTest {

    @Test
    void testGetJavaVendorUrl() {
        SystemPropertiesStub systemPropertiesStub = new SystemPropertiesStub();
        System.setProperties(systemPropertiesStub);

        String expectedUrl = "https://www.oracle.com";
        systemPropertiesStub.setProperty(SystemProperties.JAVA_VENDOR_URL, expectedUrl);

        String actualUrl = SystemProperties.getJavaVendorUrl();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void testGetJavaVendorUrlNull() {
        SystemPropertiesStub systemPropertiesStub = new SystemPropertiesStub();
        System.setProperties(systemPropertiesStub);

        String actualUrl = SystemProperties.getJavaVendorUrl();

        assertEquals(null, actualUrl);
    }

    private static class SystemPropertiesStub extends SecurityManager {

        private java.util.Properties properties;

        SystemPropertiesStub() {
            properties = new java.util.Properties();
        }

        void setProperty(String key, String value) {
            properties.setProperty(key, value);
        }

        @Override
        public void checkPermission(Permission perm) {
            // Do nothing
        }

        @Override
        public void checkPropertyAccess(String key) {
            // Do nothing
        }

        @Override
        public java.util.Properties getProperties() {
            return properties;
        }
    }
}