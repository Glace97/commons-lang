import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class HTML40_EXTENDED_ESCAPETest {
    
    private EntityArrays entityArrays;
    
    @BeforeAll
    public void setUp() {
        entityArrays = new EntityArrays();
    }
    
    @Test
    public void testHTML40_EXTENDED_ESCAPE() {
        String[][] escapeTable = entityArrays.HTML40_EXTENDED_ESCAPE();
        for (String[] pair : escapeTable) {
            assertEquals(pair[1], HTML40_EXTENDED_ESCAPE.escape(pair[0]));
        }
    }
    
    @Test
    public void testHTML40_EXTENDED_UNESCAPE() {
        String[][] unescapeTable = entityArrays.HTML40_EXTENDED_UNESCAPE();
        for (String[] pair : unescapeTable) {
            assertEquals(pair[1], HTML40_EXTENDED_ESCAPE.unescape(pair[0]));
        }
    }
}