import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.function.Function;

class FunctionTest {

    @Test
    void testFunction() {
        // Test case 1: Test function with a simple identity function
        Function<Integer, Integer> identityFunction = Functions.function(Function.identity());
        int input1 = 5;
        int expectedOutput1 = 5;
        int actualOutput1 = identityFunction.apply(input1);
        Assertions.assertEquals(expectedOutput1, actualOutput1);

        // Test case 2: Test function with a transformation function
        Function<Integer, String> transformationFunction = Functions.function(Object::toString);
        int input2 = 10;
        String expectedOutput2 = "10";
        String actualOutput2 = transformationFunction.apply(input2);
        Assertions.assertEquals(expectedOutput2, actualOutput2);

        // Test case 3: Test function with a composed function
        Function<Integer, Integer> composedFunction = Functions.function(Function.identity())
                .andThen(x -> x + 1)
                .andThen(x -> x * 2);
        int input3 = 3;
        int expectedOutput3 = 8;
        int actualOutput3 = composedFunction.apply(input3);
        Assertions.assertEquals(expectedOutput3, actualOutput3);
    }
}