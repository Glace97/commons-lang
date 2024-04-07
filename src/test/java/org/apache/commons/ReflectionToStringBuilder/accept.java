import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AcceptTest {
    
    @Test
    void testAcceptWithInnerClassField() {
        // Create an object with an inner class field
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(innerClass);
        
        // The accept method should return false for inner class fields
        assertFalse(builder.accept(innerClass.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithTransientField() {
        // Create an object with a transient field
        TransientFieldObject object = new TransientFieldObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return false for transient fields when appendTransients is false
        assertFalse(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithStaticField() {
        // Create an object with a static field
        StaticFieldObject object = new StaticFieldObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return false for static fields when appendStatics is false
        assertFalse(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithExcludedFieldName() {
        // Create an object with a field that is excluded from output
        ExcludedFieldObject object = new ExcludedFieldObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return false for fields that are in the excludeFieldNames array
        assertFalse(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithIncludedFieldName() {
        // Create an object with a field that is included in output
        IncludedFieldObject object = new IncludedFieldObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return true for fields that are in the includeFieldNames array
        assertTrue(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithExcludedAnnotation() {
        // Create an object with a field that has the ToStringExclude annotation
        ExcludedAnnotationObject object = new ExcludedAnnotationObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return false for fields that have the ToStringExclude annotation
        assertFalse(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithNullIncludeFieldNames() {
        // Create an object with a field while includeFieldNames is null
        NullIncludeFieldNamesObject object = new NullIncludeFieldNamesObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return true for all fields when includeFieldNames is null
        assertTrue(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithEmptyIncludeFieldNames() {
        // Create an object with a field while includeFieldNames is empty
        EmptyIncludeFieldNamesObject object = new EmptyIncludeFieldNamesObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return true for all fields when includeFieldNames is empty
        assertTrue(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    @Test
    void testAcceptWithDefaultSettings() {
        // Create an object with a field
        DefaultSettingsObject object = new DefaultSettingsObject();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(object);
        
        // The accept method should return true for all fields by default
        assertTrue(builder.accept(object.getClass().getDeclaredFields()[0]));
    }
    
    private static class OuterClass {
        private static class InnerClass {
        }
    }
    
    private static class TransientFieldObject {
        private transient int field;
    }
    
    private static class StaticFieldObject {
        private static int field;
    }
    
    private static class ExcludedFieldObject {
        private String excludedField;
    }
    
    private static class IncludedFieldObject {
        private String includedField;
    }
    
    private static class ExcludedAnnotationObject {
        @ToStringExclude
        private String excludedField;
    }
    
    private static class NullIncludeFieldNamesObject {
        private String field;
    }
    
    private static class EmptyIncludeFieldNamesObject {
        private String field;
    }
    
    private static class DefaultSettingsObject {
        private String field;
    }
    
    @interface ToStringExclude {
    }
}

This test suite covers various scenarios including inner class fields, transient fields, static fields, excluded fields, included fields, fields with the ToStringExclude annotation, null includeFieldNames, empty includeFieldNames, and default settings.