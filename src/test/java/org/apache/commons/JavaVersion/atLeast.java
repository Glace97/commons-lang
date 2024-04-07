import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class atLeastTest {

    @Test
    void testAtLeast() {
        JavaVersion myVersion = new JavaVersion();
        assertTrue(myVersion.atLeast(JavaVersion.JAVA_1_4));

        assertFalse(myVersion.atLeast(JavaVersion.JAVA_1_3));

        assertTrue(myVersion.atLeast(JavaVersion.JAVA_1_1));

        assertTrue(myVersion.atLeast(JavaVersion.JAVA_1_0));

        assertFalse(myVersion.atLeast(JavaVersion.JAVA_1_5));
    }
}