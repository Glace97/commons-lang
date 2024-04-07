import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getClassTest {

    @Test
    void testGetClassWithNullObject() {
        // Arrange
        Object obj = null;

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(null, result);
    }

    @Test
    void testGetClassWithNonNullObject() {
        // Arrange
        Object obj = new Object();

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(Object.class, result);
    }

    @Test
    void testGetClassWithArrayObject() {
        // Arrange
        Object obj = new int[5];

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(int[].class, result);
    }

    @Test
    void testGetClassWithPrimitiveArrayObject() {
        // Arrange
        Object obj = new int[5];

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(int[].class, result);
    }

    @Test
    void testGetClassWithNestedArrayObject() {
        // Arrange
        Object obj = new int[][]{ {1, 2}, {3, 4} };

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(int[][].class, result);
    }

    @Test
    void testGetClassWithCollectionObject() {
        // Arrange
        Object obj = new ArrayList<>();

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(ArrayList.class, result);
    }

    @Test
    void testGetClassWithMapObject() {
        // Arrange
        Object obj = new HashMap<>();

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(HashMap.class, result);
    }

    @Test
    void testGetClassWithCustomObject() {
        // Arrange
        Object obj = new CustomObject();

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(CustomObject.class, result);
    }

    @Test
    void testGetClassWithGenericObject() {
        // Arrange
        Object obj = new GenericObject<String>();

        // Act
        Class<?> result = ObjectUtils.getClass(obj);

        // Assert
        assertEquals(GenericObject.class, result);
    }
    
    // Add more test cases for edge cases and specific scenarios

    private class CustomObject {
        // Custom object for testing
    }

    private class GenericObject<T> {
        // Generic object for testing
    }
}