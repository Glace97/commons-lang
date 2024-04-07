import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getMiddleTest {

    @Test
    void testGetMiddleReturnsMiddleValue() {
        // Arrange
        Integer left = 1;
        String middle = "middle";
        Double right = 3.14;
        ImmutableTriple<Integer, String, Double> triple = new ImmutableTriple<>(left, middle, right);

        // Act
        String result = triple.getMiddle();

        // Assert
        Assertions.assertEquals(middle, result);
    }

    @Test
    void testGetMiddleReturnsNullForNullMiddle() {
        // Arrange
        Integer left = 1;
        String middle = null;
        Double right = 3.14;
        ImmutableTriple<Integer, String, Double> triple = new ImmutableTriple<>(left, middle, right);

        // Act
        String result = triple.getMiddle();

        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    void testGetMiddleReturnsNullForNullTriple() {
        // Arrange
        ImmutableTriple<Integer, String, Double> triple = null;

        // Act
        String result = triple.getMiddle();

        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    void testGetMiddleReturnsNullForNullLeftAndRight() {
        // Arrange
        Integer left = null;
        String middle = "middle";
        Double right = null;
        ImmutableTriple<Integer, String, Double> triple = new ImmutableTriple<>(left, middle, right);

        // Act
        String result = triple.getMiddle();

        // Assert
        Assertions.assertNull(result);
    }
}