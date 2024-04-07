import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isInitializedTest {

  AtomicSafeInitializer<Object> initializer;

  @BeforeEach
  void setUp() {
    initializer = new AtomicSafeInitializer<>();
  }

  @Nested
  @DisplayName("when not initialized")
  class WhenNotInitialized {

    @Test
    @DisplayName("should return false")
    void shouldReturnFalse() {
      assertFalse(initializer.isInitialized());
    }
  }

  @Nested
  @DisplayName("when initialized")
  class WhenInitialized {

    @BeforeEach
    void initialize() {
      AtomicReference<Object> reference = new AtomicReference<>(new Object());
      initializer.reference = reference;
    }

    @Test
    @DisplayName("should return true")
    void shouldReturnTrue() {
      assertTrue(initializer.isInitialized());
    }
  }
}