import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class isJavaVersionAtLeastTest {

    @Test
    void testJavaVersionAtLeast() {
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_1));
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8));
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_9));
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_11));
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_16));
        Assertions.assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_17));

        Assertions.assertFalse(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_9));
        Assertions.assertFalse(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_12));
        Assertions.assertFalse(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_15));
        Assertions.assertFalse(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_18));
    }
}