import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class getActiveExecutorTest {
  
  private BackgroundInitializer backgroundInitializer;
  
  @BeforeEach
  void setUp() {
    backgroundInitializer = new BackgroundInitializer();
  }
  
  @AfterEach
  void tearDown() {
    backgroundInitializer = null;
  }
  
  @Test
  void testGetActiveExecutor_NoExternalExecutor_ReturnsNotNull() {
    ExecutorService executorService = backgroundInitializer.getActiveExecutor();
    assertNotNull(executorService);
  }
  
  @Test
  void testGetActiveExecutor_ExternalExecutorSet_ReturnsExternalExecutor() {
    ExecutorService externalExecutor = Executors.newFixedThreadPool(1);
    backgroundInitializer.setExternalExecutor(externalExecutor);
    
    ExecutorService activeExecutor = backgroundInitializer.getActiveExecutor();
    
    assertEquals(externalExecutor, activeExecutor);
  }
  
  @Test
  void testGetActiveExecutor_StartCalledBefore_ReturnsNull() {
    ExecutorService executorService = backgroundInitializer.getActiveExecutor();
    assertNull(executorService);
  }
}