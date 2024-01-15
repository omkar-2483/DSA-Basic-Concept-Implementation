package ass3;

import java.util.Scanner;
public class SparseMatrix {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int rows,colums;
		System.out.println("Enter number of rows of original marix : ");
		rows=sc.nextInt();
		System.out.println("Enter number of columns of original marix : ");
		colums=sc.nextInt();
		int[][] A=new int[rows][colums];
		
		
	    System.out.println("Enter elements of matrix one by one");
	    for(int i=0;i<rows;i++)
	    {
	    	for (int j=0;j<colums;j++)
	    	{
	    		System.out.println("Enter a number: ");
	    		A[i][j]=sc.nextInt();
	    	}
	    	
	    }
	    //print original matrix
	    
	    System.out.println("original matrix : ");
	    for(int i=0;i<rows;i++)
	    {
	    	for(int j=0;j<colums;j++)
	    		{System.out.print(A[i][j]+" ");}
	    	System.out.println();
	    }
	    
	    //converting to sparse matrix
	    
	    int elements=0;
	    for(int i=0;i<rows;i++)
	    	for(int j=0;j<colums;j++)
	    	{
	    		if(A[i][j]!=0) {
	    			elements++;
	    		}
	    	}
		int sparseA[][]=new int[elements+1][3];
		sparseA[0][0]=rows;
		sparseA[0][1]=colums;
		sparseA[0][2]=elements;
		int elem=1;
		for(int i=0;i<rows;i++)
			for(int j=0;j<colums;j++) 
			{
				if(A[i][j]!=0)
				{
					sparseA[elem][0]=i;
					sparseA[elem][1]=j;
					sparseA[elem][2]=A[i][j];
					elem++;
				}
			}
		
		//print sparse matrix
		
		System.out.println("sparse matrix : ");
		System.out.println("rows columns value");
		for(int i=0;i<=elements;i++)
		{
			for(int j=0;j<3;j++)
			{System.out.print("  "+sparseA[i][j]+"  ");}
			System.out.println();
		}
		
	}

}
