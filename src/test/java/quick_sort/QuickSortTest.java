package quick_sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    void should_throw_IllegalArgumentException_when_given_null() {
        // given:
        QuickSort quickSort = new QuickSort();
        // then:
        assertThrows(IllegalArgumentException.class, ()-> quickSort.sort(null));
    }

    @Test
    void should_sort_odd_list_with_unique_values_correctly() {
        // given:
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = Arrays.asList(5, 3, 1, 12, 9);
        // when:
        quickSort.sort(toSort);
        List<Integer> expected = Arrays.asList(1, 3, 5, 9, 12);
        // then:
        assertIterableEquals(expected, toSort);
    }

    @Test
    void should_sort_odd_list_with_duplicate_values_correctly() {
        // given:
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = Arrays.asList(5, 3, 1, 5, 5);
        // when:
        quickSort.sort(toSort);
        List<Integer> expected = Arrays.asList(1, 3, 5, 5, 5);
        // then:
        assertIterableEquals(expected, toSort);
    }

    @Test
    void should_sort_even_list_with_duplicate_values_correctly() {
        // given:
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = Arrays.asList(5, 77, 12, 5, 5, 100, -3, -100);
        // when:
        quickSort.sort(toSort);
        List<Integer> expected = Arrays.asList(-100, -3, 5, 5, 5, 12, 77, 100);
        // then:
        assertIterableEquals(expected, toSort);
    }

    @Test
    void should_not_change_list_when_only_one_element() {
        // given:
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = Arrays.asList(2);
        // when:
        quickSort.sort(toSort);
        List<Integer> expected = Arrays.asList(2);
        // then:
        assertIterableEquals(expected, toSort);
    }

    @Test
    void should_not_change_list_when_no_elements_in_list() {
        // given:
        QuickSort quickSort = new QuickSort();
        List<Integer> toSort = new ArrayList<>();
        // when:
        quickSort.sort(toSort);
        // then:
        assertEquals(0, toSort.size());
    }
}
