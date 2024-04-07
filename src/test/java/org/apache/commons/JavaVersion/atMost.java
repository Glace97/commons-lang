import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class atMostTest {

    private JavaVersion myVersion;

    @BeforeEach
    void setUp() {
        myVersion = new JavaVersion();
    }

    @Test
    @DisplayName("Testing when myVersion is less than requiredVersion")
    void testAtMostWhenLessThanRequiredVersion() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(10);
        myVersion.setValue(8);
        assertFalse(myVersion.atMost(requiredVersion));
    }

    @Test
    @DisplayName("Testing when myVersion is equal to requiredVersion")
    void testAtMostWhenEqualToRequiredVersion() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(10);
        myVersion.setValue(10);
        assertTrue(myVersion.atMost(requiredVersion));
    }

    @Test
    @DisplayName("Testing when myVersion is greater than requiredVersion")
    void testAtMostWhenGreaterThanRequiredVersion() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(10);
        myVersion.setValue(12);
        assertTrue(myVersion.atMost(requiredVersion));
    }

    @Test
    @DisplayName("Testing when requiredVersion is null")
    void testAtMostWhenRequiredVersionIsNull() {
        JavaVersion requiredVersion = null;
        myVersion.setValue(10);
        Assertions.assertThrows(NullPointerException.class, () -> {
            myVersion.atMost(requiredVersion);
        });
    }

    @Test
    @DisplayName("Testing when requiredVersion value is negative")
    void testAtMostWhenRequiredVersionValueIsNegative() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(-5);
        myVersion.setValue(10);
        assertFalse(myVersion.atMost(requiredVersion));
    }

    @Test
    @DisplayName("Testing when myVersion value is negative")
    void testAtMostWhenMyVersionValueIsNegative() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(10);
        myVersion.setValue(-5);
        assertTrue(myVersion.atMost(requiredVersion));
    }
}