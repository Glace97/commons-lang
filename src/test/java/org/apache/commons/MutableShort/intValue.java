import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class intValueTest {

  @Test
  void testIntValue() {
    MutableShort mutableShort = new MutableShort((short) 10);
    assertEquals(10, mutableShort.intValue());
  }

  @ParameterizedTest
  @ValueSource(strings = { "0", "-1", "1", "32767", "-32768" })
  void testIntValueFromString(String value) {
    MutableShort mutableShort = new MutableShort(value);
    assertEquals(Short.parseShort(value), mutableShort.intValue());
  }
}