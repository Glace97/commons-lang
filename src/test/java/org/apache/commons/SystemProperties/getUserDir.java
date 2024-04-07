
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class getUserDirTest {

    @Test
    void testGetUserDir() {
        String expected = "C:/Users/Username"; // Replace with the expected value of the user.dir property

        // Mocking the SystemProperties class
        SystemProperties mockedSystemProperties = mock(SystemProperties.class);
        when(mockedSystemProperties.getProperty("user.dir")).thenReturn(expected);

        // Call the getUserDir method
        String actual = mockedSystemProperties.getUserDir();

        // Assertion
        assertEquals(expected, actual);
    }
}
