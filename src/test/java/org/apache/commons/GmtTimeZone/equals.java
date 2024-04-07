import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class equalsTest {
  
  private static GmtTimeZone gmtTimeZone;
  
  @BeforeAll
  static void setup() {
    gmtTimeZone = new GmtTimeZone(false, 0, 0);
  }
  
  @Nested
  @DisplayName("Positive Test Cases")
  class PositiveTests {
    
    @Test
    @DisplayName("Equal objects")
    void testEqualObjects() {
      GmtTimeZone other = new GmtTimeZone(false, 0, 0);
      assertEquals(gmtTimeZone, other);
    }
    
    @Test
    @DisplayName("Equal objects with different zoneId")
    void testEqualObjectsWithDifferentZoneId() {
      GmtTimeZone other = new GmtTimeZone(false, 0, 0);
      other.zoneId = "GMT+01:00";
      assertEquals(gmtTimeZone, other);
    }
    
    @Test
    @DisplayName("Equal objects with different offset")
    void testEqualObjectsWithDifferentOffset() {
      GmtTimeZone other = new GmtTimeZone(false, 0, 0);
      other.offset = 3600000;
      assertEquals(gmtTimeZone, other);
    }
  }
  
  @Nested
  @DisplayName("Negative Test Cases")
  class NegativeTests {
    
    @Test
    @DisplayName("Different objects")
    void testDifferentObjects() {
      GmtTimeZone other = new GmtTimeZone(false, 1, 0);
      assertNotEquals(gmtTimeZone, other);
    }
    
    @Test
    @DisplayName("Null object")
    void testNullObject() {
      assertNotEquals(gmtTimeZone, null);
    }
    
    @Test
    @DisplayName("Different class object")
    void testDifferentClassObject() {
      Date date = new Date();
      assertNotEquals(gmtTimeZone, date);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 25})
    @DisplayName("Invalid hours")
    void testInvalidHours(int hours) {
      assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, hours, 0));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 60})
    @DisplayName("Invalid minutes")
    void testInvalidMinutes(int minutes) {
      assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 0, minutes));
    }
    
  }
  
}