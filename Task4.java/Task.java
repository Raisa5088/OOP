package Task4.java;

public class Task {
    static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T oneVal = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = oneVal;
    }
}

static void swapObj(Object[] array, int firstIndex, int secondIndex) {
    Object oneVal = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = oneVal;
}

static <T> ArrayList<T> convertToList(T[] array) {
    return new ArrayList<>(Arrays.asList(array));
}
