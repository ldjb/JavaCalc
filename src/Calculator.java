//import java.io.*;
//import java.util.*;

public class Calculator {
	public static void main(String[] args) {
		//BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		//String input = stdin.readLine();
		//char[] arrInput = input.toCharArray();
		Object[] arrInput = {-5.0, 3.0, "+"};
		System.out.println(RPNcalc.eval(arrInput));
	}
}