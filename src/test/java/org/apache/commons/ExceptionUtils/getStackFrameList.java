
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getStackFrameListTest {

    @Test
    void testGetStackFrameList_EmptyStackTrace() {
        Throwable throwable = new Throwable();
        List<String> stackFrames = ExceptionUtils.getStackFrameList(throwable);
        assertEquals(0, stackFrames.size());
    }

    @Test
    void testGetStackFrameList_SingleStackFrame() {
        Throwable throwable = new Throwable("Test Exception");
        List<String> stackFrames = ExceptionUtils.getStackFrameList(throwable);
        assertEquals(1, stackFrames.size());
        assertEquals("at getStackFrameListTest.testGetStackFrameList_SingleStackFrame", stackFrames.get(0));
    }

    @Test
    void testGetStackFrameList_MultipleStackFrames() {
        try {
            throwException();
        } catch (Throwable throwable) {
            List<String> stackFrames = ExceptionUtils.getStackFrameList(throwable);
            assertEquals(3, stackFrames.size());
            assertEquals("at getStackFrameListTest.throwException", stackFrames.get(0));
            assertEquals("at getStackFrameListTest.testGetStackFrameList_MultipleStackFrames", stackFrames.get(1));
            assertEquals("at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke", stackFrames.get(2));
        }
    }

    private void throwException() throws Throwable {
        throw new Exception("Test Exception");
    }
}
