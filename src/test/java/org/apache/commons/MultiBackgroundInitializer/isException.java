import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class isExceptionTest {
  
  private MultiBackgroundInitializer multiBackgroundInitializer;
  
  @BeforeEach
  void setUp() {
    multiBackgroundInitializer = new MultiBackgroundInitializer();
  }
  
  @Test
  void testIsException_withValidName_shouldReturnTrue() {
    // Arrange
    String name = "initializer1";
    multiBackgroundInitializer.childInitializers.put(name, new BackgroundInitializer<>());

    // Act
    boolean isException = multiBackgroundInitializer.isException(name);

    // Assert
    assertFalse(isException);
  }
  
  @Test
  void testIsException_withInvalidName_shouldThrowNoSuchElementException() {
    // Arrange
    String invalidName = "invalidInitializer";

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> {
      multiBackgroundInitializer.isException(invalidName);
    });
  }
  
  @Test
  void testIsException_withNameAndException_shouldReturnTrue() {
    // Arrange
    String name = "initializer2";
    multiBackgroundInitializer.childInitializers.put(name, new BackgroundInitializer<>());
    multiBackgroundInitializer.exceptions.put(name, new ConcurrentException());

    // Act
    boolean isException = multiBackgroundInitializer.isException(name);

    // Assert
    assertTrue(isException);
  }
  
  @Test
  void testIsException_withNameAndNoException_shouldReturnFalse() {
    // Arrange
    String name = "initializer3";
    multiBackgroundInitializer.childInitializers.put(name, new BackgroundInitializer<>());

    // Act
    boolean isException = multiBackgroundInitializer.isException(name);

    // Assert
    assertFalse(isException);
  }
  
  @Test
  void testIsException_withEmptyChildInitializers_shouldReturnFalse() {
    // Arrange
    String name = "initializer4";

    // Act
    boolean isException = multiBackgroundInitializer.isException(name);

    // Assert
    assertFalse(isException);
  }
}