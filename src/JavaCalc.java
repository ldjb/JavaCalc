import java.io.*;
import java.util.*;

public class JavaCalc {
	public static void main(String[] args) throws IOException, NumberFormatException{
		//BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		//String input = stdin.readLine();
		//char[] arrInput = input.toCharArray();
		Object[] arrInput = {1.3, 0.9, "-", 0.5, "*"};
		Stack<Double> stkNums = new Stack<Double>();
		for (Object i : arrInput) {
			if (i.getClass().getName() == "java.lang.Double") {
				stkNums.push(new Double(i.toString()));
			}
			else if (i.toString() == "+") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2+var1);
			}
			else if (i.toString() == "-") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2-var1);
			}
			else if (i.toString() == "*") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2*var1);
			}
			else if (i.toString() == "/") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2/var1);
			}
		}
		System.out.println(stkNums.pop());
	}
}