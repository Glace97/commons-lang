import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class notNullTest {

    @Test
    @DisplayName("Test notNull with non-null object")
    void testNotNullWithNonNullObject() {
        Object object = new Object();
        Object result = Validate.notNull(object);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(object, result);
    }

    @Test
    @DisplayName("Test notNull with null object")
    void testNotNullWithNullObject() {
        Object object = null;
        Assertions.assertThrows(NullPointerException.class, () -> Validate.notNull(object));
    }

    @Test
    @DisplayName("Test notNull with custom message")
    void testNotNullWithCustomMessage() {
        Object object = null;
        String message = "The object must not be null";
        Assertions.assertThrows(NullPointerException.class, () -> Validate.notNull(object, message));
    }
}