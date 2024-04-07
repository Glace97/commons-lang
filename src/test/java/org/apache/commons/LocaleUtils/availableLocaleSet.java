
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

class availableLocaleSetTest {

    @Test
    void testAvailableLocaleSet() {
        Set<Locale> expectedLocaleSet = new HashSet<>(LocaleUtils.AVAILABLE_LOCALE_SET);
        Set<Locale> actualLocaleSet = LocaleUtils.availableLocaleSet();
        assertEquals(expectedLocaleSet, actualLocaleSet);
    }

    @Test
    void testAvailableLocaleSetUnmodifiable() {
        Set<Locale> localeSet = LocaleUtils.availableLocaleSet();
        assertThrows(UnsupportedOperationException.class, () -> localeSet.add(Locale.US));
    }

}
