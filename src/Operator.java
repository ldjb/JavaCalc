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
	public static Operator getOperator(String input) {
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
		return null;
	}
	public Object[] getData() {
		return new Object[] {precedence, associativity};
	}
	public static Object[] opData(String input) {
		return getOperator(input).getData();
	}
}