import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class defaultIfNullTest {

    @Test
    void testDefaultIfNull_withNullObjectAndNullDefaultValue_returnsNull() {
        assertNull(ObjectUtils.defaultIfNull(null, null));
    }
    
    @Test
    void testDefaultIfNull_withNullObjectAndNonNullDefaultValue_returnsNonNullDefaultValue() {
        String defaultValue = "default";
        assertEquals(defaultValue, ObjectUtils.defaultIfNull(null, defaultValue));
    }
    
    @Test
    void testDefaultIfNull_withNonNullObjectAndNullDefaultValue_returnsNonNullObject() {
        String object = "object";
        assertEquals(object, ObjectUtils.defaultIfNull(object, null));
    }
    
    @Test
    void testDefaultIfNull_withNonNullObjectAndNonNullDefaultValue_returnsNonNullObject() {
        String object = "object";
        String defaultValue = "default";
        assertEquals(object, ObjectUtils.defaultIfNull(object, defaultValue));
    }
    
    @Test
    void testDefaultIfNull_withNullObjectAndNullDefaultValue_returnsNullForDifferentReferenceTypes() {
        Integer defaultValue = new Integer(0);
        assertNull(ObjectUtils.defaultIfNull(null, defaultValue));
        
        Object defaultValueObject = defaultValue;
        assertNull(ObjectUtils.defaultIfNull(null, defaultValueObject));
    }
    
    @Test
    void testDefaultIfNull_withNullObjectAndNonNullDefaultValue_returnsNonNullDefaultValueForDifferentReferenceTypes() {
        Integer defaultValue = new Integer(0);
        String expected = defaultValue.toString();
        assertEquals(expected, ObjectUtils.defaultIfNull(null, defaultValue));
        
        Object defaultValueObject = defaultValue;
        assertEquals(defaultValueObject, ObjectUtils.defaultIfNull(null, defaultValueObject));
    }
    
    @Test
    void testDefaultIfNull_withNonNullObjectAndNullDefaultValue_returnsNonNullObjectForDifferentReferenceTypes() {
        Integer object = new Integer(0);
        assertEquals(object, ObjectUtils.defaultIfNull(object, null));
        
        Object objectAsObject = object;
        assertEquals(objectAsObject, ObjectUtils.defaultIfNull(object, null));
    }
    
    @Test
    void testDefaultIfNull_withNonNullObjectAndNonNullDefaultValue_returnsNonNullObjectForDifferentReferenceTypes() {
        Integer object = new Integer(0);
        Integer defaultValue = new Integer(1);
        assertEquals(object, ObjectUtils.defaultIfNull(object, defaultValue));
        
        Object objectAsObject = object;
        Object defaultValueAsObject = defaultValue;
        assertEquals(objectAsObject, ObjectUtils.defaultIfNull(object, defaultValueAsObject));
    }
}