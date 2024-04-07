import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.tuple.Pair;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isEqualsTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void testIsEquals_DefaultValue() {
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_AfterSettingToFalse() {
        equalsBuilder.isEquals = false;
        assertFalse(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithTransients() {
        equalsBuilder.testTransients = true;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithoutTransients() {
        equalsBuilder.testTransients = false;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithRecursive() {
        equalsBuilder.testRecursive = true;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithoutRecursive() {
        equalsBuilder.testRecursive = false;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithBypassReflectionClasses() {
        List<Class<?>> bypassReflectionClasses = new ArrayList<>();
        bypassReflectionClasses.add(String.class);
        equalsBuilder.bypassReflectionClasses = bypassReflectionClasses;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithoutBypassReflectionClasses() {
        equalsBuilder.bypassReflectionClasses = new ArrayList<>();
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithReflectUpToClass() {
        equalsBuilder.reflectUpToClass = Object.class;
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithoutReflectUpToClass() {
        assertNull(equalsBuilder.reflectUpToClass);
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithExcludeFields() {
        equalsBuilder.excludeFields = new String[]{"field1", "field2"};
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void testIsEquals_WithoutExcludeFields() {
        assertNull(equalsBuilder.excludeFields);
        assertTrue(equalsBuilder.isEquals());
    }
}