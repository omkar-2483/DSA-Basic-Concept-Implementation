import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfix {
	private static void infixToPostfix(String s) {
		ArrayList<Character> ans=new ArrayList<Character>();
		Stack<Character> st=new Stack<Character>();
		for(char c:s.toCharArray()) {
			if(Character.isLetterOrDigit(c)) {
				ans.add(c);
			}else if(c=='('){
				st.push(c);
			}else if(c==')') {
				while(!st.isEmpty() && st.peek()!='('){
					ans.add(st.pop());
				}
				st.pop();
			}else {
				while(!st.isEmpty() && precedance(c)<=precedance(st.peek())) {
						ans.add(st.pop());
				}
				st.push(c);
			}
		}
		while(!st.isEmpty()) {
			ans.add(st.pop());
		}
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i));
		}
	}
	
	private static int precedance(char operator) {
		switch(operator){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}
	
	public static void main(String[] args) {
		String str=new String("(A+B)*(C+D)");
		infixToPostfix(str);
	}
}
