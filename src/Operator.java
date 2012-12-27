/*******************************************************************************
** Operator.java                                                              **
** -------------------------------------------------------------------------- **
** […]                                                                        **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: •••                                                         **
** -------------------------------------------------------------------------- **
** [To do]                                                                    **
** • Documentation.                                                           **
*******************************************************************************/

public class Operator {
	private int precedence;
	private String associativity;
	public void setData(Object[] input) {
		precedence = new Integer(input[0].toString());
		associativity = input[1].toString();
	}
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
	private Object[] getData() {
		return new Object[] {precedence, associativity};
	}
	public static int opPrec(Object input) {
		return
		new Integer(getOperator(input.toString()).getData()[0].toString());
	}
	public static String opAssoc(Object input) {
		return getOperator(input.toString()).getData()[1].toString();
	}
	public static Double operate(String operator, Double var1, Double var2) {
		return getOperator(operator).operate(var1, var2);
	}
	public Double operate(Double var1, Double var2) {
		return null;
	}
}