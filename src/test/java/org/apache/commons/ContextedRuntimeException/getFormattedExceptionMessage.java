import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getFormattedExceptionMessageTest {
  
  private ContextedRuntimeException exception;

  @BeforeEach
  void setUp() {
    exception = new ContextedRuntimeException();
  }

  @Test
  void testGetFormattedExceptionMessage_withBaseMessage_ReturnsFormattedMessage() {
    String baseMessage = "Base message";
    String expectedResult = "Formatted message: " + baseMessage;
    
    String result = exception.getFormattedExceptionMessage(baseMessage);
    
    assertEquals(expectedResult, result);
  }

  @Test
  void testGetFormattedExceptionMessage_withoutBaseMessage_ReturnsFormattedMessageWithNull() {
    String expectedResult = "Formatted message: null";
    
    String result = exception.getFormattedExceptionMessage(null);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testGetFormattedExceptionMessage_withMessageAndCause_ReturnsFormattedMessageWithMessage() {
    String message = "Exception message";
    Throwable cause = new Throwable("Cause");
    String baseMessage = "Base message";
    String expectedResult = "Formatted message: " + baseMessage;
    
    exception = new ContextedRuntimeException(message, cause);
    String result = exception.getFormattedExceptionMessage(baseMessage);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testGetFormattedExceptionMessage_withMessageAndCauseAndContext_ReturnsFormattedMessageWithMessage() {
    String message = "Exception message";
    Throwable cause = new Throwable("Cause");
    String baseMessage = "Base message";
    String expectedResult = "Formatted message: " + baseMessage;
    ExceptionContext context = new DefaultExceptionContext();
    
    exception = new ContextedRuntimeException(message, cause, context);
    String result = exception.getFormattedExceptionMessage(baseMessage);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testGetFormattedExceptionMessage_withCause_ReturnsFormattedMessageWithCause() {
    Throwable cause = new Throwable("Cause");
    String baseMessage = "Base message";
    String expectedResult = "Formatted message: " + baseMessage;
    
    exception = new ContextedRuntimeException(cause);
    String result = exception.getFormattedExceptionMessage(baseMessage);
    
    assertEquals(expectedResult, result);
  }
}