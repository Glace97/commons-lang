
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

class localeLookupListTest {

    @Test
    void testLocaleLookupListWithNonNullLocale() {
        Locale locale = new Locale("fr", "CA", "xxx");
        List<Locale> expectedList = List.of(
                new Locale("fr", "CA", "xxx"),
                new Locale("fr", "CA"),
                new Locale("fr")
        );
        List<Locale> resultList = LocaleUtils.localeLookupList(locale);
        assertEquals(expectedList, resultList);
    }

    @Test
    void testLocaleLookupListWithNonNullLocales() {
        Locale locale = new Locale("fr", "CA", "xxx");
        Locale defaultLocale = new Locale("en");
        List<Locale> expectedList = List.of(
                new Locale("fr", "CA", "xxx"),
                new Locale("fr", "CA"),
                new Locale("fr"),
                new Locale("en")
        );
        List<Locale> resultList = LocaleUtils.localeLookupList(locale, defaultLocale);
        assertEquals(expectedList, resultList);
    }

    @Test
    void testLocaleLookupListWithNullLocale() {
        List<Locale> resultList = LocaleUtils.localeLookupList(null);
        assertTrue(resultList.isEmpty());
    }

    @Test
    void testLocaleLookupListWithNullLocales() {
        List<Locale> resultList = LocaleUtils.localeLookupList(null, null);
        assertTrue(resultList.isEmpty());
    }

    @Test
    void testLocaleLookupListWithDefaultLocaleOnly() {
        Locale defaultLocale = new Locale("en");
        List<Locale> expectedList = List.of(defaultLocale);
        List<Locale> resultList = LocaleUtils.localeLookupList(null, defaultLocale);
        assertEquals(expectedList, resultList);
    }
}
