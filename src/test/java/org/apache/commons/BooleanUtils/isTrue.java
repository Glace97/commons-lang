import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestSuite;

class isTrueTest {
    
    @Test
    void testIsTrueWithTrue() {
        Boolean bool = true;
        boolean result = BooleanUtils.isTrue(bool);
        assertEquals(true, result);
    }
    
    @Test
    void testIsTrueWithFalse() {
        Boolean bool = false;
        boolean result = BooleanUtils.isTrue(bool);
        assertEquals(false, result);
    }
    
    @Test
    void testIsTrueWithNull() {
        Boolean bool = null;
        boolean result = BooleanUtils.isTrue(bool);
        assertEquals(false, result);
    }
    
    @Test
    void testIsTrueWithOtherBooleanValues() {
        Boolean bool1 = Boolean.TRUE;
        boolean result1 = BooleanUtils.isTrue(bool1);
        assertEquals(true, result1);
        
        Boolean bool2 = Boolean.FALSE;
        boolean result2 = BooleanUtils.isTrue(bool2);
        assertEquals(false, result2);
    }
    
    @Test
    void testIsTrueWithStringValues() {
        Boolean bool1 = BooleanUtils.TRUE;
        boolean result1 = BooleanUtils.isTrue(bool1);
        assertEquals(true, result1);
        
        Boolean bool2 = BooleanUtils.FALSE;
        boolean result2 = BooleanUtils.isTrue(bool2);
        assertEquals(false, result2);
        
        Boolean bool3 = BooleanUtils.NO;
        boolean result3 = BooleanUtils.isTrue(bool3);
        assertEquals(false, result3);
        
        Boolean bool4 = BooleanUtils.YES;
        boolean result4 = BooleanUtils.isTrue(bool4);
        assertEquals(true, result4);
        
        Boolean bool5 = BooleanUtils.ON;
        boolean result5 = BooleanUtils.isTrue(bool5);
        assertEquals(true, result5);
        
        Boolean bool6 = BooleanUtils.OFF;
        boolean result6 = BooleanUtils.isTrue(bool6);
        assertEquals(false, result6);
    }
    
    @Test
    void testIsTrueWithOtherObjectTypes() {
        Boolean bool = NumberUtils.createBoolean("1");
        boolean result = BooleanUtils.isTrue(bool);
        assertEquals(true, result);
    }
}

public class isTrueTestSuite {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(isTrueTest.class);
        return suite;
    }
}
