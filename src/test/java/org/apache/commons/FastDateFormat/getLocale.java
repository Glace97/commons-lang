import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Locale;

class getLocaleTest {

    private FastDateFormat fastDateFormat;

    @BeforeEach
    void setUp() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.US);
    }

    @Test
    void testGetLocale() {
        Locale expectedLocale = Locale.US;
        Locale actualLocale = fastDateFormat.getLocale();
        assertEquals(expectedLocale, actualLocale);
    }
}