/*******************************************************************************
** Operator.java                                                              **
** -------------------------------------------------------------------------- **
** Superclass for mathematical operators (e.g. addition, subtraction,         **
** multiplication and division). Holds fields relating to each operator's     **
** precedence and associativity.                                              **
**                                                                            **
** Public static methods:                                                     **
** • private static Operator getOperator(String input)                        **
**   - Returns an Operator subclass object based on the String input.         **
**   - Example usage:                                                         **
**     Operator.getOperator("+"); // returned: new Addition()                 **
**                                                                            **
** • public static int opPrec(Object input)                                   **
**   - Returns the precedence of the specified operator. input.toString()     **
**     should return the operator's symbol as a String for this method to     **
**     work.                                                                  **
**   - Example usage:                                                         **
**     Operator.opPrec("+"); // returned: int 2                               **
**                                                                            **
** • public static String opAssoc(Object input)                               **
**   - Returns the associativity of the specified operator.                   **
**     input.toString() should return the operator's symbol as a String for   **
**     this method to work.                                                   **
**   - Example usage:                                                         **
**     Operator.opAssoc("+"); // returned: String "left"                      **
**                                                                            **
** • public static Double operate(String operator, Double var1, Double var2)  **
**   - Returns the result of the specified operator performed on var1 and     **
**     var2.                                                                  **
**   - Example usage:                                                         **
**     Operator.operate("+", 2.1, 4.7); // returned: Double 6.8               **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 27 December 2012                                            **
*******************************************************************************/

public class Operator {
	private int precedence;
	private String associativity;
	// allow data for Operators to be set
	public void setData(Object[] input) {
		precedence = new Integer(input[0].toString());
		associativity = input[1].toString();
	}
	// return Operators based on symbols
	private static Operator getOperator(String input) {
		if (input.equals("+")) {
			return new Addition();
		}
		else if (input.equals("-")) {
			return new Subtraction();
		}
		else if (input.equals("*")) {
			return new Multiplication();
		}
		else if (input.equals("/")) {
			return new Division();
		}
		//else if (input.equals("^")) {
		//	return new Exponentiation();
		//}
		return null;
	}
	// get data for a particular Operator
	private Object[] getData() {
		return new Object[] {precedence, associativity};
	}
	// get precedence for an Operator
	public static int opPrec(Object input) {
		return
		new Integer(getOperator(input.toString()).getData()[0].toString());
	}
	// get associativity for an Operator
	public static String opAssoc(Object input) {
		return getOperator(input.toString()).getData()[1].toString();
	}
	// call operate() method of requested Operator
	public static Double operate(String operator, Double var1, Double var2) {
		return getOperator(operator).operate(var1, var2);
	}
	// dummy method overridden by subclasses
	public Double operate(Double var1, Double var2) {
		return null;
	}
}