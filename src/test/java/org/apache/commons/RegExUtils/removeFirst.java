```
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class removeFirstTest {

    @Test
    void testRemoveFirstWithNullText() {
        assertNull(RegExUtils.removeFirst(null, Pattern.compile(".*")));
    }

    @Test
    void testRemoveFirstWithNullRegex() {
        assertEquals("any", RegExUtils.removeFirst("any", (Pattern) null));
    }

    @Test
    void testRemoveFirstWithEmptyRegex() {
        assertEquals("any", RegExUtils.removeFirst("any", ""));
    }

    @Test
    void testRemoveFirstWithEmptyTextAndRegex() {
        assertEquals("", RegExUtils.removeFirst("", ""));
    }

    @Test
    void testRemoveFirstWithTextAndPatternMatching() {
        assertEquals("", RegExUtils.removeFirst("any", Pattern.compile(".*")));
        assertEquals("", RegExUtils.removeFirst("any", Pattern.compile(".+")));
        assertEquals("bc", RegExUtils.removeFirst("abc", Pattern.compile(".?")));
        assertEquals("A\n&lt;__&gt;B", RegExUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", Pattern.compile("&lt;.*&gt;")));
        assertEquals("AB", RegExUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", Pattern.compile("(?s)&lt;.*&gt;")));
        assertEquals("ABCbc123", RegExUtils.removeFirst("ABCabc123", Pattern.compile("[a-z]")));
        assertEquals("ABC123abc", RegExUtils.removeFirst("ABCabc123abc", Pattern.compile("[a-z]+")));
    }

    @Test
    void testRemoveFirstWithTextAndRegexMatching() {
        assertEquals("", RegExUtils.removeFirst("any", ".*"));
        assertEquals("", RegExUtils.removeFirst("any", ".+"));
        assertEquals("bc", RegExUtils.removeFirst("abc", ".?"));
        assertEquals("A\n&lt;__&gt;B", RegExUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;"));
        assertEquals("AB", RegExUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "(?s)&lt;.*&gt;"));
        assertEquals("ABCbc123", RegExUtils.removeFirst("ABCabc123", "[a-z]"));
        assertEquals("ABC123abc", RegExUtils.removeFirst("ABCabc123abc", "[a-z]+"));
    }

}
```

Explanation:
- The test class is named `removeFirstTest`.
- The test class imports the necessary classes and annotations.
- The test class is annotated with `@TestInstance(Lifecycle.PER_CLASS)` to ensure that the test methods are executed in the same instance of the test class.
- The test methods cover the different scenarios and edge cases for the `removeFirst` method.
- The assertions are made using the `assertEquals` method to compare the expected results with the actual results returned by the `removeFirst` method.