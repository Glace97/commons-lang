import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class getInstanceTest {

   @Test
   void testGetInstance() {
      FastDateFormat instance = FastDateFormat.getInstance();
      assertNotNull(instance);
   }

   @Test
   void testGetInstanceWithPattern() {
      String pattern = "yyyy-MM-dd";
      FastDateFormat instance = FastDateFormat.getInstance(pattern);
      assertNotNull(instance);
   }

   @Test
   void testGetInstanceWithPatternAndLocale() {
      String pattern = "yyyy-MM-dd";
      Locale locale = Locale.US;
      FastDateFormat instance = FastDateFormat.getInstance(pattern, locale);
      assertNotNull(instance);
   }

   @Test
   void testGetInstanceWithPatternAndTimeZone() {
      String pattern = "yyyy-MM-dd";
      TimeZone timeZone = TimeZone.getTimeZone("GMT");
      FastDateFormat instance = FastDateFormat.getInstance(pattern, timeZone);
      assertNotNull(instance);
   }

   @Test
   void testGetInstanceWithPatternTimeZoneAndLocale() {
      String pattern = "yyyy-MM-dd";
      TimeZone timeZone = TimeZone.getTimeZone("GMT");
      Locale locale = Locale.US;
      FastDateFormat instance = FastDateFormat.getInstance(pattern, timeZone, locale);
      assertNotNull(instance);
   }
}