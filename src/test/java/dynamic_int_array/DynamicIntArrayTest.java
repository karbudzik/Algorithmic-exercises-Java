package dynamic_int_array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DynamicIntArrayTest {

    @Test
    void should_initialize_array_with_given_size() {
        // given:
        DynamicIntArray array = createArray(11);

        // when:
        String result = " 0 1 2 3 4 5 6 7 8 9 10";

        // then:
        assertEquals(result, array.toString());
    }

    @Test
    void should_throw_IllegalArgumentException_when_given_illegal_size() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicIntArray(-5));
    }

    @Test
    void should_add_new_element_to_array() {
        // given:
        DynamicIntArray array = createArray(11);

        // when:
        array.add(32);
        array.add(42);
        String result = " 0 1 2 3 4 5 6 7 8 9 10 32 42";

        // then:
        assertEquals(result, array.toString());
    }

    @Test
    void should_remove_element_from_array() {
        DynamicIntArray array = createArray(11);
        array.remove(5);
        array.remove(0);
        String result = " 1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void should_remove_last_item_from_array() {
        DynamicIntArray array = createArray(10);
        array.remove(9);
        String result = " 0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void should_throw_ArrayIndexOutOfBoundsException_when_removing_invalid_item() {
        DynamicIntArray array = createArray(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
    }

    @Test
    void should_insert_new_element_into_array() {
        DynamicIntArray array = createArray(11);
        array.insert(8, 223);
//        array.insert(100, 654);

        String result = " 0 1 2 3 4 5 6 7 223 8 9 10";
        assertEquals(result, array.toString());
    }

    private DynamicIntArray createArray(int numOfElements) {
        DynamicIntArray array = new DynamicIntArray();
        for (int i = 0; i < numOfElements; ++i) {
            array.add(i);
        }
        return array;
    }
}
