import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class allNullTest {

	@Test
	void testAllNull_EmptyArray_ReturnsTrue() {
		assertTrue(ObjectUtils.allNull());
	}

	@Test
	void testAllNull_NullValues_ReturnsTrue() {
		assertTrue(ObjectUtils.allNull(null, null, null));
	}

	@Test
	void testAllNull_NonNullValue_ReturnsFalse() {
		assertFalse(ObjectUtils.allNull(null, "value", null));
	}

	@Test
	void testAllNull_NullValueInArray_ReturnsFalse() {
		assertFalse(ObjectUtils.allNull("value", null, "value"));
	}

	@Test
	void testAllNull_MixedValues_ReturnsFalse() {
		assertFalse(ObjectUtils.allNull(null, 1, null, "value", null));
	}
}