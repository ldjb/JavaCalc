/*************************************************
** RPNcalc.java                                 **
** -------------------------------------------- **
** Java class for calculating mathematical      **
** expressions represented in reverse Polish    **
** notation (RPN) / postfix notation. The       **
** eval() method takes as input an Object array **
** consisting of Double and String elements and **
** returns the result as a Double.              **
** -------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk> **
** Last modified: 21 December 2012              **
*************************************************/

// import stack class
import java.util.Stack;
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