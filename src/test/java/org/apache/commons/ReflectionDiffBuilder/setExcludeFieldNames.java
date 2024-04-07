import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class setExcludeFieldNamesTest {

    @Test
    void testSetExcludeFieldNames() {
        ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
        
        // Test when excludeFieldNames is empty
        builder.setExcludeFieldNames();
        ReflectionDiffBuilder<String> diffBuilder1 = builder.build();
        assertEquals(0, diffBuilder1.getExcludeFieldNames().length);
        
        // Test when excludeFieldNames has one element
        builder.setExcludeFieldNames("password");
        ReflectionDiffBuilder<String> diffBuilder2 = builder.build();
        assertEquals(1, diffBuilder2.getExcludeFieldNames().length);
        assertEquals("password", diffBuilder2.getExcludeFieldNames()[0]);
        
        // Test when excludeFieldNames has multiple elements
        builder.setExcludeFieldNames("password", "lastModificationDate");
        ReflectionDiffBuilder<String> diffBuilder3 = builder.build();
        assertEquals(2, diffBuilder3.getExcludeFieldNames().length);
        assertEquals("password", diffBuilder3.getExcludeFieldNames()[0]);
        assertEquals("lastModificationDate", diffBuilder3.getExcludeFieldNames()[1]);
        
        // Test when excludeFieldNames is null
        builder.setExcludeFieldNames((String[]) null);
        ReflectionDiffBuilder<String> diffBuilder4 = builder.build();
        assertEquals(0, diffBuilder4.getExcludeFieldNames().length);
    }
}