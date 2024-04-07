import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class appendTest {
    private DiffBuilder<String> diffBuilder;

    @BeforeEach
    void setUp() {
        diffBuilder = new DiffBuilder<>();
    }

    @Test
    void append_boolean_equals() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", true, true);
        Assertions.assertEquals(diffBuilder, result);
    }

    @Test
    void append_boolean_notEquals() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", true, false);
        Assertions.assertNotEquals(diffBuilder, result);
    }

    @Test
    void append_booleanArray_equals() {
        boolean[] lhs = new boolean[]{true, false};
        boolean[] rhs = new boolean[]{true, false};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, rhs);
        Assertions.assertEquals(diffBuilder, result);
    }

    @Test
    void append_booleanArray_notEquals() {
        boolean[] lhs = new boolean[]{true, false};
        boolean[] rhs = new boolean[]{false, true};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, rhs);
        Assertions.assertNotEquals(diffBuilder, result);
    }

    @Test
    void append_byte_equals() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", (byte) 1, (byte) 1);
        Assertions.assertEquals(diffBuilder, result);
    }

    @Test
    void append_byte_notEquals() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", (byte) 1, (byte) 2);
        Assertions.assertNotEquals(diffBuilder, result);
    }

    @Test
    void append_byteArray_equals() {
        byte[] lhs = new byte[]{1, 2};
        byte[] rhs = new byte[]{1, 2};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, rhs);
        Assertions.assertEquals(diffBuilder, result);
    }

    @Test
    void append_byteArray_notEquals() {
        byte[] lhs = new byte[]{1, 2};
        byte[] rhs = new byte[]{2, 1};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, rhs);
        Assertions.assertNotEquals(diffBuilder, result);
    }

    // Repeat the same for other types of data

}