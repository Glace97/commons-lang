import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getArrayEndTest {

    @Test
    void testGetArrayEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        String arrayEnd = style.getArrayEnd();

        // Test if the array end text is not null
        assertNotNull(arrayEnd);

        // Test if the array end text is an empty string
        assertEquals("", arrayEnd);

        // Test if the array end text is equal to the default array end text of the super class
        assertEquals(Array.get(Array.class, "end"), arrayEnd);
        
        // Test if the array end text has the correct format
        assertTrue(arrayEnd.startsWith("["));
        assertTrue(arrayEnd.endsWith("]"));
    }
}