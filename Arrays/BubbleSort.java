package ass11;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[]= {1,4,6,2,7,4,9};
		System.out.println("Original array is: ");
		display(arr);
		int n=arr.length;
        int i, j, temp;
        boolean swapped;
        System.out.println("All steps: ");
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                      
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    display(arr);
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        System.out.println("final array: ");
        display(arr);
    }
	
	static void display(int arr[]) {
		System.out.print("[ ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}

}
