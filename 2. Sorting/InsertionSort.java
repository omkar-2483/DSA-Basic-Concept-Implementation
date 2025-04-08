public class InsertionSort {
    // pick element from unsorted part and push it in proper position in sorted part
    // initialy, sorted part is of size 1
    public static void sort(int[] arr){
        int n=arr.length;
        for(int i=1; i<n; i++){ //pick arr[i] from unsorted part 
            int curr = arr[i];
            int j=i-1;
            while(j>=0 && arr[j] > curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,5,292,333,2345,1223,432,-3234,-12,-28,0,6,5,6,10,12,4};
        System.out.println("Original Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }

        sort(arr);
        System.out.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }
    }
}
