import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReflectionToStringBuilderTest {
  
  private ReflectionToStringBuilder builder;
  
  @BeforeEach
  void setUp() {
    Object object = new Object();
    builder = new ReflectionToStringBuilder(object);
  }
  
  @Test
  void reflectionAppendArray_shouldAppendArrayToString() {
    Object[] array = new Object[] {1, 2, 3};
    builder.reflectionAppendArray(array);
    String expected = "[1, 2, 3]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleEmptyArray() {
    Object[] array = new Object[0];
    builder.reflectionAppendArray(array);
    String expected = "[]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleNullArray() {
    Object[] array = null;
    builder.reflectionAppendArray(array);
    String expected = "null";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleNestedArrays() {
    Object[] array = new Object[] {1, new Object[] {2, 3}, 4};
    builder.reflectionAppendArray(array);
    String expected = "[1, [2, 3], 4]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandlePrimitiveArray() {
    int[] array = new int[] {1, 2, 3};
    builder.reflectionAppendArray(array);
    String expected = "[1, 2, 3]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleMultiDimensionalArray() {
    int[][] array = new int[][] {{1, 2}, {3, 4}};
    builder.reflectionAppendArray(array);
    String expected = "[[1, 2], [3, 4]]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfNulls() {
    Object[] array = new Object[3];
    builder.reflectionAppendArray(array);
    String expected = "[null, null, null]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfEmptyArrays() {
    Object[] array = new Object[] {new Object[0], new Object[0]};
    builder.reflectionAppendArray(array);
    String expected = "[[], []]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfArraysOfDifferentLengths() {
    Object[] array = new Object[] {new Object[2], new Object[3]};
    builder.reflectionAppendArray(array);
    String expected = "[[], [null, null, null]]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfPrimitives() {
    int[] array = new int[] {1, 2, 3};
    builder.reflectionAppendArray(array);
    String expected = "[1, 2, 3]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfPrimitiveArrays() {
    int[][] array = new int[][] {{1, 2}, {3, 4}};
    builder.reflectionAppendArray(array);
    String expected = "[[1, 2], [3, 4]]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfMixedElements() {
    Object[] array = new Object[] {1, "two", true};
    builder.reflectionAppendArray(array);
    String expected = "[1, two, true]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfMixedArrays() {
    Object[] array = new Object[] {new Object[] {1, 2}, new Object[] {3, 4}};
    builder.reflectionAppendArray(array);
    String expected = "[[1, 2], [3, 4]]";
    assertEquals(expected, builder.toString());
  }
  
  @Test
  void reflectionAppendArray_shouldHandleArrayOfMixedPrimitiveAndObjectArrays() {
    Object[] array = new Object[] {new int[] {1, 2}, new Object[] {3, 4}};
    builder.reflectionAppendArray(array);
    String expected = "[[1, 2], [3, 4]]";
    assertEquals(expected, builder.toString());
  }
  
}