import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

class DeserializeTest {
    private byte[] serializedData;

    @BeforeEach
    public void setup() throws IOException {
        // Serialize an object to obtain serialized data
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(new Object()); // Replace with your object to be serialized
        objectOutputStream.close();
        serializedData = byteArrayOutputStream.toByteArray();
    }

    @Test
    public void testDeserializeWithValidData() {
        Object deserializedObject = SerializationUtils.deserialize(serializedData);
        Assertions.assertNotNull(deserializedObject);
        // Add assertions to validate the deserialized object
    }

    @Test
    public void testDeserializeWithNullData() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            SerializationUtils.deserialize(null);
        });
    }

    @Test
    public void testDeserializeWithInvalidData() {
        byte[] invalidData = new byte[] { 1, 2, 3, 4 };
        Assertions.assertThrows(SerializationException.class, () -> {
            SerializationUtils.deserialize(invalidData);
        });
    }
}

Note: Replace "new Object()" with the actual object you want to serialize and deserialize. Also, add additional test cases as needed to cover all edge cases and achieve high coverage.