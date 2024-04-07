import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.stream.Streams;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class init_PPC_32BitTest {
  
  @Nested
  @DisplayName("Given an empty ARCH_TO_PROCESSOR Map")
  @TestInstance(Lifecycle.PER_CLASS)
  class EmptyMapTest {
    
    private Map<String, Processor> ARCH_TO_PROCESSOR;
    
    @BeforeAll
    void setUp() {
      ARCH_TO_PROCESSOR = new HashMap<>();
      ArchUtils.ARCH_TO_PROCESSOR = ARCH_TO_PROCESSOR;
      ArchUtils.init_PPC_32Bit();
    }
    
    @Test
    @DisplayName("Should add Processor to the Map with correct keys")
    void shouldAddProcessorWithCorrectKeys() {
      assertTrue(ARCH_TO_PROCESSOR.containsKey("ppc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("powerpc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power_pc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power_rs"));
    }
    
    @Test
    @DisplayName("Should add Processor with correct Arch and Type")
    void shouldAddProcessorWithCorrectArchAndType() {
      Processor processor = ARCH_TO_PROCESSOR.get("ppc");
      assertNotNull(processor);
      assertEquals(Processor.Arch.BIT_32, processor.getArch());
      assertEquals(Processor.Type.PPC, processor.getType());
    }
  }
  
  @Nested
  @DisplayName("Given a non-empty ARCH_TO_PROCESSOR Map")
  @TestInstance(Lifecycle.PER_CLASS)
  class NonEmptyMapTest {
    
    private Map<String, Processor> ARCH_TO_PROCESSOR;
    
    @BeforeAll
    void setUp() {
      ARCH_TO_PROCESSOR = new HashMap<>();
      ARCH_TO_PROCESSOR.put("existing_key", new Processor(Processor.Arch.BIT_64, Processor.Type.X86));
      ArchUtils.ARCH_TO_PROCESSOR = ARCH_TO_PROCESSOR;
      ArchUtils.init_PPC_32Bit();
    }
    
    @Test
    @DisplayName("Should not modify existing entries in the Map")
    void shouldNotModifyExistingEntries() {
      assertTrue(ARCH_TO_PROCESSOR.containsKey("existing_key"));
      Processor existingProcessor = ARCH_TO_PROCESSOR.get("existing_key");
      assertNotNull(existingProcessor);
      assertEquals(Processor.Arch.BIT_64, existingProcessor.getArch());
      assertEquals(Processor.Type.X86, existingProcessor.getType());
    }
    
    @Test
    @DisplayName("Should add Processor to the Map with correct keys")
    void shouldAddProcessorWithCorrectKeys() {
      assertTrue(ARCH_TO_PROCESSOR.containsKey("ppc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("powerpc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power_pc"));
      assertTrue(ARCH_TO_PROCESSOR.containsKey("power_rs"));
    }
    
    @Test
    @DisplayName("Should add Processor with correct Arch and Type")
    void shouldAddProcessorWithCorrectArchAndType() {
      Processor processor = ARCH_TO_PROCESSOR.get("ppc");
      assertNotNull(processor);
      assertEquals(Processor.Arch.BIT_32, processor.getArch());
      assertEquals(Processor.Type.PPC, processor.getType());
    }
  }
}