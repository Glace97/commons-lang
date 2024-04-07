import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("equalsTest")
class equalsTest {

    @Nested
    @DisplayName("When comparing two objects")
    class EqualsTests {

        @Test
        @DisplayName("Should return true when both objects are null")
        void shouldReturnTrueWhenBothObjectsAreNull() {
            Object object1 = null;
            Object object2 = null;

            assertTrue(ObjectUtils.equals(object1, object2));
        }

        @Test
        @DisplayName("Should return false when one object is null and the other is not")
        void shouldReturnFalseWhenOneObjectIsNullAndTheOtherIsNot() {
            Object object1 = null;
            Object object2 = new Object();

            assertFalse(ObjectUtils.equals(object1, object2));
            assertFalse(ObjectUtils.equals(object2, object1));
        }

        @Test
        @DisplayName("Should return true when both objects are empty strings")
        void shouldReturnTrueWhenBothObjectsAreEmptyStrings() {
            String object1 = "";
            String object2 = "";

            assertTrue(ObjectUtils.equals(object1, object2));
        }

        @Test
        @DisplayName("Should return false when one object is an empty string and the other is null")
        void shouldReturnFalseWhenOneObjectIsEmptyStringAndTheOtherIsNull() {
            String object1 = "";
            String object2 = null;

            assertFalse(ObjectUtils.equals(object1, object2));
            assertFalse(ObjectUtils.equals(object2, object1));
        }

        @Test
        @DisplayName("Should return true when both objects are boolean true")
        void shouldReturnTrueWhenBothObjectsAreBooleanTrue() {
            Boolean object1 = true;
            Boolean object2 = true;

            assertTrue(ObjectUtils.equals(object1, object2));
        }

        @Test
        @DisplayName("Should return false when one object is boolean true and the other is null")
        void shouldReturnFalseWhenOneObjectIsBooleanTrueAndTheOtherIsNull() {
            Boolean object1 = true;
            Boolean object2 = null;

            assertFalse(ObjectUtils.equals(object1, object2));
            assertFalse(ObjectUtils.equals(object2, object1));
        }

        @Test
        @DisplayName("Should return false when the objects are different types")
        void shouldReturnFalseWhenTheObjectsAreDifferentTypes() {
            String object1 = "abc";
            Integer object2 = 123;

            assertFalse(ObjectUtils.equals(object1, object2));
            assertFalse(ObjectUtils.equals(object2, object1));
        }

        @Test
        @DisplayName("Should return true when both objects are equal")
        void shouldReturnTrueWhenBothObjectsAreEqual() {
            String object1 = "abc";
            String object2 = "abc";

            assertTrue(ObjectUtils.equals(object1, object2));
        }

        @Test
        @DisplayName("Should return false when both objects are not equal")
        void shouldReturnFalseWhenBothObjectsAreNotEqual() {
            String object1 = "abc";
            String object2 = "def";

            assertFalse(ObjectUtils.equals(object1, object2));
        }

    }
}