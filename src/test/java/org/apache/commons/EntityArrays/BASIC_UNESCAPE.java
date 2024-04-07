import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class BASIC_UNESCAPETest {
    
    private EntityArrays entityArrays;

    @BeforeAll
    public void setUp() {
        entityArrays = new EntityArrays();
    }

    @Test
    public void testBasicUnescape() {
        String[][] basicUnescape = entityArrays.BASIC_UNESCAPE();

        for (String[] escape : basicUnescape) {
            String escapedChar = escape[1];
            String unescapedChar = escape[0];

            String unescaped = StringEscapeUtils.unescapeHtml4(escapedChar);
            assertEquals(unescapedChar, unescaped);
        }
    }
}