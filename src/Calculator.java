import java.io.*;
import java.util.*;

public class Calculator {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = stdin.readLine();
			//char[] arrInput = input.toCharArray();
			//Object[] arrInput = {-5.0, 3.0, "+"};
			//System.out.println(RPNcalc.eval(arrInput));
			ArrayList<Object> arrInput = new ArrayList<Object>();
			for (char i : input.toCharArray()) {
				if (Character.isDigit(i)) {
					arrInput.add(new Double(Character.getNumericValue(i)));
				}
				else {
					arrInput.add(Character.toString(i));
				}
			}
			System.out.println(RPNcalc.eval(arrInput.toArray()));
		}
	}
}