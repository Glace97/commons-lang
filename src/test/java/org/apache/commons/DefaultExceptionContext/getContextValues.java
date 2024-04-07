import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getContextValuesTest {
  
  private DefaultExceptionContext context;
  
  @BeforeEach
  void setUp() {
    context = new DefaultExceptionContext();
  }
  
  @Nested
  @DisplayName("Testing getContextValues method")
  class TestGetContextValues {
    
    @Test
    @DisplayName("Test when label is null")
    void testGetContextValuesWithNullLabel() {
      List<Object> values = context.getContextValues(null);
      assertTrue(values.isEmpty(), "Values list should be empty");
    }
    
    @Test
    @DisplayName("Test when label is empty")
    void testGetContextValuesWithEmptyLabel() {
      List<Object> values = context.getContextValues("");
      assertTrue(values.isEmpty(), "Values list should be empty");
    }
    
    @Test
    @DisplayName("Test when label matches with multiple values")
    void testGetContextValuesWithMatchingValues() {
      context.contextValues.add(new ImmutablePair<>("label", 1));
      context.contextValues.add(new ImmutablePair<>("label", "value"));
      context.contextValues.add(new ImmutablePair<>("otherLabel", true));
      
      List<Object> values = context.getContextValues("label");
      
      assertEquals(2, values.size(), "Values list should contain 2 elements");
      assertTrue(values.contains(1), "Values list should contain 1");
      assertTrue(values.contains("value"), "Values list should contain 'value'");
    }
    
    @Test
    @DisplayName("Test when label does not match with any value")
    void testGetContextValuesWithNoMatchingValues() {
      context.contextValues.add(new ImmutablePair<>("label1", 1));
      context.contextValues.add(new ImmutablePair<>("label2", "value"));
      context.contextValues.add(new ImmutablePair<>("label3", true));
      
      List<Object> values = context.getContextValues("label");
      
      assertTrue(values.isEmpty(), "Values list should be empty");
    }
    
    @Test
    @DisplayName("Test when context values are empty")
    void testGetContextValuesWithEmptyContextValues() {
      List<Object> values = context.getContextValues("label");
      
      assertTrue(values.isEmpty(), "Values list should be empty");
    }
    
  }
  
}