
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isAnyEmptyTest {

    @Test
    void shouldReturnFalseForNullInput() {
        Assertions.assertFalse(StringUtils.isAnyEmpty((CharSequence[]) null));
    }

    @Test
    void shouldReturnFalseForEmptyInput() {
        Assertions.assertFalse(StringUtils.isAnyEmpty());
    }

    @Test
    void shouldReturnFalseForNonEmptyInput() {
        Assertions.assertFalse(StringUtils.isAnyEmpty("foo"));
    }

    @Test
    void shouldReturnTrueForEmptyStringInput() {
        Assertions.assertTrue(StringUtils.isAnyEmpty(""));
    }

    @Test
    void shouldReturnTrueForNullStringInput() {
        Assertions.assertTrue(StringUtils.isAnyEmpty((CharSequence) null));
    }

    @Test
    void shouldReturnTrueForMixedInputWithEmptyString() {
        Assertions.assertTrue(StringUtils.isAnyEmpty("foo", ""));
    }

    @Test
    void shouldReturnTrueForMixedInputWithNullString() {
        Assertions.assertTrue(StringUtils.isAnyEmpty("foo", (CharSequence) null));
    }

    @Test
    void shouldReturnTrueForMixedInputWithWhitespaceString() {
        Assertions.assertTrue(StringUtils.isAnyEmpty("foo", " "));
    }

    @Test
    void shouldReturnTrueForMixedInputWithEmptyStringArray() {
        Assertions.assertTrue(StringUtils.isAnyEmpty(new String[] { "" }));
    }

    @Test
    void shouldReturnFalseForMixedInputWithNonEmptyStringArray() {
        Assertions.assertFalse(StringUtils.isAnyEmpty(new String[] { "foo" }));
    }

    @Test
    void shouldReturnFalseForMixedInputWithNullStringArray() {
        Assertions.assertFalse(StringUtils.isAnyEmpty((CharSequence[]) null, "foo"));
    }

}
