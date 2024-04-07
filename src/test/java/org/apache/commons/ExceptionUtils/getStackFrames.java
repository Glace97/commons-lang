import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getStackFramesTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private String stackTrace;

    @BeforeEach
    void setUp() {
        stackTrace = "Exception in thread \"main\" java.lang.NullPointerException" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method1(ExampleClass.java:10)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method2(ExampleClass.java:20)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method3(ExampleClass.java:30)" + LINE_SEPARATOR +
                "Caused by: java.lang.IllegalArgumentException" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method4(ExampleClass.java:40)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method5(ExampleClass.java:50)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method6(ExampleClass.java:60)" + LINE_SEPARATOR +
                "Caused by: java.lang.ArithmeticException" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method7(ExampleClass.java:70)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method8(ExampleClass.java:80)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method9(ExampleClass.java:90)" + LINE_SEPARATOR +
                "Caused by: java.lang.IndexOutOfBoundsException" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method10(ExampleClass.java:100)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method11(ExampleClass.java:110)" + LINE_SEPARATOR +
                "\tat com.example.ExampleClass.method12(ExampleClass.java:120)" + LINE_SEPARATOR;

    }

    @Test
    void testGetStackFrames_NullThrowable() {
        Throwable throwable = null;
        String[] frames = ExceptionUtils.getStackFrames(throwable);
        assertEquals(0, frames.length);
    }

    @Test
    void testGetStackFrames_NoStackTrace() {
        Throwable throwable = new Throwable("");
        String[] frames = ExceptionUtils.getStackFrames(throwable);
        assertEquals(0, frames.length);
    }

    @Test
    void testGetStackFrames_SingleStackTrace() {
        Throwable throwable = new Throwable("Exception message");
        String[] frames = ExceptionUtils.getStackFrames(throwable);
        assertEquals(1, frames.length);
        assertEquals("java.lang.Throwable: Exception message", frames[0]);
    }

    @Test
    void testGetStackFrames_MultipleStackTraces() {
        Throwable throwable = new Throwable(stackTrace);
        String[] frames = ExceptionUtils.getStackFrames(throwable);
        assertEquals(13, frames.length);
        assertEquals("Exception in thread \"main\" java.lang.NullPointerException", frames[0]);
        assertEquals("\tat com.example.ExampleClass.method1(ExampleClass.java:10)", frames[1]);
        assertEquals("\tat com.example.ExampleClass.method2(ExampleClass.java:20)", frames[2]);
        assertEquals("\tat com.example.ExampleClass.method3(ExampleClass.java:30)", frames[3]);
        assertEquals("Caused by: java.lang.IllegalArgumentException", frames[4]);
        assertEquals("\tat com.example.ExampleClass.method4(ExampleClass.java:40)", frames[5]);
        assertEquals("\tat com.example.ExampleClass.method5(ExampleClass.java:50)", frames[6]);
        assertEquals("\tat com.example.ExampleClass.method6(ExampleClass.java:60)", frames[7]);
        assertEquals("Caused by: java.lang.ArithmeticException", frames[8]);
        assertEquals("\tat com.example.ExampleClass.method7(ExampleClass.java:70)", frames[9]);
        assertEquals("\tat com.example.ExampleClass.method8(ExampleClass.java:80)", frames[10]);
        assertEquals("\tat com.example.ExampleClass.method9(ExampleClass.java:90)", frames[11]);
        assertEquals("Caused by: java.lang.IndexOutOfBoundsException", frames[12]);
        assertEquals("\tat com.example.ExampleClass.method10(ExampleClass.java:100)", frames[13]);
    }

    @Test
    void testGetStackFrames_StackTracesWithWrappedExceptions() {
        Throwable throwable = new Throwable("Exception message");
        throwable.initCause(new NullPointerException("Null pointer exception"));
        throwable.getCause().initCause(new IllegalArgumentException("Illegal argument exception"));
        throwable.getCause().getCause().initCause(new ArithmeticException("Arithmetic exception"));
        throwable.getCause().getCause().getCause().initCause(new IndexOutOfBoundsException("Index out of bounds exception"));
        String[] frames = ExceptionUtils.getStackFrames(throwable);
        assertEquals(5, frames.length);
        assertEquals("java.lang.Throwable: Exception message", frames[0]);
        assertEquals(WRAPPED_MARKER + "java.lang.NullPointerException: Null pointer exception", frames[1]);
        assertEquals(WRAPPED_MARKER + "\tat com.example.ExampleClass.method1(ExampleClass.java:10)", frames[2]);
        assertEquals(WRAPPED_MARKER + "java.lang.IllegalArgumentException: Illegal argument exception", frames[3]);
        assertEquals(WRAPPED_MARKER + "\tat com.example.ExampleClass.method4(ExampleClass.java:40)", frames[4]);
    }
}