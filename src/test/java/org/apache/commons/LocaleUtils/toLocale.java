
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class toLocaleTest {

    @Test
    void toLocaleShouldReturnGivenLocaleWhenNonNull() {
        Locale givenLocale = Locale.US;
        Locale result = LocaleUtils.toLocale(givenLocale);
        assertEquals(givenLocale, result);
    }

    @Test
    void toLocaleShouldReturnDefaultLocaleWhenNull() {
        Locale defaultLocale = Locale.getDefault();
        Locale result = LocaleUtils.toLocale(null);
        assertEquals(defaultLocale, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "en", "en_GB", "en-GB", "en_001", "en_GB_xxx"})
    void toLocaleShouldConvertStringToLocale(String str) {
        Locale result = LocaleUtils.toLocale(str);
        assertNotNull(result);
    }

    @Test
    void toLocaleShouldThrowExceptionForInvalidLocaleFormat() {
        assertThrows(IllegalArgumentException.class, () -> LocaleUtils.toLocale("invalid_format"));
    }

}
