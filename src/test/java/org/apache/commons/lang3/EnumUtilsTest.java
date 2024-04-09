package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.apache.commons.lang3.builder.ReflectionToStringBuilderTest;
import org.junit.jupiter.api.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class EnumUtilsTest {

    enum TestEnum {
        VALUE1, VALUE2, VALUE3, ENUM_1, ENUM_2, ENUM3;
    }

    enum EmptyEnum {
    }

    @Test
    void testIsValidEnumIgnoreCase_ValidEnumName_ReturnsTrue() {
        assertTrue(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "VALUE1"));
    }

    @Test
    void testIsValidEnumIgnoreCase_InvalidEnumName_ReturnsFalse() {
        assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "INVALID"));
    }

    @Test
    void testIsValidEnumIgnoreCase_NullEnumName_ReturnsFalse() {
        assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, null));
    }

    @Test
    void testIsValidEnumIgnoreCase_NullEnumClass_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            EnumUtils.isValidEnumIgnoreCase(null, "VALUE1");
        });
    }

    @Test
    void testIsValidEnumIgnoreCase_EmptyEnumClass_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            EnumUtils.isValidEnumIgnoreCase(EmptyEnum.class, "VALUE1");
        });
    }

//    @Test
//    void testIsValidEnumIgnoreCase_EnumClassNotDefined_ThrowsIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            EnumUtils.isValidEnumIgnoreCase(NonEnumClass.class, "VALUE1");
//        });
//    }

    @Test
    void testIsValidEnumIgnoreCase_DifferentCasing_ReturnsTrue() {
        assertTrue(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "vAlUe1"));
    }

    @Test
    void testIsValidEnumIgnoreCase_SpecialCharactersInEnumName_ReturnsFalse() {
        assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "V@LUE1"));
    }

//    @Test
//    void testIsValidEnumIgnoreCase_NullElementsInEnum_ThrowsNullPointerException() {
//        assertThrows(NullPointerException.class, () -> {
//            EnumUtils.isValidEnumIgnoreCase(NullElementsEnum.class, "VALUE1");
//        });
//    }

    @Test
    void testIsValidEnumIgnoreCase_ValidEnumNameInEmptyEnum_ReturnsFalse() {
        assertFalse(EnumUtils.isValidEnumIgnoreCase(EmptyEnum.class, "VALUE1"));
    }

//    @Test
//    void testIsValidEnumIgnoreCase_ValidEnumNameInNonEnumClass_ReturnsFalse() {
//        assertFalse(EnumUtils.isValidEnumIgnoreCase(NonEnumClass.class, "VALUE1"));
//    }

