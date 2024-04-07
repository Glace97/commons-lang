import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;

class getLeftTest {

    private DiffBuilder<Integer> diffBuilder;

    @BeforeEach
    void setUp() {
        diffBuilder = new DiffBuilder<>();
    }

    @Test
    void testGetLeft() {
        Integer left = 5;
        Supplier<Integer> leftSupplier = () -> left;
        Supplier<Integer> rightSupplier = () -> 10;
        SDiff<Integer> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer.class);
        diffBuilder.setLeft(left).setRight(10);
        DiffBuilder<Integer> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }

    @Test
    void testGetLeftWithNull() {
        Integer left = null;
        Supplier<Integer> leftSupplier = () -> left;
        Supplier<Integer> rightSupplier = () -> 10;
        SDiff<Integer> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer.class);
        diffBuilder.setLeft(left).setRight(10);
        DiffBuilder<Integer> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithEqualsObjects() {
        Integer left = 5;
        Supplier<Integer> leftSupplier = () -> left;
        Supplier<Integer> rightSupplier = () -> 5;
        SDiff<Integer> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer.class);
        diffBuilder.setLeft(left).setRight(5);
        DiffBuilder<Integer> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithDifferentObjects() {
        Integer left = 5;
        Supplier<Integer> leftSupplier = () -> left;
        Supplier<Integer> rightSupplier = () -> 10;
        SDiff<Integer> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer.class);
        diffBuilder.setLeft(left).setRight(10);
        DiffBuilder<Integer> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithEmptyArray() {
        Integer[] left = {};
        Supplier<Integer[]> leftSupplier = () -> left;
        Supplier<Integer[]> rightSupplier = () -> {return new Integer[] {1, 2, 3};};
        SDiff<Integer[]> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer[].class);
        diffBuilder.setLeft(left).setRight(new Integer[] {1, 2, 3});
        DiffBuilder<Integer[]> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithNullArray() {
        Integer[] left = null;
        Supplier<Integer[]> leftSupplier = () -> left;
        Supplier<Integer[]> rightSupplier = () -> {return new Integer[] {1, 2, 3};};
        SDiff<Integer[]> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Integer[].class);
        diffBuilder.setLeft(left).setRight(new Integer[] {1, 2, 3});
        DiffBuilder<Integer[]> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithEmptyList() {
        List<Integer> left = new ArrayList<>();
        Supplier<List<Integer>> leftSupplier = () -> left;
        Supplier<List<Integer>> rightSupplier = () -> {return Arrays.asList(1, 2, 3);};
        SDiff<List<Integer>> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, List.class);
        diffBuilder.setLeft(left).setRight(Arrays.asList(1, 2, 3));
        DiffBuilder<List<Integer>> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
    
    @Test
    void testGetLeftWithNullList() {
        List<Integer> left = null;
        Supplier<List<Integer>> leftSupplier = () -> left;
        Supplier<List<Integer>> rightSupplier = () -> {return Arrays.asList(1, 2, 3);};
        SDiff<List<Integer>> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, List.class);
        diffBuilder.setLeft(left).setRight(Arrays.asList(1, 2, 3));
        DiffBuilder<List<Integer>> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
  
    @Test
    void testGetLeftWithEqualsStrings() {
        String left = "Hello";
        Supplier<String> leftSupplier = () -> left;
        Supplier<String> rightSupplier = () -> "Hello";
        SDiff<String> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, String.class);
        diffBuilder.setLeft(left).setRight("Hello");
        DiffBuilder<String> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
  
    @Test
    void testGetLeftWithDifferentStrings() {
        String left = "Hello";
        Supplier<String> leftSupplier = () -> left;
        Supplier<String> rightSupplier = () -> "World";
        SDiff<String> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, String.class);
        diffBuilder.setLeft(left).setRight("World");
        DiffBuilder<String> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
  
    @Test
    void testGetLeftWithEqualsBooleans() {
        boolean left = true;
        Supplier<Boolean> leftSupplier = () -> left;
        Supplier<Boolean> rightSupplier = () -> true;
        SDiff<Boolean> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Boolean.class);
        diffBuilder.setLeft(left).setRight(true);
        DiffBuilder<Boolean> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }
  
    @Test
    void testGetLeftWithDifferentBooleans() {
        boolean left = true;
        Supplier<Boolean> leftSupplier = () -> left;
        Supplier<Boolean> rightSupplier = () -> false;
        SDiff<Boolean> diff = new SDiff<>("fieldName", leftSupplier, rightSupplier, Boolean.class);
        diffBuilder.setLeft(left).setRight(false);
        DiffBuilder<Boolean> builtDiffBuilder = diffBuilder.build();
        assertEquals(left, diff.getLeft());
        assertEquals(left, builtDiffBuilder.getLeft());
    }

}