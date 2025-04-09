//Arrange "ABC" in all possible sequence
public class Permutations {
	public static void backtracking(String str,String perm) {
		if(str.length()==0) {
			System.out.println(perm);
			return;
		}
		for(int i=0;i<str.length();i++) {
			char currentChar=str.charAt(i); //for each character
			String newStr=str.substring(0,i)+str.substring(i+1); //string without character at i
			backtracking(newStr,perm+currentChar);
		}
	}
	
	public static void main(String[] args) {
		String str=new String("ABC");
		backtracking(str,"");
	}
}