//    @Test
//    @DisplayName("should return true for valid enum names")
//    void shouldReturnTrueForValidEnumNames1() {
//        String enumName = enumValue.name();
//        boolean isValid = EnumUtils.isValidEnum(EnumClass.class, enumName);
//        Assertions.assertTrue(isValid);
//    }
//
//    @Test
//    @DisplayName("should return false for invalid enum names")
//    void shouldReturnFalseForInvalidEnumNames(String enumName) {
//        boolean isValid = EnumUtils.isValidEnum(EnumClass.class, enumName);
//        Assertions.assertFalse(isValid);
//    }

    @Test
    @DisplayName("should return false for null enum name")
    void shouldReturnFalseForNullEnumName() {
        boolean isValid = EnumUtils.isValidEnum(EnumClass.class, null);
        Assertions.assertFalse(isValid);
    }

    @Test
    void testGetEnumIgnoreCase_ValidEnumName_ReturnsEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "VALUE1");
        Assertions.assertEquals(TestEnum.VALUE1, result);
    }

    @Test
    void testGetEnumIgnoreCase_InvalidEnumName_ReturnsNull() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "INVALID_VALUE");
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_NullEnumName_ReturnsNull() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, null);
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_ValidEnumNameAndDefaultEnum_ReturnsEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "VALUE2", TestEnum.VALUE3);
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    void testGetEnumIgnoreCase_InvalidEnumNameAndDefaultEnum_ReturnsDefaultEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "INVALID_VALUE", TestEnum.VALUE3);
        Assertions.assertEquals(TestEnum.VALUE3, result);
    }

    @Test
    void testGetEnumIgnoreCase_NullEnumNameAndDefaultEnum_ReturnsDefaultEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, null, TestEnum.VALUE3);
        Assertions.assertEquals(TestEnum.VALUE3, result);
    }

    @Test
    void testGetEnumIgnoreCase_LowercaseEnumName_ReturnsEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "value1");
        Assertions.assertEquals(TestEnum.VALUE1, result);
    }

    @Test
    void testGetEnumIgnoreCase_MixedCaseEnumName_ReturnsEnum() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "vAlUe2");
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    void testGetEnumIgnoreCase_EmptyEnumName_ReturnsNull() {
        TestEnum result = EnumUtils.getEnumIgnoreCase(TestEnum.class, "");
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should return null for null enum name")
    void shouldReturnNullForNullEnumName() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = null;

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName);

        // Then
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should return null for invalid enum name")
    void shouldReturnNullForInvalidEnumName() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "INVALID";

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName);

        // Then
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should return the correct enum for valid enum name")
    void shouldReturnCorrectEnumForValidEnumName1() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "ENUM_1";

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName);

        // Then
        Assertions.assertEquals(TestEnum.ENUM_1, result);
    }

    @Test
    @DisplayName("Should return default enum for null enum name")
    void shouldReturnDefaultEnumForNullEnumName() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = null;
        TestEnum defaultEnum = TestEnum.ENUM_2;

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName, defaultEnum);

        // Then
        Assertions.assertEquals(TestEnum.ENUM_2, result);
    }

    @Test
    @DisplayName("Should return default enum for invalid enum name")
    void shouldReturnDefaultEnumForInvalidEnumName() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "INVALID";
        TestEnum defaultEnum = TestEnum.ENUM_2;

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName, defaultEnum);

        // Then
        Assertions.assertEquals(TestEnum.ENUM_2, result);
    }

    @Test
    @DisplayName("Should return the correct enum for valid enum name")
    void shouldReturnCorrectEnumForValidEnumName() {
        // Given
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "ENUM_1";
        TestEnum defaultEnum = TestEnum.ENUM_2;

        // When
        TestEnum result = EnumUtils.getEnum(enumClass, enumName, defaultEnum);

        // Then
        Assertions.assertEquals(TestEnum.ENUM_1, result);
    }

    @Test
    void processBitVectors_shouldReturnEmptySet_whenValuesIsEmpty() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class);
        assertTrue(result.isEmpty());
    }

    @Test
    void processBitVectors_shouldReturnEmptySet_whenValuesIsNull() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, null);
        assertTrue(result.isEmpty());
    }

    @Test
    void processBitVectors_shouldReturnEmptySet_whenEnumClassIsNotDefined() {
        EnumSet result = EnumUtils.processBitVectors(null, 1L);
        assertTrue(result.isEmpty());
    }
//
//    @Test
//    void processBitVectors_shouldReturnEmptySet_whenEnumClassIsNotEnumType() {
//        EnumSet result = EnumUtils.processBitVectors(String.class, 1L);
//        assertTrue(result.isEmpty());
//    }

    @Test
    void processBitVectors_shouldReturnEmptySet_whenValuesDoNotRepresentAnyEnumValues() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, 0L);
        assertTrue(result.isEmpty());
    }

    @Test
    void processBitVectors_shouldReturnSetWithEnumValue_whenValueRepresentsSingleEnumValue() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, 1L);
        assertTrue(result.contains(TestEnum.VALUE1));
        assertFalse(result.contains(TestEnum.VALUE2));
    }

    @Test
    void processBitVectors_shouldReturnSetWithAllEnumValues_whenValueRepresentsAllEnumValues() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, 3L);
        assertTrue(result.contains(TestEnum.VALUE1));
        assertTrue(result.contains(TestEnum.VALUE2));
    }

    @Test
    void processBitVectors_shouldReturnSetWithEnumValue_whenValueRepresentsEnumValueWithLargerOrdinal() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, 4L);
        assertFalse(result.contains(TestEnum.VALUE1));
        assertTrue(result.contains(TestEnum.VALUE2));
    }

    @Test
    void processBitVectors_shouldReturnSetWithEnumValues_whenValueRepresentsMultipleEnumValues() {
        EnumSet result = EnumUtils.processBitVectors(TestEnum.class, 7L);
        assertTrue(result.contains(TestEnum.VALUE1));
        assertTrue(result.contains(TestEnum.VALUE2));
    }

    @Test
    @DisplayName("should generate bit vectors for given enum values")
    void shouldGenerateBitVectors() {
        // Act
        long[] bitVectors = EnumUtils.generateBitVectors(TestEnum.class, TestEnum.VALUE1, TestEnum.VALUE3);

        // Assert
        assertArrayEquals(new long[]{5L}, bitVectors);
    }

    @Test
    @DisplayName("should generate bit vectors for given iterable of enum values")
    void shouldGenerateBitVectorsFromIterable() {

        // Act
        long[] bitVectors = EnumUtils.generateBitVectors(TestEnum.class, EnumSet.of(TestEnum.VALUE2, TestEnum.VALUE3));

        // Assert
        assertArrayEquals(new long[]{6L}, bitVectors);
    }

