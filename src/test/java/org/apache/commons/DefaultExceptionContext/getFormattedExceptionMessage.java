import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class getFormattedExceptionMessageTest {

    private DefaultExceptionContext context;

    @BeforeEach
    void setUp() {
        context = new DefaultExceptionContext();
    }

    @Test
    void testGetFormattedExceptionMessage_BaseMessageNotNull() {
        String baseMessage = "Base message";
        String formattedMessage = context.getFormattedExceptionMessage(baseMessage);
        
        assertTrue(formattedMessage.contains(baseMessage));
    }

    @Test
    void testGetFormattedExceptionMessage_BaseMessageNull() {
        String baseMessage = null;
        String formattedMessage = context.getFormattedExceptionMessage(baseMessage);
        
        assertEquals("", formattedMessage);
    }

    @Test
    void testGetFormattedExceptionMessage_EmptyContextValues() {
        String formattedMessage = context.getFormattedExceptionMessage("Base message");
        
        assertFalse(formattedMessage.contains("Exception Context"));
        assertFalse(formattedMessage.contains("1:"));
        assertFalse(formattedMessage.contains("="));
    }

    @Test
    void testGetFormattedExceptionMessage_WithNullValue() {
        context.contextValues.add(new ImmutablePair<>("key", null));
        String formattedMessage = context.getFormattedExceptionMessage("Base message");
        
        assertTrue(formattedMessage.contains("[1:key=null]"));
    }

    @Test
    void testGetFormattedExceptionMessage_WithValueToString() {
        context.contextValues.add(new ImmutablePair<>("key", "value"));
        String formattedMessage = context.getFormattedExceptionMessage("Base message");
        
        assertTrue(formattedMessage.contains("[1:key=value]"));
    }

    @Test
    void testGetFormattedExceptionMessage_WithExceptionToString() {
        context.contextValues.add(new ImmutablePair<>("key", new Object() {
            @Override
            public String toString() {
                throw new RuntimeException("Exception thrown on toString()");
            }
        }));
        String formattedMessage = context.getFormattedExceptionMessage("Base message");
        
        assertTrue(formattedMessage.contains("[1:key=Exception thrown on toString()"));
    }
}