import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.Serializable;

public class CloneTest {

    @Test
    public void testCloneNullObject() {
        Serializable clonedObject = SerializationUtils.clone(null);
        Assertions.assertNull(clonedObject);
    }

    @Test
    public void testCloneSerializableObject() {
        Serializable originalObject = new SerializableObject();
        Serializable clonedObject = SerializationUtils.clone(originalObject);
        Assertions.assertEquals(originalObject, clonedObject);
    }

    @Test
    public void testCloneNonSerializableObject() {
        NonSerializableObject originalObject = new NonSerializableObject();
        Assertions.assertThrows(SerializationException.class, () -> {
            SerializationUtils.clone(originalObject);
        });
    }

    @Test
    public void testCloneObjectWithPrimitiveFields() {
        ObjectWithPrimitiveFields originalObject = new ObjectWithPrimitiveFields(10, 3.14, 'a', true);
        ObjectWithPrimitiveFields clonedObject = SerializationUtils.clone(originalObject);
        Assertions.assertEquals(originalObject, clonedObject);
    }

    @Test
    public void testCloneObjectWithReferenceFields() {
        ObjectWithReferenceFields originalObject = new ObjectWithReferenceFields(new SerializableObject(), "test");
        ObjectWithReferenceFields clonedObject = SerializationUtils.clone(originalObject);
        Assertions.assertEquals(originalObject, clonedObject);
    }

    @Test
    public void testCloneObjectWithCircularReference() {
        CircularReferenceObject originalObject = new CircularReferenceObject();
        originalObject.setSelf(originalObject);
        CircularReferenceObject clonedObject = SerializationUtils.clone(originalObject);
        Assertions.assertEquals(originalObject, clonedObject);
    }

    private static class SerializableObject implements Serializable {
        // Serializable object for testing
    }

    private static class NonSerializableObject {
        // Non-serializable object for testing
    }

    private static class ObjectWithPrimitiveFields implements Serializable {
        private int intValue;
        private double doubleValue;
        private char charValue;
        private boolean booleanValue;

        public ObjectWithPrimitiveFields(int intValue, double doubleValue, char charValue, boolean booleanValue) {
            this.intValue = intValue;
            this.doubleValue = doubleValue;
            this.charValue = charValue;
            this.booleanValue = booleanValue;
        }

        // Getters and Setters
    }

    private static class ObjectWithReferenceFields implements Serializable {
        private SerializableObject serializableObject;
        private String stringValue;

        public ObjectWithReferenceFields(SerializableObject serializableObject, String stringValue) {
            this.serializableObject = serializableObject;
            this.stringValue = stringValue;
        }

        // Getters and Setters
    }

    private static class CircularReferenceObject implements Serializable {
        private CircularReferenceObject self;

        public void setSelf(CircularReferenceObject self) {
            this.self = self;
        }

        // Getter and Setter
    }
}