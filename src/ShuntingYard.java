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
** • Communicate with operator objects.                                       **
** • Documentation.                                                           **
*******************************************************************************/

import java.util.*;
public class ShuntingYard {
	public static Object[] convert(Object[] input) {
		ArrayList<Object> outputQueue = new ArrayList<Object>();
		Stack<Object> operatorStack = new Stack<Object>();
		Map<String, Object[]> operatorData = new HashMap<String, Object[]>();
		operatorData.put("*", new Object[] {3, "left"});
		operatorData.put("/", new Object[] {3, "left"});
		operatorData.put("+", new Object[] {2, "left"});
		operatorData.put("-", new Object[] {2, "left"});
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
				while (!operatorStack.empty() &&
					   !operatorStack.peek().equals("(") &&
					   ((operatorData.get(i)[1].equals("left") &&
					   Integer.parseInt(operatorData.get(i)[0].toString()) <=
					   Integer.parseInt(operatorData.get(
					   operatorStack.peek())[0].toString())) ||
					   (Integer.parseInt(operatorData.get(i)[0].toString()) <
					   Integer.parseInt(operatorData.get(
					   operatorStack.peek())[0].toString())))) {
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