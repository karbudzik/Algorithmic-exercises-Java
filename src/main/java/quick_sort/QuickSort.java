package quick_sort;

import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {

    }

    public void sort(List<Integer> integerList) {
        if (integerList == null) {
            throw new IllegalArgumentException("List can't be null!");
        }
        if (integerList.size() >= 2) {
            sort(integerList, 0, integerList.size() - 1);
        }
    }

    private void sort(List<Integer> integerList, int left, int right) {
        if (left < right) {
            int pivotIndex = (left + right) / 2;
            int pivot = integerList.get(pivotIndex);
            int index = partition(integerList, left, right, pivot);
            sort(integerList, left, index - 1);
            sort(integerList, index, right);
        }
    }

    private int partition(List<Integer> integerList, int left, int right, int pivot) {
        while (left <= right) {
            while (integerList.get(left) < pivot) {
                left++;
            }
            while (integerList.get(right) > pivot) {
                right--;
            }
            if (left <= right) {
                Collections.swap(integerList, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
