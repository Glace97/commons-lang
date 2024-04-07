import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getAwtToolkitTest {

    @Test
    void testGetAwtToolkit() {
        String awtToolkit = SystemProperties.getAwtToolkit();
        assertNotNull(awtToolkit);
        assertFalse(awtToolkit.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"awt.toolkit", "file.encoding", "file.separator", "java.awt.fonts", "java.awt.graphicsenv", 
        "java.awt.headless", "java.awt.printerjob", "java.class.path", "java.class.version", "java.compiler", 
        "java.endorsed.dirs", "java.ext.dirs", "java.home", "java.io.tmpdir", "java.library.path", 
        "java.locale.providers", "java.runtime.name", "java.runtime.version", "java.specification.name", 
        "java.specification.vendor", "java.specification.version", "java.util.prefs.PreferencesFactory", 
        "java.vendor", "java.vendor.url", "java.version", "java.vm.info", "java.vm.name", 
        "java.vm.specification.name", "java.vm.specification.vendor", "java.vm.specification.version", 
        "java.vm.vendor", "java.vm.version", "line.separator", "os.arch", "os.name", "os.version", 
        "path.separator", "user.country", "user.dir", "user.home", "user.language", "user.name", "user.region", 
        "user.timezone"})
    void testGetProperty(String propertyName) {
        String propertyValue = SystemProperties.getProperty(propertyName);
        assertNotNull(propertyValue);
    }
}