import java.util.*;

public class ParenthesisCheck {
	public static void checkParenthesis(String s) {
		Stack<Character> st=new Stack<Character>();
		for(char c: s.toCharArray()) {
			if(c=='(') {
				st.push(')');
			}else if(!st.isEmpty()&& st.peek()==c) {
				st.pop();
			}else {
				System.out.println("Input string is invalid parenthesis pattern");
				return;
			}
		}
		if(st.isEmpty()) {
			System.out.println("Input string is valid parenthesis pattern");
		}else {
			System.out.println("Input string is invalid parenthesis pattern");
		}
	}
	public static void main(String[] args) {
		String str=new String("())()()");
		checkParenthesis(str);
	}
}
