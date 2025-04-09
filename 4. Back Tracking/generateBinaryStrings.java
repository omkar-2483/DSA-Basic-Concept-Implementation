//generate all possible binary strings of n bit
//backTracking

public class generateBinaryStrings {
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void BinaryStrings(int[] arr,int n) {
		if(n<1) {
			display(arr);
		}else {
			arr[n-1]=0;
			BinaryStrings(arr,n-1);
			arr[n-1]=1;
			BinaryStrings(arr,n-1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[5];
		BinaryStrings(arr,5);
	}
}
