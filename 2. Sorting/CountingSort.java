public class CountingSort {
    // when 0 <= arr[i] <100
    public static void countSort(int[] arr){
        int[] count = new int[100];
        for(int i: arr){
            count[i]++;
        }

        int id=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<count[i]; j++){
                arr[id]=i;
                id++;
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {3,5,2,3,45,23};
        System.out.println("Original Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }

        countSort(arr);
        System.out.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }
    }
}
