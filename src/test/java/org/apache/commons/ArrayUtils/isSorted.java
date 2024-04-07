import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isSortedTest {
    
    @Nested
    @DisplayName("isSorted for boolean array")
    class IsSortedBooleanArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            boolean[] array = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            boolean[] array = {true, true, true};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            boolean[] array = {true, false, true};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for byte array")
    class IsSortedByteArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            byte[] array = ArrayUtils.EMPTY_BYTE_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            byte[] array = {1, 2, 3};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            byte[] array = {3, 2, 1};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for char array")
    class IsSortedCharArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            char[] array = ArrayUtils.EMPTY_CHAR_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            char[] array = {'a', 'b', 'c'};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            char[] array = {'c', 'b', 'a'};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for double array")
    class IsSortedDoubleArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            double[] array = ArrayUtils.EMPTY_DOUBLE_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            double[] array = {1.0, 2.0, 3.0};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            double[] array = {3.0, 2.0, 1.0};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for float array")
    class IsSortedFloatArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            float[] array = ArrayUtils.EMPTY_FLOAT_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            float[] array = {1.0f, 2.0f, 3.0f};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            float[] array = {3.0f, 2.0f, 1.0f};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for int array")
    class IsSortedIntArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            int[] array = ArrayUtils.EMPTY_INT_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            int[] array = {1, 2, 3};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            int[] array = {3, 2, 1};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for long array")
    class IsSortedLongArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            long[] array = ArrayUtils.EMPTY_LONG_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            long[] array = {1L, 2L, 3L};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            long[] array = {3L, 2L, 1L};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for short array")
    class IsSortedShortArray {
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            short[] array = ArrayUtils.EMPTY_SHORT_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            short[] array = {1, 2, 3};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            short[] array = {3, 2, 1};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for generic array")
    class IsSortedGenericArray {
        
        private class Person implements Comparable<Person> {
            private String name;
            
            public Person(String name) {
                this.name = name;
            }
            
            public String getName() {
                return name;
            }
            
            public int compareTo(Person other) {
                return name.compareTo(other.getName());
            }
        }
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            Person[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            Person[] array = {new Person("Alice"), new Person("Bob"), new Person("Charlie")};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            Person[] array = {new Person("Charlie"), new Person("Alice"), new Person("Bob")};
            
            boolean result = ArrayUtils.isSorted(array);
            
            assertFalse(result);
        }
    }
    
    @Nested
    @DisplayName("isSorted for generic array with custom comparator")
    class IsSortedGenericArrayWithComparator {
        
        private class Person {
            private String name;
            private int age;
            
            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
            
            public String getName() {
                return name;
            }
            
            public int getAge() {
                return age;
            }
        }
        
        @Test
        void shouldReturnTrueForEmptyArray() {
            Person[] array = ArrayUtils.EMPTY_OBJECT_ARRAY;
            Comparator<Person> comparator = Comparator.comparing(Person::getAge);
            
            boolean result = ArrayUtils.isSorted(array, comparator);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnTrueForSortedArray() {
            Person[] array = {new Person("Alice", 20), new Person("Bob", 25), new Person("Charlie", 30)};
            Comparator<Person> comparator = Comparator.comparing(Person::getAge);
            
            boolean result = ArrayUtils.isSorted(array, comparator);
            
            assertTrue(result);
        }
        
        @Test
        void shouldReturnFalseForUnsortedArray() {
            Person[] array = {new Person("Charlie", 30), new Person("Alice", 20), new Person("Bob", 25)};
            Comparator<Person> comparator = Comparator.comparing(Person::getAge);
            
            boolean result = ArrayUtils.isSorted(array, comparator);
            
            assertFalse(result);
        }
    }
}
