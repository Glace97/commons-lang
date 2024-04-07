import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class removeTest {

  @Test
  void testRemoveBooleanArray() {
    boolean[] array = {true};
    boolean[] expected = {};
    boolean[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveBooleanObjectArray() {
    Boolean[] array = {true};
    Boolean[] expected = {};
    Boolean[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveByteArray() {
    byte[] array = {1};
    byte[] expected = {};
    byte[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveByteObjectArray() {
    Byte[] array = {1};
    Byte[] expected = {};
    Byte[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveCharArray() {
    char[] array = {'a'};
    char[] expected = {};
    char[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveCharacterObjectArray() {
    Character[] array = {'a'};
    Character[] expected = {};
    Character[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveClassArray() {
    Class<?>[] array = {String.class};
    Class<?>[] expected = {};
    Class<?>[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveDoubleArray() {
    double[] array = {1.1};
    double[] expected = {};
    double[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveDoubleObjectArray() {
    Double[] array = {1.1};
    Double[] expected = {};
    Double[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveFieldArray() {
    Field[] array = {SomeClass.field};
    Field[] expected = {};
    Field[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveFloatArray() {
    float[] array = {2.5f};
    float[] expected = {};
    float[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveFloatObjectArray() {
    Float[] array = {2.5f};
    Float[] expected = {};
    Float[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveIntArray() {
    int[] array = {1};
    int[] expected = {};
    int[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveIntegerObjectArray() {
    Integer[] array = {1};
    Integer[] expected = {};
    Integer[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveLongArray() {
    long[] array = {1L};
    long[] expected = {};
    long[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveLongObjectArray() {
    Long[] array = {1L};
    Long[] expected = {};
    Long[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveMethodArray() {
    Method[] array = {SomeClass.method};
    Method[] expected = {};
    Method[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveObjectArray() {
    Object[] array = {new Object()};
    Object[] expected = {};
    Object[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveShortArray() {
    short[] array = {1};
    short[] expected = {};
    short[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveShortObjectArray() {
    Short[] array = {1};
    Short[] expected = {};
    Short[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveStringArray() {
    String[] array = {"a"};
    String[] expected = {};
    String[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveThrowableArray() {
    Throwable[] array = {new Exception()};
    Throwable[] expected = {};
    Throwable[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveTypeArray() {
    Type[] array = {SomeClass.type};
    Type[] expected = {};
    Type[] result = ArrayUtils.remove(array, 0);
    assertTrue(Arrays.equals(expected, result));
  }

  @Test
  void testRemoveIndexNotFound() {
    int[] array = {1};
    assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove(array, 1));
  }

  @Test
  void testRemoveNullArray() {
    int[] array = null;
    assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.remove(array, 0));
  }
}