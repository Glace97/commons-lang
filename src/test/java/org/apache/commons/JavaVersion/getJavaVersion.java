import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getJavaVersionTest {

    @Test
    void testGetJavaVersion() {
        // Test cases for known Java versions
        assertEquals(JavaVersion.JAVA_1_1, JavaVersion.getJavaVersion("1.1"));
        assertEquals(JavaVersion.JAVA_1_2, JavaVersion.getJavaVersion("1.2"));
        assertEquals(JavaVersion.JAVA_1_3, JavaVersion.getJavaVersion("1.3"));
        assertEquals(JavaVersion.JAVA_1_4, JavaVersion.getJavaVersion("1.4"));
        assertEquals(JavaVersion.JAVA_1_5, JavaVersion.getJavaVersion("1.5"));
        assertEquals(JavaVersion.JAVA_1_6, JavaVersion.getJavaVersion("1.6"));
        assertEquals(JavaVersion.JAVA_1_7, JavaVersion.getJavaVersion("1.7"));
        assertEquals(JavaVersion.JAVA_1_8, JavaVersion.getJavaVersion("1.8"));
        assertEquals(JavaVersion.JAVA_9, JavaVersion.getJavaVersion("9"));
        assertEquals(JavaVersion.JAVA_10, JavaVersion.getJavaVersion("10"));
        assertEquals(JavaVersion.JAVA_11, JavaVersion.getJavaVersion("11"));
        assertEquals(JavaVersion.JAVA_12, JavaVersion.getJavaVersion("12"));
        assertEquals(JavaVersion.JAVA_13, JavaVersion.getJavaVersion("13"));
        assertEquals(JavaVersion.JAVA_14, JavaVersion.getJavaVersion("14"));
        assertEquals(JavaVersion.JAVA_15, JavaVersion.getJavaVersion("15"));
        assertEquals(JavaVersion.JAVA_16, JavaVersion.getJavaVersion("16"));
        assertEquals(JavaVersion.JAVA_17, JavaVersion.getJavaVersion("17"));

        // Test cases for unknown Java versions
        assertNull(JavaVersion.getJavaVersion("1.0"));
        assertNull(JavaVersion.getJavaVersion("0.9"));
        assertNull(JavaVersion.getJavaVersion("18"));
        assertNull(JavaVersion.getJavaVersion("20"));
        assertNull(JavaVersion.getJavaVersion("abc"));
        assertNull(JavaVersion.getJavaVersion(""));
        assertNull(JavaVersion.getJavaVersion(null));
    }
}