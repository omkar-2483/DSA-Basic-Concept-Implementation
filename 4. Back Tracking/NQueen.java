//place n queens on N*N chess board such that all queens are safe
//Algorithms:
//check column/row wise i.e place first queen at arr[0][0]
//check second queen position in arr[0][1],arr[1][1],arr[2][1]...second placed at arr[2][1]
//place third queen in third row and so on
//if all queens place print solution else backtrack and change position of most recent queen 

import java.util.*;


public class NQueen {
	public static  List<List<String>> solveQueen(int n){
		List<List<String>> allboards=new ArrayList<>();
		char[][] board=new char[n][n];
		helper(board,allboards,0); //start placing from column 1
		
		return allboards;
	}
	
	private static void helper(char[][] board,List<List<String>> allboards,int col) {
		//base condition when all placements are correct
		if(col==board.length) {
			saveboard(board,allboards);
			return;
		}
		
		for(int i=0;i<board.length;i++) {
			//check for all rows in current column
			if(isSafe(board,i,col)) {
				board[i][col]='Q';
				helper(board,allboards,col+1);
				board[i][col]='.'; //if backtracking due to wrong placement
			}
		}
	}
	private static void saveboard(char[][] board,List<List<String>> allboards) {
		List<String> newBoard=new ArrayList<>();
		String row="";
		for(int i=0;i<board.length;i++) {
			row="";
			for(int j=0;j<board.length;j++) {
				if(board[i][j]=='Q') {
					row+='Q';
				}else {
					row+='.';
				}
			}
			newBoard.add(row);
		}
		allboards.add(newBoard);
	}
		
	private static boolean isSafe(char[][] board,int row,int col) {
		//horizontal check
		for(int i=0;i<board.length;i++) {
			if(board[row][i]=='Q')
				return false;
		}
		
		//vertical check
		for(int i=0;i<board.length;i++) {
			if(board[i][col]=='Q')
				return false;
		}
		
//		upper left check
		int r=row;
		for(int c=col; c>=0 && r>=0;r--,c--) {
			if(board[r][c]=='Q')
				return false;
		}
//		upper right check
		r=row;
		for(int c=col; c<board.length && r>=0;r--,c++) {
			if(board[r][c]=='Q')
				return false;
		}
//		lower left check
		r=row;
		for(int c=col; c>=0 && r<board.length;r++,c--) {
			if(board[r][c]=='Q')
				return false;
		}
//		upper right check
		r=row;
		for(int c=col; c<board.length && r<board.length;r++,c++) {
			if(board[r][c]=='Q')
				return false;
		}
		
		return true;
	}
	
	
	//main
	public static void main(String[] args) {
		List<List<String>> solution=new ArrayList<>();
		solution=solveQueen(4);
		for(int i=0;i<solution.size();i++) {
			System.out.print("Solution no."+(i+1)+"==>[");
			for(int j=0;j<(solution.get(i)).size();j++) {
				System.out.print('[');
				System.out.print(solution.get(i).get(j)+"],");
			}
			System.out.println(']');
		}
	}

}
