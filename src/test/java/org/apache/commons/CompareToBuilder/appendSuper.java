import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class appendSuperTest {
    
    @Test
    void testAppendSuper() {
        CompareToBuilder builder = new CompareToBuilder();
        int superCompareTo = 5;
        
        CompareToBuilder result = builder.appendSuper(superCompareTo);
        
        assertEquals(superCompareTo, result.comparison);
    }
    
    @Test
    void testAppendSuperWithNonZeroComparison() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.appendSuper(5);
        int superCompareTo = 10;
        
        CompareToBuilder result = builder.appendSuper(superCompareTo);
        
        assertEquals(5, result.comparison);
    }
    
    @Test
    void testAppendSuperWithZeroComparison() {
        CompareToBuilder builder = new CompareToBuilder();
        int superCompareTo = 0;
        
        CompareToBuilder result = builder.appendSuper(superCompareTo);
        
        assertEquals(superCompareTo, result.comparison);
    }
}