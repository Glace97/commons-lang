import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class isPPCTest {
    private Processor processor;

    @BeforeEach
    void setUp() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
    }

    @Test
    void testIsPPC_ReturnsTrue() {
        assertTrue(processor.isPPC());
    }

    @Test
    void testIsPPC_ReturnsFalse() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor.isPPC());
    }

    @Test
    void testIsPPC_CorrectArchAndUnknownType_ReturnsFalse() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertFalse(processor.isPPC());
    }

    @Test
    void testIsPPC_CorrectTypeAndUnknownArch_ReturnsFalse() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.PPC);
        assertFalse(processor.isPPC());
    }

    @Test
    void testIsPPC_UnknownArchAndUnknownType_ReturnsFalse() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(processor.isPPC());
    }
}