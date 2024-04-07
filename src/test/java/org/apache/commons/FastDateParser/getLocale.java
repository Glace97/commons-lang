import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Locale;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class getLocaleTest {

    @Test
    public void testGetLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        Locale result = parser.getLocale();
        assertEquals(Locale.getDefault(), result);
    }

    @Test
    public void testGetLocaleWithJapaneseImperialLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), FastDateParser.JAPANESE_IMPERIAL);
        Locale result = parser.getLocale();
        assertEquals(FastDateParser.JAPANESE_IMPERIAL, result);
    }

    @Test
    public void testGetLocaleWithDifferentLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), locale);
        Locale result = parser.getLocale();
        assertEquals(locale, result);
    }
}