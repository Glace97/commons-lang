import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class getCauseTest {

    @Test
    void testGetCause() {
        Throwable throwable = null;
        Assertions.assertNull(ExceptionUtils.getCause(throwable), "getCause should return null for null throwable");

        throwable = new Throwable();
        Assertions.assertNull(ExceptionUtils.getCause(throwable), "getCause should return null for throwable without cause");

        Throwable cause = new Throwable("Cause");
        throwable = new Throwable(cause);
        Assertions.assertEquals(cause, ExceptionUtils.getCause(throwable), "getCause should return the cause of the throwable");

        throwable = new Throwable();
        String[] methodNames = {"getCause"};
        Assertions.assertNull(ExceptionUtils.getCause(throwable, methodNames), "getCause should return null for throwable without cause");

        Throwable customCause = new Throwable("Custom Cause");
        throwable = new Throwable(customCause);
        methodNames = new String[]{"getCustomCause"};
        Assertions.assertNull(ExceptionUtils.getCause(throwable, methodNames), "getCause should return null for throwable without cause when using custom method names");
    }
}