import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashMap;
import java.util.Map;

class ResolveClassTest {
    private ClassLoaderAwareObjectInputStream objectInputStream;

    @BeforeEach
    void setUp() {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            objectInputStream = new ClassLoaderAwareObjectInputStream(inputStream, classLoader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testResolveClassWithExistingClass() {
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(Serializable.class);
        try {
            Class<?> resolvedClass = objectInputStream.resolveClass(objectStreamClass);
            assertEquals(Serializable.class, resolvedClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testResolveClassWithNonExistingClass() {
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(NonExistingClass.class);
        assertThrows(ClassNotFoundException.class, () -> objectInputStream.resolveClass(objectStreamClass));
    }

    @Test
    void testResolveClassWithPrimitiveType() {
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(int.class);
        try {
            Class<?> resolvedClass = objectInputStream.resolveClass(objectStreamClass);
            assertEquals(int.class, resolvedClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testResolveClassWithNullClassLoader() {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        try {
            objectInputStream = new ClassLoaderAwareObjectInputStream(inputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(Serializable.class);
        try {
            Class<?> resolvedClass = objectInputStream.resolveClass(objectStreamClass);
            assertEquals(Serializable.class, resolvedClass);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}