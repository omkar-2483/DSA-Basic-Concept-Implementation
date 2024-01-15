package ass3a;

import java.util.Scanner;

class Sparse
{
	public int row;
	public int column;
	public int value;
	
	public static Sparse[] fastTranspose(Sparse A[])
	{
		Sparse[] B=new Sparse[A.length];
		//initializing b
		for(int i=0;i<A.length;i++)
		{
			B[i]=new Sparse();
		}
		
		int row_terms[]=new int[(A[0].column)];      /*to store no of elements in an column*/
		int starting_pos[]=new int[(A[0].column)];    /*to store starting position of each
		                                             row in transpose matrix*/
		int no_col=A[0].column;
		int no_terms=A[0].value;
		B[0].row=A[0].column;
		B[0].column=A[0].row;
		B[0].value=A[0].value;
		
		for(int i=0;i<no_col;i++)
		{
			row_terms[i]=0;   //initializing row_terms[]
		}
		for(int i=1;i<=no_terms;i++)
		{
			row_terms[A[i].column]++;    /*for each element in a column A[i].column 
			                             of original matrix row_terms of that column 
			                             is incremented*/ 
		}
		starting_pos[0]=1;
		for(int i=1;i<no_col;i++)
		{
			starting_pos[i]=starting_pos[i-1]+row_terms[i-1];  //staring position of each column 
		}
		//storing data
		for(int i=1;i<=no_terms;i++)
		{
			int location=starting_pos[A[i].column];
			B[location].row=A[i].column;
			B[location].column=A[i].row;
			B[location].value=A[i].value;
			starting_pos[A[i].column]++;
		}
		
		return B;
		
	}
	
	//function to show sparse matrix
	public static void showMatrix(Sparse A[])
	{
		System.out.println("sparse matrix : ");
		System.out.println("rows columns values");
		for(int i=0;i<=A[0].value;i++)
		{
			System.out.print("  "+A[i].row+"  ");
			System.out.print("  "+A[i].column+"  ");
			System.out.print("  "+A[i].value+"  ");
			System.out.println();
		}
	}
}

public class FastTranspose {
	public static void main(String[] args) {

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
		Sparse[] sparseA=new Sparse[elements+1];
		//initializing array
		for(int i=0;i<=elements;i++)
		{
			sparseA[i]=new Sparse();
		}
		
		sparseA[0].row=rows;
		sparseA[0].column=colums;
		sparseA[0].value=elements;
		
		int elem=1;
		for(int i=0;i<rows;i++)
			for(int j=0;j<colums;j++) 
			{
				if(A[i][j]!=0)
				{
					sparseA[elem].row=i;
					sparseA[elem].column=j;
					sparseA[elem].value=A[i][j];
					elem++;
				}
			}
		
		//printing sparse matrix
		Sparse.showMatrix(sparseA);
		
		//fast transpose
		Sparse[] transA=Sparse.fastTranspose(sparseA);
		
		//print transpose matrix
		System.out.print("transverse ");
		Sparse.showMatrix(transA);
		
		
	}

}
