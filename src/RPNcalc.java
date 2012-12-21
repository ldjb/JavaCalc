import java.util.*;

public class RPNcalc {
	public static Double eval(Object[] arrInput) {
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
		return stkNums.pop();
	}
}