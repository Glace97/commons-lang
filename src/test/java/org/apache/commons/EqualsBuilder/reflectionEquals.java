import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class reflectionEqualsTest {

    private Object lhs;
    private Object rhs;

    @BeforeEach
    void setUp() {
        lhs = new Object();
        rhs = new Object();
    }

    @Test
    void testReflectionEquals_SameObject_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, lhs, true));
    }

    @Test
    void testReflectionEquals_NullObject_ReturnsFalse() {
        Assertions.assertFalse(EqualsBuilder.reflectionEquals(lhs, null, true));
        Assertions.assertFalse(EqualsBuilder.reflectionEquals(null, rhs, true));
    }

    @Test
    void testReflectionEquals_DifferentClasses_ReturnsFalse() {
        Assertions.assertFalse(EqualsBuilder.reflectionEquals(lhs, new ArrayList<>(), true));
        Assertions.assertFalse(EqualsBuilder.reflectionEquals(lhs, new HashSet<>(), true));
    }

    @Test
    void testReflectionEquals_TestTransientsTrue_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true));
    }

    @Test
    void testReflectionEquals_TestTransientsFalse_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, false));
    }

    @Test
    void testReflectionEquals_ReflectUpToClassNull_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true, null));
    }

    @Test
    void testReflectionEquals_ReflectUpToClass_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true, Object.class));
    }

    @Test
    void testReflectionEquals_TestRecursiveTrue_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true, null, true));
    }

    @Test
    void testReflectionEquals_TestRecursiveFalse_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true, null, false));
    }

    @Test
    void testReflectionEquals_ExcludeFields_ReturnsTrue() {
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, true, null, false, "field1", "field2"));
    }

    @Test
    void testReflectionEquals_CollectionExcludeFields_ReturnsTrue() {
        List<String> excludeFields = new ArrayList<>();
        excludeFields.add("field1");
        excludeFields.add("field2");
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(lhs, rhs, excludeFields));
    }
}