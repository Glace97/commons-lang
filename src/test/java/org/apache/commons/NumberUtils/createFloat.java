import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class createFloatTest {

    @Test
    void testCreateFloatWithNullString() {
        Float result = NumberUtils.createFloat(null);
        Assertions.assertNull(result);
    }

    @Test
    void testCreateFloatWithEmptyString() {
        Float result = NumberUtils.createFloat("");
        Assertions.assertNull(result);
    }

    @Test
    void testCreateFloatWithValidFloatString() {
        Float result = NumberUtils.createFloat("3.14");
        Assertions.assertEquals(3.14f, result);
    }

    @Test
    void testCreateFloatWithInvalidFloatString() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createFloat("abc");
        });
    }
}