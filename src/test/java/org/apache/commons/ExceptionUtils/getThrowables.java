import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getThrowablesTest {
    
    @Test
    void testGetThrowables_WithNullThrowable_ReturnsEmptyArray() {
        Throwable[] throwables = ExceptionUtils.getThrowables(null);
        assertEquals(0, throwables.length);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithoutCause_ReturnsArrayWithOneElement() {
        Throwable throwable = new Throwable();
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(1, throwables.length);
        assertSame(throwable, throwables[0]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithOneCause_ReturnsArrayWithTwoElements() {
        Throwable cause = new Throwable();
        Throwable throwable = new Throwable(cause);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(2, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause, throwables[1]);
    }
    
    @Test
    void testGetThrowables_WithRecursiveCauseChain_ReturnsArrayWithUniqueElements() {
        Throwable cause1 = new Throwable();
        Throwable cause2 = new Throwable(cause1);
        cause1.initCause(cause2);
        Throwable throwable = new Throwable(cause1);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(3, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause1, throwables[1]);
        assertSame(cause2, throwables[2]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithNestedCause_ReturnsArrayWithUniqueElements() {
        Throwable cause1 = new Throwable();
        Throwable cause2 = new Throwable(cause1);
        Throwable throwable = new Throwable(cause2);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(3, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause2, throwables[1]);
        assertSame(cause1, throwables[2]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithLinkedCause_ReturnsArrayWithUniqueElements() {
        Throwable cause1 = new Throwable();
        Throwable cause2 = new Throwable();
        cause2.initCause(cause1);
        Throwable throwable = new Throwable(cause2);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(3, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause2, throwables[1]);
        assertSame(cause1, throwables[2]);
    }
    
    @Test
    void testGetThrowables_WithThrowablesWithDifferentCauses_ReturnsArrayWithUniqueElements() {
        Throwable cause1 = new Throwable();
        Throwable cause2 = new Throwable();
        Throwable throwable1 = new Throwable(cause1);
        Throwable throwable2 = new Throwable(cause2);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable1, throwable2);
        assertEquals(4, throwables.length);
        assertSame(throwable1, throwables[0]);
        assertSame(cause1, throwables[1]);
        assertSame(throwable2, throwables[2]);
        assertSame(cause2, throwables[3]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithNullCause_ReturnsArrayWithOneElement() {
        Throwable throwable = new Throwable((Throwable)null);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(1, throwables.length);
        assertSame(throwable, throwables[0]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithUndeclaredThrowableCause_ReturnsArrayWithOneElement() {
        Throwable cause = new Throwable();
        Throwable throwable = new UndeclaredThrowableException(cause);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(1, throwables.length);
        assertSame(throwable, throwables[0]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithInvocationTargetExceptionCause_ReturnsArrayWithTwoElements() {
        Throwable cause = new Throwable();
        Throwable throwable = new InvocationTargetException(cause);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(2, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause, throwables[1]);
    }
    
    @Test
    void testGetThrowables_WithThrowableWithCustomCauseMethod_ReturnsArrayWithTwoElements() {
        Throwable cause = new Throwable();
        Throwable throwable = new CustomException(cause);
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);
        assertEquals(2, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause, throwables[1]);
    }
    
    private static class CustomException extends Exception {
        public CustomException(Throwable cause) {
            super(cause);
        }
    }
}