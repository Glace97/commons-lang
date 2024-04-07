import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isAarch64Test {

    private Processor processor;

    @BeforeEach
    public void setUp() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
    }

    @Test
    public void testIsAarch64_ReturnsTrue() {
        assertTrue(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenUnknownType() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.UNKNOWN);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenUnknownArch() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.AARCH_64);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenUnknownArchAndType() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.UNKNOWN);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenDifferentArchAndType() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.PPC);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenDifferentArchAndType_2() {
        processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenDifferentArchAndType_3() {
        processor = new Processor(Processor.Arch.BIT_32, Processor.Type.RISC_V);
        assertFalse(processor.isAarch64());
    }

    @Test
    public void testIsAarch64_ReturnsFalse_WhenDifferentArchAndType_4() {
        processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertFalse(processor.isAarch64());
    }
}