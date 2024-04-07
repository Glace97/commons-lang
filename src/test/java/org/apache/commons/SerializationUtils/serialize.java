
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializeTest {

    private static class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
        private String data;

        public SerializableObject(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    @Test
    void serialize_NullObject_ReturnsEmptyByteArray() {
        byte[] result = SerializationUtils.serialize(null);
        assertEquals(0, result.length);
    }

    @Test
    void serialize_Object_ReturnsByteArray() {
        SerializableObject obj = new SerializableObject("test");
        byte[] result = SerializationUtils.serialize(obj);
        assertNotEquals(0, result.length);
    }

    @Test
    void serialize_Object_OutputStreamNotNull() throws IOException {
        SerializableObject obj = new SerializableObject("test");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SerializationUtils.serialize(obj, outputStream);
        assertNotNull(outputStream);
    }

    @Test
    void serialize_Object_OutputStreamContainsSerializedData() throws IOException {
        SerializableObject obj = new SerializableObject("test");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SerializationUtils.serialize(obj, outputStream);

        byte[] serializedData = outputStream.toByteArray();
        assertNotNull(serializedData);

        try (ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
            Object deserializedObj = oos.readObject();
            assertTrue(deserializedObj instanceof SerializableObject);
            assertEquals(obj.getData(), ((SerializableObject) deserializedObj).getData());
        } catch (ClassNotFoundException e) {
            fail("Class not found exception occurred");
        }
    }
}
