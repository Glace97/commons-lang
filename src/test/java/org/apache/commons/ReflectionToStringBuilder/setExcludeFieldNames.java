import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class setExcludeFieldNamesTest {
  
  private ReflectionToStringBuilder builder;
  
  @BeforeEach
  void setUp() {
    builder = new ReflectionToStringBuilder(new Object());
  }
  
  @Test
  void testSetExcludeFieldNames_nullArray() {
    builder.setExcludeFieldNames(null);
    assertNull(builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_emptyArray() {
    builder.setExcludeFieldNames();
    assertArrayEquals(new String[0], builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_singleValue() {
    String[] excludeFieldNames = {"password"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(excludeFieldNames, builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_multipleValues() {
    String[] excludeFieldNames = {"password", "creditCard"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(excludeFieldNames, builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_duplicateValues() {
    String[] excludeFieldNames = {"password", "password"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(new String[] {"password"}, builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_sortedValues() {
    String[] excludeFieldNames = {"creditCard", "password"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(new String[] {"creditCard", "password"}, builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_mixedValues() {
    String[] excludeFieldNames = {"password", null, "creditCard"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(new String[] {"creditCard", "password"}, builder.excludeFieldNames);
  }
  
  @Test
  void testSetExcludeFieldNames_caseInsensitiveValues() {
    String[] excludeFieldNames = {"Password", "password"};
    builder.setExcludeFieldNames(excludeFieldNames);
    assertArrayEquals(new String[] {"password"}, builder.excludeFieldNames);
  }
}