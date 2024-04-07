import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getExcludeFieldNamesTest {

    private ReflectionDiffBuilder.Builder<Object> builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionDiffBuilder.Builder<>();
    }

    @Test
    void testGetExcludeFieldNames_EmptyArray() {
        ReflectionDiffBuilder<Object> diffBuilder = builder.build();
        String[] excludeFieldNames = diffBuilder.getExcludeFieldNames();
        
        assertNotNull(excludeFieldNames);
        assertEquals(0, excludeFieldNames.length);
    }
    
    @Test
    void testGetExcludeFieldNames_SingleField() {
        String fieldName = "password";
        builder.setExcludeFieldNames(fieldName);
        
        ReflectionDiffBuilder<Object> diffBuilder = builder.build();
        String[] excludeFieldNames = diffBuilder.getExcludeFieldNames();
        
        assertNotNull(excludeFieldNames);
        assertEquals(1, excludeFieldNames.length);
        assertEquals(fieldName, excludeFieldNames[0]);
    }
    
    @Test
    void testGetExcludeFieldNames_MultipleFields() {
        String[] fieldNames = {"password", "lastModificationDate"};
        builder.setExcludeFieldNames(fieldNames);
        
        ReflectionDiffBuilder<Object> diffBuilder = builder.build();
        String[] excludeFieldNames = diffBuilder.getExcludeFieldNames();
        
        assertNotNull(excludeFieldNames);
        assertEquals(fieldNames.length, excludeFieldNames.length);
        assertArrayEquals(fieldNames, excludeFieldNames);
    }
}