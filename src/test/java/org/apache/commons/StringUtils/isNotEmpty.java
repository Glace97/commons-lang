import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isNotEmptyTest {
  
  private StringUtils stringUtils;
  
  @BeforeAll
  public void setUp() {
    stringUtils = new StringUtils();
  }

  @Test
  public void testIsNotEmpty_Null_ReturnsFalse() {
    assertFalse(stringUtils.isNotEmpty(null));
  }
  
  @Test
  public void testIsNotEmpty_EmptyString_ReturnsFalse() {
    assertFalse(stringUtils.isNotEmpty(""));
  }
  
  @Test
  public void testIsNotEmpty_SpaceString_ReturnsTrue() {
    assertTrue(stringUtils.isNotEmpty(" "));
  }
  
  @Test
  public void testIsNotEmpty_NonEmptyString_ReturnsTrue() {
    assertTrue(stringUtils.isNotEmpty("bob"));
  }
  
  @Test
  public void testIsNotEmpty_StringWithLeadingAndTrailingSpaces_ReturnsTrue() {
    assertTrue(stringUtils.isNotEmpty("  bob  "));
  }

}