//input without scanner
package DSA;	
import java.io.*;

public class InputString {
	public static String getString() throws IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
	public static char getChar() throws IOException
	{
		System.out.println("Enter a character: ");
	    String s = getString();
	    return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		System.out.println("Enter a Integer: ");
	    String s = getString();
	    return Integer.parseInt(s);
	}
	
	public static double getDouble() throws IOException
	{
		System.out.println("Enter a Double value: ");
	    String s = getString();
	    Double aDub = Double.valueOf(s);
	    return aDub.doubleValue();
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("Enter a string: ");
		System.out.println(getString());
		System.out.println(getChar());
		System.out.println(getInt());
		System.out.println(getDouble());
	}
}
