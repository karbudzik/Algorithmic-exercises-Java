package dynamic_int_array;

public class DynamicIntArray {
    private final int DEFAULT_INITIALIZATION_SIZE = 0;

    private int[] elements;
    private int size;

    public DynamicIntArray() {
        this.elements = new int[DEFAULT_INITIALIZATION_SIZE];
        this.size = DEFAULT_INITIALIZATION_SIZE;
    }

    public DynamicIntArray(int size) {
        if (size >= 0) {
            this.elements = new int[size];
            this.size = size;
        } else {
            throw new IllegalArgumentException("Capacity of Dynamic Int Array can't be smaller than 0");
        }
    }

    public void add(int elem) {
        int[] newArray = new int[size + 1];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
        newArray[this.elements.length] = elem;
        this.elements = newArray;
        size++;
    }

    public void remove(int index) {
        int[] newArray = new int[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (i != index) {
                newArray[j++] = this.elements[i];
            }
        }
        this.elements = newArray;
        size--;
    }

    public void insert(int index, int elem) {
        int[] newArray = new int[size + 1];
        if (index >= size) {
            add(elem);
        }
        int j = 0;
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                newArray[i] = elem;
            } else {
                newArray[i] = this.elements[j];
                j++;
            }
        }
        this.elements = newArray;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : elements) {
            sb.append(" ").append(i);
        }
        return sb.toString();
    }
}