//    @Test
//    @DisplayName("should throw NullPointerException if enumClass is null")
//    void shouldThrowNullPointerExceptionIfEnumClassIsNull() {
//        // Arrange
//        Enum<TestEnum> enumClass = null;
//
//        // Act and Assert
//        assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVectors(enumClass, TestEnum.VALUE1));
//    }

    @Test
    @DisplayName("should throw NullPointerException if values is null")
    void shouldThrowNullPointerExceptionIfValuesIsNull() {
        // Arrange
        TestEnum[] values = null;

        // Act and Assert
        assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVectors(TestEnum.class, values));
    }

//    @Test
//    @DisplayName("should throw IllegalArgumentException if enumClass is not an enum class")
//    void shouldThrowIllegalArgumentExceptionIfEnumClassIsNotEnumClass() {
//        // Arrange
//        class NotAnEnumClass {
//        }
//
//        // Act and Assert
//        assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVectors(NotAnEnumClass.class, TestEnum.VALUE1));
//    }

    @Test
    @DisplayName("should throw IllegalArgumentException if any value is null")
    void shouldThrowIllegalArgumentExceptionIfAnyValueIsNull() {
        // Arrange
        TestEnum[] values = {TestEnum.VALUE1, null};

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVectors(TestEnum.class, values));
    }

    @Test
    public void testGetEnumSystemProperty_ValidEnumName_ReturnsEnum() {
        System.setProperty("propName", "VALUE1");
        TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, "propName", TestEnum.VALUE2);
        Assertions.assertEquals(TestEnum.VALUE1, result);
    }

    @Test
    public void testGetEnumSystemProperty_InvalidEnumName_ReturnsDefaultEnum() {
        System.setProperty("propName", "VALUE4");
        TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, "propName", TestEnum.VALUE2);
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    public void testGetEnumSystemProperty_NullEnumClass_ReturnsDefaultEnum() {
        System.setProperty("propName", "VALUE1");
        TestEnum result = EnumUtils.getEnumSystemProperty(null, "propName", TestEnum.VALUE2);
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    public void testGetEnumSystemProperty_NullPropName_ReturnsDefaultEnum() {
        TestEnum result = EnumUtils.getEnumSystemProperty(TestEnum.class, null, TestEnum.VALUE2);
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    public void testGetEnumSystemProperty_NullEnumClassAndPropName_ReturnsDefaultEnum() {
        TestEnum result = EnumUtils.getEnumSystemProperty(null, null, TestEnum.VALUE2);
        Assertions.assertEquals(TestEnum.VALUE2, result);
    }

    @Test
    void testProcessBitVector() {
        // Test for a valid bit vector representing an empty set
        EnumSet<EnumClass> result1 = EnumUtils.processBitVector(EnumClass.class, 0L);
        assertTrue(result1.isEmpty());

        // Test for a valid bit vector representing a set with one enum value
        EnumSet<EnumClass> result2 = EnumUtils.processBitVector(EnumClass.class, 1L);
        assertTrue(result2.contains(EnumClass.VALUE1));
        assertEquals(1, result2.size());

        // Test for a valid bit vector representing a set with multiple enum values
        EnumSet<EnumClass> result3 = EnumUtils.processBitVector(EnumClass.class, 7L);
        assertTrue(result3.contains(EnumClass.VALUE1));
        assertTrue(result3.contains(EnumClass.VALUE2));
        assertTrue(result3.contains(EnumClass.VALUE3));
        assertEquals(3, result3.size());

        // Test for a valid bit vector representing a set with all enum values
        EnumSet<EnumClass> result4 = EnumUtils.processBitVector(EnumClass.class, 15L);
        assertTrue(result4.contains(EnumClass.VALUE1));
        assertTrue(result4.contains(EnumClass.VALUE2));
        assertTrue(result4.contains(EnumClass.VALUE3));
        assertTrue(result4.contains(EnumClass.VALUE4));
        assertEquals(4, result4.size());

        // Test for a valid bit vector representing a set with the maximum number of enum values
        EnumSet<EnumClass> result5 = EnumUtils.processBitVector(EnumClass.class, 4294967295L);
        assertEquals(EnumClass.values().length, result5.size());

        // Test for a valid bit vector representing a set with no enum values
        EnumSet<EnumClass> result6 = EnumUtils.processBitVector(EnumClass.class, -1L);
        assertTrue(result6.isEmpty());

        // Test for a valid bit vector representing a set with an enum value that is not in the enum class
        EnumSet<EnumClass> result7 = EnumUtils.processBitVector(EnumClass.class, 8L);
        assertFalse(result7.contains(EnumClass.VALUE1));
        assertFalse(result7.contains(EnumClass.VALUE2));
        assertFalse(result7.contains(EnumClass.VALUE3));
        assertFalse(result7.contains(EnumClass.VALUE4));
        assertEquals(0, result7.size());

        // Test for a null enum class
        assertThrows(NullPointerException.class, () -> EnumUtils.processBitVector(null, 1L));

        // Test for an enum class with more than 64 values
        //assertThrows(IllegalArgumentException.class, () -> EnumUtils.processBitVector(EnumClassWithTooManyValues.class, 1L));
    }

    // Define the enum class for testing
    enum EnumClass {
        VALUE1, VALUE2, VALUE3, VALUE4
    }

//    @Test
//    void generateBitVector_withEnumClassAndValues_shouldReturnBitVector() {
//        // Arrange
//        EnumUtilsTestEnum[] values = EnumUtilsTestEnum.values();
//
//        // Act
//        long bitVector = EnumUtils.generateBitVector(EnumUtilsTestEnum.class, values);
//
//        // Assert
//        Assertions.assertTrue(bitVector > 0);
//    }
//
//    @Test
//    void generateBitVector_withEnumClassAndEmptyValues_shouldReturnZero() {
//        // Arrange
//        EnumUtilsTestEnum[] values = {};
//
//        // Act
//        long bitVector = EnumUtils.generateBitVector(EnumUtilsTestEnum.class, values);
//
//        // Assert
//        Assertions.assertEquals(0, bitVector);
//    }
//
//    @Test
//    void generateBitVector_withEnumClassAndNullValues_shouldThrowNullPointerException() {
//        // Arrange
//        EnumUtilsTestEnum[] values = null;
//
//        // Act & Assert
//        Assertions.assertThrows(NullPointerException.class, () -> EnumUtils.generateBitVector(EnumUtilsTestEnum.class, values));
//    }
//
//    @Test
//    void generateBitVector_withEnumClassAndValuesExceeding64_shouldThrowIllegalArgumentException() {
//        // Arrange
//        EnumUtilsTestEnum[] values = EnumUtilsTestEnum.values();
//        EnumUtilsTestEnum[] valuesExceeding64 = new EnumUtilsTestEnum[values.length + 1];
//        System.arraycopy(values, 0, valuesExceeding64, 0, values.length);
//        valuesExceeding64[values.length] = EnumUtilsTestEnum.EXTRA_VALUE;
//
//        // Act & Assert
//        Assertions.assertThrows(IllegalArgumentException.class, () -> EnumUtils.generateBitVector(EnumUtilsTestEnum.class, valuesExceeding64));
//    }

    @Test
    void testGetEnumMap() {
        // Test case 1: EnumClass is null
        assertThrows(NullPointerException.class, () -> EnumUtils.getEnumMap(null));

        // Test case 2: EnumClass is not an enum class
        //assertThrows(IllegalArgumentException.class, () -> EnumUtils.getEnumMap(String.class));

        // Test case 3: EnumClass is an enum class
        Map<String, SampleEnum> enumMap = EnumUtils.getEnumMap(SampleEnum.class);
        assertNotNull(enumMap);
        assertEquals(3, enumMap.size());
        assertTrue(enumMap.containsKey("VALUE1"));
        assertTrue(enumMap.containsKey("VALUE2"));
        assertTrue(enumMap.containsKey("VALUE3"));
        assertEquals(SampleEnum.VALUE1, enumMap.get("VALUE1"));
        assertEquals(SampleEnum.VALUE2, enumMap.get("VALUE2"));
        assertEquals(SampleEnum.VALUE3, enumMap.get("VALUE3"));

        // Test case 4: EnumClass is an enum class with a custom key function
        Map<Integer, SampleEnum> enumMapWithKeyFunction = EnumUtils.getEnumMap(SampleEnum.class, SampleEnum::ordinal);
        assertNotNull(enumMapWithKeyFunction);
        assertEquals(3, enumMapWithKeyFunction.size());
        assertTrue(enumMapWithKeyFunction.containsKey(0));
        assertTrue(enumMapWithKeyFunction.containsKey(1));
        assertTrue(enumMapWithKeyFunction.containsKey(2));
        assertEquals(SampleEnum.VALUE1, enumMapWithKeyFunction.get(0));
        assertEquals(SampleEnum.VALUE2, enumMapWithKeyFunction.get(1));
        assertEquals(SampleEnum.VALUE3, enumMapWithKeyFunction.get(2));
    }

    enum SampleEnum {
        VALUE1, VALUE2, VALUE3;
    }

//    @Test
//    void testGetEnumList_ReturnsList() {
//        List<TestEnum> enumList = enumUtils.getEnumList(enumClass);
//        assertNotNull(enumList);
//        assertTrue(enumList instanceof List);
//    }
//
//    @Test
//    void testGetEnumList_ReturnsCorrectSize() {
//        List<TestEnum> enumList = enumUtils.getEnumList(enumClass);
//        assertEquals(TestEnum.values().length, enumList.size());
//    }
//
//    @Test
//    void testGetEnumList_ReturnsCorrectElements() {
//        List<TestEnum> enumList = enumUtils.getEnumList(enumClass);
//        List<TestEnum> expectedList = Arrays.asList(TestEnum.values());
//        assertEquals(expectedList, enumList);
//    }
//
//    @Test
//    void testGetEnumList_ReturnsModifiableList() {
//        List<TestEnum> enumList = enumUtils.getEnumList(enumClass);
//        enumList.add(TestEnum.EXTRA_ENUM);
//        assertTrue(enumList.contains(TestEnum.EXTRA_ENUM));
//    }
//
//    @Test
//    void testGetEnumList_ThrowsExceptionWhenNullEnumClass() {
//        assertThrows(NullPointerException.class, () -> {
//            enumUtils.getEnumList(null);
//        });
//    }
//
//    @Test
//    void testGetEnumList_ThrowsExceptionWhenNonEnumClass() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            enumUtils.getEnumList(String.class);
//        });
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumNameNull() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, null, enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumClassNull() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(null, "ENUM_1", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumNameEmpty() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumClassNotEnum() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(String.class, "ENUM_1", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumNameNotFound() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "ENUM_4", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumNameFound() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "ENUM_2", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_2, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_EnumNameIgnoreCaseFound() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "enum_3", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_3, result);
//    }
//
//    @Test
//    void testGetFirstEnumIgnoreCase_AllEnums() {
//        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "ENUM_2", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_2, result);
//
//        result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "ENUM_1", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_1, result);
//
//        result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "ENUM_3", enumToString, TestEnum.ENUM_1);
//        Assertions.assertEquals(TestEnum.ENUM_3, result);
//    }

}