import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class requireNonEmptyTest {

    @Test
    void testRequireNonEmpty_NullObject_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null));
    }

    @Test
    void testRequireNonEmpty_NullObjectWithMessage_ThrowsNullPointerExceptionWithMessage() {
        Assertions.assertThrows(NullPointerException.class, () -> ObjectUtils.requireNonEmpty(null, "Object cannot be null"));
    }

    @Test
    void testRequireNonEmpty_EmptyString_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(""));
    }

    @Test
    void testRequireNonEmpty_EmptyStringWithMessage_ThrowsIllegalArgumentExceptionWithMessage() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty("", "String cannot be empty"));
    }

    @Test
    void testRequireNonEmpty_NonEmptyString_ReturnsSameString() {
        String input = "Hello";
        String result = ObjectUtils.requireNonEmpty(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    void testRequireNonEmpty_NonEmptyStringWithMessage_ReturnsSameString() {
        String input = "Hello";
        String result = ObjectUtils.requireNonEmpty(input, "String cannot be empty");
        Assertions.assertEquals(input, result);
    }

    @Test
    void testRequireNonEmpty_EmptyCollection_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(Collections.emptyList()));
    }

    @Test
    void testRequireNonEmpty_EmptyCollectionWithMessage_ThrowsIllegalArgumentExceptionWithMessage() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ObjectUtils.requireNonEmpty(Collections.emptyList(), "Collection cannot be empty"));
    }

    @Test
    void testRequireNonEmpty_NonEmptyCollection_ReturnsSameCollection() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        Collection<Integer> result = ObjectUtils.requireNonEmpty(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    void testRequireNonEmpty_NonEmptyCollectionWithMessage_ReturnsSameCollection() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        Collection<Integer> result = ObjectUtils.requireNonEmpty(input, "Collection cannot be empty");
        Assertions.assertEquals(input, result);
    }

    // Add more tests for other types and edge cases as needed

}