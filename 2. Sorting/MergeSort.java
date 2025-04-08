public class MergeSort {
    //divide and conquer
    public static void mergeSort(int[] arr, int start, int end){
        //base condition
        if(start >=end) return;

        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end){
        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];
        int i, j, k=0;
        for(i=start; i<=mid; i++) left[k++]=arr[i];
        k=0;
        for(j=mid+1; j<=end; j++) right[k++]=arr[j];

        k=start;
        i=j=0;
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]) arr[k++]=left[i++];
            else arr[k++]=right[j++];
        }
        
        while (i < left.length) {
            arr[k++]=left[i++];
        }
        while (j < right.length) {
            arr[k++]=right[j++];
        }
    }


    public static void main(String[] args){
        int[] arr = {3,5,292,333,2345,1223,432,-3234,-12,-28,0,6,5,6,10,12,4};
        System.out.println("Original Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }

        mergeSort(arr, 0, arr.length-1);
        System.out.println("\nSorted Array: ");
        for (int i : arr) {
            System.err.print(i+", ");
        }
    }
}
