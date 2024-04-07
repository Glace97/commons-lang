import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

class indexOfThrowableTest {

    @Test
    void testIndexOfThrowable_NullThrowable_ReturnsMinusOne() {
        Throwable throwable = null;
        Class<? extends Throwable> clazz = IOException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_NullType_ReturnsMinusOne() {
        Throwable throwable = new IOException();
        Class<? extends Throwable> clazz = null;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_NoMatchInChain_ReturnsMinusOne() {
        Throwable throwable = new IOException();
        Class<? extends Throwable> clazz = NullPointerException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_MatchInChain_ReturnsCorrectIndex() {
        Throwable throwable = new IOException(new NullPointerException());
        Class<? extends Throwable> clazz = NullPointerException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz);
        Assertions.assertEquals(0, index);
    }

    @Test
    void testIndexOfThrowable_SubclassMatchInChain_ReturnsMinusOne() {
        Throwable throwable = new IOException(new UndeclaredThrowableException(new NullPointerException()));
        Class<? extends Throwable> clazz = Throwable.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_NegativeStartIndex_ReturnsZero() {
        Throwable throwable = new IOException(new NullPointerException());
        Class<? extends Throwable> clazz = NullPointerException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz, -1);
        Assertions.assertEquals(0, index);
    }

    @Test
    void testIndexOfThrowable_StartIndexGreaterThanChainSize_ReturnsMinusOne() {
        Throwable throwable = new IOException(new NullPointerException());
        Class<? extends Throwable> clazz = NullPointerException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz, 2);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_StartIndexEqualToChainSize_ReturnsMinusOne() {
        Throwable throwable = new IOException(new NullPointerException());
        Class<? extends Throwable> clazz = NullPointerException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz, 1);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testIndexOfThrowable_MatchInChainFromStartIndex_ReturnsCorrectIndex() {
        Throwable throwable = new IOException(new NullPointerException(new IllegalArgumentException()));
        Class<? extends Throwable> clazz = IllegalArgumentException.class;
        int index = ExceptionUtils.indexOfThrowable(throwable, clazz, 1);
        Assertions.assertEquals(0, index);
    }
    
}