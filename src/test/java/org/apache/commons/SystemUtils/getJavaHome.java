import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaHomeTest {

    @Test
    void testJavaHomeNotNull() {
        assertNotNull(SystemUtils.getJavaHome());
    }

    @Test
    void testJavaHomeIsDirectory() {
        assertTrue(SystemUtils.getJavaHome().isDirectory());
    }

    @Test
    void testJavaHomePath() {
        String expectedPath = System.getProperty("java.home");
        String actualPath = SystemUtils.getJavaHome().getPath();
        assertEquals(expectedPath, actualPath);
    }
}