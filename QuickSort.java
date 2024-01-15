package ass12;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {12, 4, 5, 6, 7, 3, 1, 15};

        System.out.println("Original array:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\nSorted array:");
        printArray(numbers);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            System.out.println("After partitioning with pivot " + arr[pivotIndex] + ":");
            printArray(arr);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}