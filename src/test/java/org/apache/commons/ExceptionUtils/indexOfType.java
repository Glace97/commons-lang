import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class indexOfTypeTest {
    
    @Test
    void testIndexOfType_NullThrowable_ReturnsNegativeOne() {
        int result = ExceptionUtils.indexOfType(null, Exception.class);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOfType_NullType_ReturnsNegativeOne() {
        int result = ExceptionUtils.indexOfType(new Exception(), null);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOfType_NoMatchInChain_ReturnsNegativeOne() {
        int result = ExceptionUtils.indexOfType(new Exception(), IllegalArgumentException.class);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOfType_ThrowableMatchesType_ReturnsZero() {
        int result = ExceptionUtils.indexOfType(new IllegalArgumentException(), IllegalArgumentException.class);
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOfType_ThrowableMatchesSubclass_ReturnsZero() {
        int result = ExceptionUtils.indexOfType(new ArrayIndexOutOfBoundsException(), IndexOutOfBoundsException.class);
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOfType_ThrowableDoesNotMatchSubclass_ReturnsNegativeOne() {
        int result = ExceptionUtils.indexOfType(new IndexOutOfBoundsException(), ArrayIndexOutOfBoundsException.class);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOfType_StartIndexGreaterThanChainSize_ReturnsNegativeOne() {
        int result = ExceptionUtils.indexOfType(new Exception(), Exception.class, 1);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOfType_NegativeStartIndex_TreatedAsZero() {
        int result = ExceptionUtils.indexOfType(new Exception(), Exception.class, -1);
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOfType_StartIndexInRange_ReturnsCorrectIndex() {
        Throwable throwable = new Exception(new IllegalArgumentException(new IndexOutOfBoundsException()));
        int result = ExceptionUtils.indexOfType(throwable, IllegalArgumentException.class, 1);
        assertEquals(2, result);
    }
}