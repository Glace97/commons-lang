import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.Serializable;

import org.junit.jupiter.api.Test;

class RoundtripTest {

    @Test
    void testRoundtrip() {
        // Test object
        TestObject obj = new TestObject("Test", 123);

        // Perform roundtrip serialization
        TestObject serialized = SerializationUtils.roundtrip(obj);

        // Check if the deserialized object is not null
        assertNotNull(serialized);

        // Check if the deserialized object is equal to the original object
        assertEquals(obj, serialized);
    }

    @Test
    void testRoundtripWithNull() {
        // Perform roundtrip serialization with null object
        Object serialized = SerializationUtils.roundtrip(null);

        // Check if the deserialized object is null
        assertNull(serialized);
    }

    @Test
    void testRoundtripWithEmptyObject() {
        // Test object
        TestObject obj = new TestObject("", 0);

        // Perform roundtrip serialization
        TestObject serialized = SerializationUtils.roundtrip(obj);

        // Check if the deserialized object is not null
        assertNotNull(serialized);

        // Check if the deserialized object is equal to the original object
        assertEquals(obj, serialized);
    }

    @Test
    void testRoundtripWithLargeObject() {
        // Test object with large data
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            data.append("a");
        }
        TestObject obj = new TestObject(data.toString(), 123);

        // Perform roundtrip serialization
        TestObject serialized = SerializationUtils.roundtrip(obj);

        // Check if the deserialized object is not null
        assertNotNull(serialized);

        // Check if the deserialized object is equal to the original object
        assertEquals(obj, serialized);
    }

    @Test
    void testRoundtripWithNonSerializableObject() {
        // Test object that does not implement Serializable
        NonSerializableObject obj = new NonSerializableObject();

        // Perform roundtrip serialization
        NonSerializableObject serialized = SerializationUtils.roundtrip(obj);

        // Check if the deserialized object is not null
        assertNotNull(serialized);

        // Check if the deserialized object is equal to the original object
        assertEquals(obj, serialized);
    }

    private static class TestObject implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private int value;

        public TestObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TestObject other = (TestObject) obj;
            return value == other.value && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, value);
        }
    }

    private static class NonSerializableObject {
        // Non-serializable object
    }
}