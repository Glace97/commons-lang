import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isEmptyTest {

	@Test
	void testEmptyString() {
		String str = "";
		assertTrue(ObjectUtils.isEmpty(str));
	}

	@Test
	void testNonEmptyString() {
		String str = "Hello";
		assertFalse(ObjectUtils.isEmpty(str));
	}

	@Test
	void testNullString() {
		String str = null;
		assertTrue(ObjectUtils.isEmpty(str));
	}

	@Test
	void testEmptyArray() {
		int[] arr = new int[0];
		assertTrue(ObjectUtils.isEmpty(arr));
	}

	@Test
	void testNonEmptyArray() {
		int[] arr = {1, 2, 3};
		assertFalse(ObjectUtils.isEmpty(arr));
	}

	@Test
	void testNullArray() {
		int[] arr = null;
		assertTrue(ObjectUtils.isEmpty(arr));
	}

	@Test
	void testEmptyCollection() {
		Collection<String> collection = new ArrayList<>();
		assertTrue(ObjectUtils.isEmpty(collection));
	}

	@Test
	void testNonEmptyCollection() {
		Collection<String> collection = new ArrayList<>();
		collection.add("Hello");
		assertFalse(ObjectUtils.isEmpty(collection));
	}

	@Test
	void testNullCollection() {
		Collection<String> collection = null;
		assertTrue(ObjectUtils.isEmpty(collection));
	}

	@Test
	void testEmptyMap() {
		Map<String, String> map = new HashMap<>();
		assertTrue(ObjectUtils.isEmpty(map));
	}

	@Test
	void testNonEmptyMap() {
		Map<String, String> map = new HashMap<>();
		map.put("key", "value");
		assertFalse(ObjectUtils.isEmpty(map));
	}

	@Test
	void testNullMap() {
		Map<String, String> map = null;
		assertTrue(ObjectUtils.isEmpty(map));
	}

	@Test
	void testEmptyOptional() {
		Optional<String> optional = Optional.empty();
		assertTrue(ObjectUtils.isEmpty(optional));
	}

	@Test
	void testNonEmptyOptional() {
		Optional<String> optional = Optional.of("value");
		assertFalse(ObjectUtils.isEmpty(optional));
	}

	@Test
	void testNullOptional() {
		Optional<String> optional = null;
		assertTrue(ObjectUtils.isEmpty(optional));
	}

}