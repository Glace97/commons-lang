import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isJavaAwtHeadlessTest {

    @Test
    void testIsJavaAwtHeadless() {
        // Test when JAVA_AWT_HEADLESS is null
        SystemUtils.JAVA_AWT_HEADLESS = null;
        assertFalse(SystemUtils.isJavaAwtHeadless());

        // Test when JAVA_AWT_HEADLESS is "true"
        SystemUtils.JAVA_AWT_HEADLESS = "true";
        assertTrue(SystemUtils.isJavaAwtHeadless());

        // Test when JAVA_AWT_HEADLESS is "false"
        SystemUtils.JAVA_AWT_HEADLESS = "false";
        assertFalse(SystemUtils.isJavaAwtHeadless());

        // Test when JAVA_AWT_HEADLESS is "TRUE"
        SystemUtils.JAVA_AWT_HEADLESS = "TRUE";
        assertTrue(SystemUtils.isJavaAwtHeadless());

        // Test when JAVA_AWT_HEADLESS is "FALSE"
        SystemUtils.JAVA_AWT_HEADLESS = "FALSE";
        assertFalse(SystemUtils.isJavaAwtHeadless());

        // Test when JAVA_AWT_HEADLESS is "randomString"
        SystemUtils.JAVA_AWT_HEADLESS = "randomString";
        assertFalse(SystemUtils.isJavaAwtHeadless());
    }
}
