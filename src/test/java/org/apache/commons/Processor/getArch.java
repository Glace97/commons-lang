import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
public class getArchTest {

    @Test
    public void testGetArchReturns32BitArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
        assertEquals(Processor.Arch.BIT_32, processor.getArch());
    }

    @Test
    public void testGetArchReturns64BitArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }

    @Test
    public void testGetArchReturnsUnknownArchitecture() {
        Processor processor = new Processor(Processor.Arch.UNKNOWN, Processor.Type.X86);
        assertEquals(Processor.Arch.UNKNOWN, processor.getArch());
    }

    @Test
    public void testGetArchReturnsAArch64Architecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.AARCH_64);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }

    @Test
    public void testGetArchReturnsIA64Architecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }

    @Test
    public void testGetArchReturnsPPCArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }

    @Test
    public void testGetArchReturnsRISCVArchitecture() {
        Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.RISC_V);
        assertEquals(Processor.Arch.BIT_64, processor.getArch());
    }

}