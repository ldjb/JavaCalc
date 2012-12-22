/*******************************************************************************
** RPNcalc.java                                                               **
** -------------------------------------------------------------------------- **
** Java class for calculating mathematical expressions represented in reverse **
** Polish notation (RPN) / postfix notation. The eval() method takes as input **
** an Object array consisting of Double and String elements and returns the   **
** result as a Double.                                                        **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 21 December 2012                                            **
*******************************************************************************/

// import stack class
import java.util.Stack;
public class RPNcalc {
	public static Double eval(Object[] arrInput) {
		// declare stack for storing numerical (Double) values
		Stack<Double> stkNums = new Stack<Double>();
		// iterate over each item (number or symbol) in inputted array
		for (Object i : arrInput) {
			// if item is a number, push to stack
			if (i.getClass().getName() == "java.lang.Double") {
				stkNums.push(new Double(i.toString()));
			}
			// if item is a plus, pop two numbers and push their sum
			else if (i.toString() == "+") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2+var1);
			}
			// if item is a minus, pop two numbers and push their difference
			else if (i.toString() == "-") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2-var1);
			}
			// if item is an asterisk, pop two numbers and push their product
			else if (i.toString() == "*") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2*var1);
			}
			// if item is a slash, pop two numbers and push their quotient
			else if (i.toString() == "/") {
				Double var1 = stkNums.pop();
				Double var2 = stkNums.pop();
				stkNums.push(var2/var1);
			}
		}
		// there should only be one number in the stack -- return it
		return stkNums.pop();
	}
}