
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class IdentityToStringTest {

    @Test
    @DisplayName("Test identityToString with non-null object")
    void testIdentityToStringWithNonNullObject() throws IOException {
        StringBuilder builder = new StringBuilder();
        ObjectUtils.identityToString(builder, "Test");

        assertEquals("java.lang.String@" + Integer.toHexString("Test".hashCode()), builder.toString());
    }

    @Test
    @DisplayName("Test identityToString with null object")
    void testIdentityToStringWithNullObject() throws IOException {
        StringBuilder builder = new StringBuilder();
        ObjectUtils.identityToString(builder, null);

        assertEquals("null", builder.toString());
    }

    @Test
    @DisplayName("Test identityToString with non-null object using Appendable")
    void testIdentityToStringWithNonNullObjectUsingAppendable() throws IOException {
        StringJoiner joiner = new StringJoiner("");
        ObjectUtils.identityToString(joiner, "Test");

        assertEquals("java.lang.String@" + Integer.toHexString("Test".hashCode()), joiner.toString());
    }

    @Test
    @DisplayName("Test identityToString with null object using Appendable")
    void testIdentityToStringWithNullObjectUsingAppendable() throws IOException {
        StringJoiner joiner = new StringJoiner("");
        ObjectUtils.identityToString(joiner, null);

        assertEquals("null", joiner.toString());
    }

    @Test
    @DisplayName("Test identityToString with non-null object using StrBuilder")
    void testIdentityToStringWithNonNullObjectUsingStrBuilder() {
        StrBuilder builder = new StrBuilder();
        ObjectUtils.identityToString(builder, "Test");

        assertEquals("java.lang.String@" + Integer.toHexString("Test".hashCode()), builder.toString());
    }

    @Test
    @DisplayName("Test identityToString with null object using StrBuilder")
    void testIdentityToStringWithNullObjectUsingStrBuilder() {
        StrBuilder builder = new StrBuilder();
        ObjectUtils.identityToString(builder, null);

        assertEquals("null", builder.toString());
    }

    @Test
    @DisplayName("Test identityToString with non-null object using StringBuffer")
    void testIdentityToStringWithNonNullObjectUsingStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        ObjectUtils.identityToString(buffer, "Test");

        assertEquals("java.lang.String@" + Integer.toHexString("Test".hashCode()), buffer.toString());
    }

    @Test
    @DisplayName("Test identityToString with null object using StringBuffer")
    void testIdentityToStringWithNullObjectUsingStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        ObjectUtils.identityToString(buffer, null);

        assertEquals("null", buffer.toString());
    }

    @Test
    @DisplayName("Test identityToString with non-null object using StringBuilder")
    void testIdentityToStringWithNonNullObjectUsingStringBuilder() {
        StringBuilder builder = new StringBuilder();
        ObjectUtils.identityToString(builder, "Test");

        assertEquals("java.lang.String@" + Integer.toHexString("Test".hashCode()), builder.toString());
    }

    @Test
    @DisplayName("Test identityToString with null object using StringBuilder")
    void testIdentityToStringWithNullObjectUsingStringBuilder() {
        StringBuilder builder = new StringBuilder();
        ObjectUtils.identityToString(builder, null);

        assertEquals("null", builder.toString());
    }
}
