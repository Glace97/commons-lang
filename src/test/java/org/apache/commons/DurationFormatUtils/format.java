import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

class FormatTest {

    @Test
    void testFormat() {
        Token[] tokens = new Token[] {
            new Token(new StringBuilder("P"), false, -1),
            new Token("y", false, -1),
            new Token(new StringBuilder("M"), false, -1),
            new Token("d", false, -1),
            new Token(new StringBuilder("T"), false, -1),
            new Token("H", false, -1),
            new Token(new StringBuilder("m"), false, -1),
            new Token("s", false, -1),
            new Token(new StringBuilder("."), false, -1),
            new Token("S", false, -1)
        };

        long years = 1;
        long months = 2;
        long days = 3;
        long hours = 4;
        long minutes = 5;
        long seconds = 6;
        long milliseconds = 7;
        boolean padWithZeros = true;

        String expected = "P1Y2M3DT4H5M6.007S";

        String result = DurationFormatUtils.format(tokens, years, months, days, hours, minutes, seconds, milliseconds, padWithZeros);

        Assertions.assertEquals(expected, result);
    }
}