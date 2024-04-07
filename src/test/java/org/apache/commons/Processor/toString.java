
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class toStringTest {

    @Test
    public void testToString() {
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.X86;
        Processor processor = new Processor(arch, type);

        String expected = "x86 32-bit";
        String actual = processor.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithUnknownArch() {
        Processor.Arch arch = Processor.Arch.UNKNOWN;
        Processor.Type type = Processor.Type.X86;
        Processor processor = new Processor(arch, type);

        String expected = "x86 Unknown";
        String actual = processor.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithUnknownType() {
        Processor.Arch arch = Processor.Arch.BIT_32;
        Processor.Type type = Processor.Type.UNKNOWN;
        Processor processor = new Processor(arch, type);

        String expected = "Unknown 32-bit";
        String actual = processor.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithUnknownArchAndType() {
        Processor.Arch arch = Processor.Arch.UNKNOWN;
        Processor.Type type = Processor.Type.UNKNOWN;
        Processor processor = new Processor(arch, type);

        String expected = "Unknown Unknown";
        String actual = processor.toString();

        Assertions.assertEquals(expected, actual);
    }
}
