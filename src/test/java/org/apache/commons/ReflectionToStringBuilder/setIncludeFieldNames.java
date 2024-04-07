import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class setIncludeFieldNamesTest {
    
    private ReflectionToStringBuilder builder;
    
    @BeforeEach
    void setUp() {
        Object object = new Object();
        builder = new ReflectionToStringBuilder(object);
    }
    
    @Nested
    @DisplayName("When includeFieldNames is null")
    class WhenIncludeFieldNamesIsNull {
        
        @Test
        @DisplayName("Should set includeFieldNames to null")
        void shouldSetIncludeFieldNamesToNull() {
            builder.setIncludeFieldNames(null);
            
            assertNull(builder.includeFieldNames);
        }
    }
    
    @Nested
    @DisplayName("When includeFieldNames is empty")
    class WhenIncludeFieldNamesIsEmpty {
        
        @Test
        @DisplayName("Should set includeFieldNames to an empty array")
        void shouldSetIncludeFieldNamesToEmptyArray() {
            builder.setIncludeFieldNames();
            
            assertArrayEquals(new String[0], builder.includeFieldNames);
        }
    }
    
    @Nested
    @DisplayName("When includeFieldNames is not null or empty")
    class WhenIncludeFieldNamesIsNotEmpty {
        
        @Test
        @DisplayName("Should set includeFieldNames to the sorted and non-null array")
        void shouldSetIncludeFieldNamesToSortedArray() {
            String[] includeFieldNames = {"field1", "field2", "field3"};
            builder.setIncludeFieldNames(includeFieldNames);
            
            assertArrayEquals(new String[] {"field1", "field2", "field3"}, builder.includeFieldNames);
        }
        
        @Test
        @DisplayName("Should remove null values from includeFieldNames")
        void shouldRemoveNullValuesFromIncludeFieldNames() {
            String[] includeFieldNames = {"field1", null, "field2", null, "field3"};
            builder.setIncludeFieldNames(includeFieldNames);
            
            assertArrayEquals(new String[] {"field1", "field2", "field3"}, builder.includeFieldNames);
        }
    }
}