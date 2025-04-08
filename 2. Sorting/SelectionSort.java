public class SelectionSort {

    //find largest element and swap with last
    public static void sort(int[] arr){
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int maxId=0;
            for(int j=1; j<=n-1-i; j++){
                if(arr[j] >= arr[maxId]) maxId=j;
            }
            //swap
            int temp=arr[maxId];
            arr[maxId]= arr[n-1-i];
            arr[n-1-i]=temp;
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
