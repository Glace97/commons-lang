import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setRightTest {
  
  private DiffBuilder<String> diffBuilder;
  
  @BeforeEach
  void setUp() {
    diffBuilder = new DiffBuilder<>();
  }
  
  @Test
  void testSetRight() {
    String left = "left";
    String right = "right";
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertEquals(right, diffBuilder.getRight());
  }
  
  @Test
  void testSetRightNull() {
    String left = "left";
    String right = null;
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertNull(diffBuilder.getRight());
  }
  
  @Test
  void testSetRightEmptyString() {
    String left = "left";
    String right = "";
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertEquals(right, diffBuilder.getRight());
  }
  
  @Test
  void testSetRightWhitespace() {
    String left = "left";
    String right = " ";
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertEquals(right, diffBuilder.getRight());
  }
  
  @Test
  void testSetRightSameObject() {
    String left = "left";
    String right = left;
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertEquals(right, diffBuilder.getRight());
  }
  
  @Test
  void testSetRightDifferentObject() {
    String left = "left";
    String right = "different";
    
    diffBuilder.setLeft(left);
    diffBuilder.setRight(right);
    
    assertEquals(right, diffBuilder.getRight());
  }
}