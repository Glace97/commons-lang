import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class toFullyQualifiedPathTest {
    
    @Test
    void testToFullyQualifiedPath_withClassContext() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "testResource.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/testResource.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withPackageContext() {
        Package context = toFullyQualifiedPathTest.class.getPackage();
        String resourceName = "testResource.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/testResource.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withNullClassContext() {
        String resourceName = "testResource.txt";
        
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(null, resourceName);
        });
    }
    
    @Test
    void testToFullyQualifiedPath_withNullPackageContext() {
        String resourceName = "testResource.txt";
        
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(null, resourceName);
        });
    }
    
    @Test
    void testToFullyQualifiedPath_withNullResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(context, null);
        });
    }
    
    @Test
    void testToFullyQualifiedPath_withEmptyResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "";
        String expected = "com/example/test/toFullyQualifiedPathTest/";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withLeadingSlashInResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "/testResource.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/testResource.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withLeadingSlashInResourceNameAndEmptyContext() {
        Package context = toFullyQualifiedPathTest.class.getPackage();
        String resourceName = "/testResource.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/testResource.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withDotInResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "test.Resource.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/test/Resource.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withMultipleDotsInResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "test.resource.file.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/test/resource/file.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToFullyQualifiedPath_withSpecialCharactersInResourceName() {
        Class<?> context = toFullyQualifiedPathTest.class;
        String resourceName = "test_resource%*.txt";
        String expected = "com/example/test/toFullyQualifiedPathTest/test_resource%*.txt";
        
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        
        assertEquals(expected, result);
    }
}