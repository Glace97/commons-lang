import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class allMatchTest {

   @Test
   void testAllMatchEmptyStream() {
      FailableStream<Object> stream = new FailableStream<>(Stream.empty());
      boolean result = stream.allMatch(element -> {
         throw new RuntimeException("This predicate should not be evaluated");
      });
      assertTrue(result);
   }

   @Test
   void testAllMatchTruePredicate() {
      FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
      boolean result = stream.allMatch(element -> element < 10);
      assertTrue(result);
   }

   @Test
   void testAllMatchFalsePredicate() {
      FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
      boolean result = stream.allMatch(element -> element > 3);
      assertFalse(result);
   }

   @Test
   void testAllMatchExceptionThrown() {
      FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
      assertThrows(RuntimeException.class, () -> {
         stream.allMatch(element -> {
            throw new RuntimeException("Exception thrown");
         });
      });
   }
}