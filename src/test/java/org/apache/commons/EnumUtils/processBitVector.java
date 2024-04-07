import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;

class ProcessBitVectorTest {

    @Test
    void testProcessBitVectorWithValidEnumClassAndValue() {
        // Given
        Class<MyEnum> enumClass = MyEnum.class;
        long value = 7L;

        // When
        EnumSet<MyEnum> result = EnumUtils.processBitVector(enumClass, value);

        // Then
        EnumSet<MyEnum> expected = EnumSet.of(MyEnum.VALUE1, MyEnum.VALUE2, MyEnum.VALUE3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testProcessBitVectorWithInvalidEnumClass() {
        // Given
        Class<String> enumClass = String.class;
        long value = 7L;

        // When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EnumUtils.processBitVector(enumClass, value);
        });

        // Then
        String expectedMessage = "EnumClass must be defined.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testProcessBitVectorWithInvalidValue() {
        // Given
        Class<MyEnum> enumClass = MyEnum.class;
        long value = 8L;

        // When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            EnumUtils.processBitVector(enumClass, value);
        });

        // Then
        String expectedMessage = "Cannot store 8 MyEnum values in 3 bits";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testProcessBitVectorWithNullEnumClass() {
        // Given
        Class<MyEnum> enumClass = null;
        long value = 7L;

        // When
        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            EnumUtils.processBitVector(enumClass, value);
        });

        // Then
        String expectedMessage = "EnumClass must be defined.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testProcessBitVectorWithNullValue() {
        // Given
        Class<MyEnum> enumClass = MyEnum.class;
        long value = 0L;

        // When
        EnumSet<MyEnum> result = EnumUtils.processBitVector(enumClass, value);

        // Then
        EnumSet<MyEnum> expected = EnumSet.noneOf(MyEnum.class);
        Assertions.assertEquals(expected, result);
    }

    enum MyEnum {
        VALUE1,
        VALUE2,
        VALUE3
    }
}