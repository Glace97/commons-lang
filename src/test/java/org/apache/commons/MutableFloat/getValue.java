import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class getValueTest {
    
    @Test
    public void testGetValueNotNull() {
        MutableFloat mutableFloat = new MutableFloat();
        Assertions.assertNotNull(mutableFloat.getValue());
    }
    
    @Test
    public void testGetValueWithDefaultValue() {
        MutableFloat mutableFloat = new MutableFloat();
        Assertions.assertEquals(0.0f, mutableFloat.getValue());
    }
    
    @Test
    public void testGetValueWithInitialValue() {
        float expectedValue = 1.23f;
        MutableFloat mutableFloat = new MutableFloat(expectedValue);
        Assertions.assertEquals(expectedValue, mutableFloat.getValue());
    }
    
    @ParameterizedTest
    @ValueSource(floats = {0.0f, -1.0f, 1.0f, Float.MAX_VALUE, Float.MIN_VALUE})
    public void testGetValueWithNumber(float value) {
        MutableFloat mutableFloat = new MutableFloat(value);
        Assertions.assertEquals(value, mutableFloat.getValue());
    }
    
    @Test
    public void testGetValueWithString() {
        String value = "1.23";
        MutableFloat mutableFloat = new MutableFloat(value);
        Assertions.assertEquals(Float.parseFloat(value), mutableFloat.getValue());
    }
    
    @Test
    public void testGetValueWithInvalidString() {
        String value = "abc";
        Assertions.assertThrows(NumberFormatException.class, () -> new MutableFloat(value));
    }
}