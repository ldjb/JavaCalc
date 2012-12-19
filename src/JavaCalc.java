import java.io.*;
import java.util.*;

public class JavaCalc {
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String input = stdin.readLine();
// 		Double output = new Double(input) + 3.2;
// 		System.out.println(output);
		
		char[] arrInput = input.toCharArray();
		Stack<Double> stkNums = new Stack<Double>();
		for (char i : arrInput) {
			if (Character.isDigit(i)) {
				stkNums.push(new Double(Character.getNumericValue(i)));
			}
			else if (i == '+') {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2+var1);
			}
			else if (i == '-') {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2-var1);
			}
			else if (i == '*') {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2*var1);
			}
			else if (i == '/') {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2/var1);
			}
		}
		System.out.println(stkNums.pop());
	}
}