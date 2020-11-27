package merge_sort;

public class MergeSort {
    private int[] temp;

    public void mergeSort(int[] arr) {
        this.temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(arr, startIndex, middleIndex);
            mergeSort(arr, middleIndex + 1, endIndex);
            mergeHalves(arr, startIndex, endIndex);
        }
    }

    private void mergeHalves(int[] arr, int startIndex, int endIndex) {
        int size = endIndex - startIndex + 1;
        int middleIndex = (startIndex + endIndex) / 2;
        int leftStart = startIndex;
        int rightStart = middleIndex + 1;

        int index = leftStart;

        while (leftStart <= middleIndex && rightStart <= endIndex) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[index] = arr[leftStart];
                leftStart++;
            } else {
                temp[index] = arr[rightStart];
                rightStart++;
            }
            index++;
        }

        System.arraycopy(arr, leftStart, temp, index, middleIndex - leftStart + 1);
        System.arraycopy(arr, rightStart, temp, index, endIndex - rightStart + 1);
        System.arraycopy(temp, startIndex, arr, startIndex, size);
    }
}
