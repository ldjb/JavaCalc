/*******************************************************************************
** ShuntingYard.java [work in progress]                                       **
** -------------------------------------------------------------------------- **
** Implements the shunting-yard algorithm to convert a mathematical           **
** expression from infix notation to postfix notation / reverse Polish        **
** notation (RPN). The convert() method takes as input an Object array        **
** consisting of Double and String elements and returns the result as an      **
** array of the same format.                                                  **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: •••                                                         **
** -------------------------------------------------------------------------- **
** [To do]                                                                    **
** • Documentation.                                                           **
*******************************************************************************/

import java.util.*;
public class ShuntingYard {
	public static Object[] convert(Object[] input) {
		ArrayList<Object> outputQueue = new ArrayList<Object>();
		Stack<Object> operatorStack = new Stack<Object>();
		for (Object i : input) {
			if (i.getClass().getName() == "java.lang.Double") {
				outputQueue.add(i);
			}
			else if (i.equals("(")) {
				operatorStack.push(i);
			}
			else if (i.equals(")")) {
				while (!operatorStack.peek().equals("(")) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.pop();
			}
			else {
				while (
!operatorStack.empty() && !operatorStack.peek().equals("(") && (
	(Operator.opAssoc(i).equals("left") &&
	Operator.opPrec(i) <= Operator.opPrec(operatorStack.peek())) ||
	(Operator.opPrec(i) < Operator.opPrec(operatorStack.peek()))
)
				) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.push(i);
			}
		}
		while (!operatorStack.empty()) {
			outputQueue.add(operatorStack.pop());
		}
		return outputQueue.toArray();
	}
}