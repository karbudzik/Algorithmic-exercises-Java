package merge_sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void initialize() {
        this.mergeSort = new MergeSort();
    }

    @Test
    public void should_sort_array_properly_when_arr_length_is_even() {
        // given:
        int[] arr = {40, 40, 12, 1, 5, 0, 19, 3};

        // when:
        mergeSort.mergeSort(arr);
        int[] expected = {0, 1, 3, 5, 12, 19, 40, 40};

        // then:
        assertArrayEquals(expected, arr);
    }

    @Test
    public void should_sort_array_properly_when_arr_length_is_odd() {
        // given:
        int[] arr = {40, 40, 12, 5, 0, 19, 3};

        // when:
        mergeSort.mergeSort(arr);
        int[] expected = {0, 3, 5, 12, 19, 40, 40};

        // then:
        assertArrayEquals(expected, arr);
    }

    @Test
    public void should_sort_properly_when_numbers_below_zero() {
        // given:
        int[] arr = {-40, -40, -12, -5, -19, -3};

        // when:
        mergeSort.mergeSort(arr);
        int[] expected = {-40, -40, -19, -12, -5, -3};

        // then:
        assertArrayEquals(expected, arr);
    }

    @Test
    public void should_not_change_already_sorted_array() {
        // given:
        int[] arr = {-3, -2, -1, 0, 1, 2, 3};

        // when:
        mergeSort.mergeSort(arr);
        int[] expected = {-3, -2, -1, 0, 1, 2, 3};

        // then:
        assertArrayEquals(expected, arr);
    }

    @Test
    public void should_do_nothing_if_array_is_empty() {
        // given:
        int[] arr = {};
        int[] arrWithSize = new int[4];

        // when:
        mergeSort.mergeSort(arr);
        mergeSort.mergeSort(arrWithSize);
        int[] expected = {};
        int[] expectedWithSize = new int[4];

        // then:
        assertArrayEquals(expected, arr);
        assertArrayEquals(expectedWithSize, arrWithSize);
    }
}
