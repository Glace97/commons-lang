import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class throwableOfTypeTest {

    @Test
    void testThrowableOfType_NullThrowable_ReturnsNull() {
        Throwable throwable = null;
        Class<Exception> type = Exception.class;

        Exception result = ExceptionUtils.throwableOfType(throwable, type);

        Assertions.assertNull(result);
    }

    @Test
    void testThrowableOfType_NullType_ReturnsNull() {
        Throwable throwable = new Exception();
        Class<Exception> type = null;

        Exception result = ExceptionUtils.throwableOfType(throwable, type);

        Assertions.assertNull(result);
    }

    @Test
    void testThrowableOfType_NoMatchInChain_ReturnsNull() {
        Throwable throwable = new Exception();
        Class<RuntimeException> type = RuntimeException.class;

        RuntimeException result = ExceptionUtils.throwableOfType(throwable, type);

        Assertions.assertNull(result);
    }

    @Test
    void testThrowableOfType_MatchInChain_ReturnsMatchingThrowable() {
        Throwable throwable = new Exception(new RuntimeException());
        Class<RuntimeException> type = RuntimeException.class;

        RuntimeException result = ExceptionUtils.throwableOfType(throwable, type);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(RuntimeException.class, result.getClass());
    }

    @Test
    void testThrowableOfType_IndexGreaterThanChainSize_ReturnsNull() {
        Throwable throwable = new Exception(new RuntimeException());
        Class<RuntimeException> type = RuntimeException.class;
        int fromIndex = 10;

        RuntimeException result = ExceptionUtils.throwableOfType(throwable, type, fromIndex);

        Assertions.assertNull(result);
    }

    @Test
    void testThrowableOfType_NegativeStartIndex_TreatedAsZero() {
        Throwable throwable = new Exception(new RuntimeException());
        Class<RuntimeException> type = RuntimeException.class;
        int fromIndex = -1;

        RuntimeException result = ExceptionUtils.throwableOfType(throwable, type, fromIndex);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(RuntimeException.class, result.getClass());
    }
}