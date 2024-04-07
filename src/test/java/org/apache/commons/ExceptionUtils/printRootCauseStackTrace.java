
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.PrintStream;
import java.io.PrintWriter;

@ExtendWith(MockitoExtension.class)
class printRootCauseStackTraceTest {

    @Mock
    private PrintStream mockPrintStream;

    @Mock
    private PrintWriter mockPrintWriter;

    private Throwable throwable;

    @BeforeEach
    void setup(TestInfo testInfo) {
        Throwable rootCause = new Throwable("Root cause");
        throwable = new RuntimeException("Wrapper exception", rootCause);
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with System.err")
    void testPrintRootCauseStackTraceWithSystemErr() {
        ExceptionUtils.printRootCauseStackTrace(throwable);

        // Verify that the printStream was called with the expected stack trace
        Mockito.verify(mockPrintStream, Mockito.times(1)).println(Mockito.anyString());
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with PrintStream")
    void testPrintRootCauseStackTraceWithPrintStream() {
        ExceptionUtils.printRootCauseStackTrace(throwable, mockPrintStream);

        // Verify that the printStream was called with the expected stack trace
        Mockito.verify(mockPrintStream, Mockito.times(1)).println(Mockito.anyString());
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with PrintWriter")
    void testPrintRootCauseStackTraceWithPrintWriter() {
        ExceptionUtils.printRootCauseStackTrace(throwable, mockPrintWriter);

        // Verify that the printWriter was called with the expected stack trace
        Mockito.verify(mockPrintWriter, Mockito.times(1)).println(Mockito.anyString());
    }

    // Add more test cases to achieve high coverage and cover all edge cases

}
