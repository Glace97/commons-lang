import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class subSequenceTest {

    @Test
    void testSubSequence() {
        // Test when CharSequence is null, should return null
        assertNull(CharSequenceUtils.subSequence(null, 0));

        // Test when start index is negative, should throw IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> CharSequenceUtils.subSequence("Hello", -1));

        // Test when start index is greater than length(), should throw IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> CharSequenceUtils.subSequence("Hello", 10));

        // Test when start index is equal to length(), should return an empty sequence
        assertEquals("", CharSequenceUtils.subSequence("Hello", 5).toString());

        // Test when start index is 0, should return the original CharSequence
        assertEquals("Hello", CharSequenceUtils.subSequence("Hello", 0).toString());

        // Test when start index is within valid range, should return the subsequence
        assertEquals("llo", CharSequenceUtils.subSequence("Hello", 2).toString());

        // Test when CharSequence is empty, should return an empty sequence
        assertEquals("", CharSequenceUtils.subSequence("", 0).toString());
    }
}