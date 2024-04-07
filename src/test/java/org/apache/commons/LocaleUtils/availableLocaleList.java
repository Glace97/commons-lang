import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("availableLocaleListTest")
class availableLocaleListTest {

    private static List<Locale> availableLocales;

    @BeforeAll
    static void setup() {
        availableLocales = LocaleUtils.availableLocaleList();
    }

    @Nested
    @DisplayName("availableLocaleList")
    class AvailableLocaleListTests {

        @Test
        @DisplayName("returns a non-null list")
        void returnsNonNullList() {
            assertNotNull(availableLocales);
        }

        @Test
        @DisplayName("returns an unmodifiable list")
        void returnsUnmodifiableList() {
            assertThrows(UnsupportedOperationException.class, () -> availableLocales.add(Locale.US));
        }

        @Test
        @DisplayName("returns the correct number of locales")
        void returnsCorrectNumberOfLocales() {
            assertEquals(Locale.getAvailableLocales().length, availableLocales.size());
        }
    }

    @Nested
    @DisplayName("availableLocaleList with Predicate")
    class AvailableLocaleListWithPredicateTests {

        @Test
        @DisplayName("returns a non-null list")
        void returnsNonNullListWithPredicate() {
            Predicate<Locale> predicate = locale -> locale.getLanguage().equals("en");
            List<Locale> filteredLocales = LocaleUtils.availableLocaleList(predicate);
            assertNotNull(filteredLocales);
        }

        @Test
        @DisplayName("returns an unmodifiable list")
        void returnsUnmodifiableListWithPredicate() {
            Predicate<Locale> predicate = locale -> locale.getLanguage().equals("en");
            List<Locale> filteredLocales = LocaleUtils.availableLocaleList(predicate);
            assertThrows(UnsupportedOperationException.class, () -> filteredLocales.add(Locale.US));
        }

        @Test
        @DisplayName("returns the correct number of locales")
        void returnsCorrectNumberOfLocalesWithPredicate() {
            Predicate<Locale> predicate = locale -> locale.getLanguage().equals("en");
            List<Locale> filteredLocales = LocaleUtils.availableLocaleList(predicate);
            long expectedCount = Arrays.stream(Locale.getAvailableLocales())
                    .filter(predicate)
                    .count();
            assertEquals(expectedCount, filteredLocales.size());
        }

        @Test
        @DisplayName("returns only locales that satisfy the predicate")
        void returnsLocalesSatisfyingPredicate() {
            Predicate<Locale> predicate = locale -> locale.getLanguage().equals("en");
            List<Locale> filteredLocales = LocaleUtils.availableLocaleList(predicate);
            assertTrue(filteredLocales.stream().allMatch(predicate));
        }
    }
}