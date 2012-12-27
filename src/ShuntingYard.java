/*******************************************************************************
** ShuntingYard.java                                                          **
** -------------------------------------------------------------------------- **
** Implements the shunting-yard algorithm to convert a mathematical           **
** expression from infix notation to postfix notation / reverse Polish        **
** notation (RPN). The convert() method takes as input an Object array        **
** consisting of Double and String elements and returns the result as an      **
** array of the same format.                                                  **
**                                                                            **
** The shunting-yard algorithm was invented by Edsger Dijkstra. It is         **
** explained in detail in Mathematisch Centrum report MR 35:                  **
** <http://www.cs.utexas.edu/~EWD/MCReps/MR35.PDF>                            **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 27 December 2012                                            **
*******************************************************************************/

// import util package
import java.util.*;
public class ShuntingYard {
	public static Object[] convert(Object[] input) {
		// initialise queue and stack used by shunting-yard algorithm
		ArrayList<Object> outputQueue = new ArrayList<Object>();
		Stack<Object> operatorStack = new Stack<Object>();
		// iterate over each item from infix input
		for (Object i : input) {
			// if item is a number, add it to the output queue
			if (i.getClass().getName() == "java.lang.Double") {
				outputQueue.add(i);
			}
			// if left parenthesis, push to operator stack
			else if (i.equals("(")) {
				operatorStack.push(i);
			}
			// if right parenthesis
			else if (i.equals(")")) {
				// until there is a left parenthesis at top of stack,
				// pop operators and push them to the output queue
				while (!operatorStack.peek().equals("(")) {
					outputQueue.add(operatorStack.pop());
				}
				// pop the left parenthesis (do nothing with it)
				operatorStack.pop();
			}
			// if item is an operator
			else {
				while (
!operatorStack.empty() && !operatorStack.peek().equals("(") && (
	(Operator.opAssoc(i).equals("left") &&
	Operator.opPrec(i) <= Operator.opPrec(operatorStack.peek())) ||
	(Operator.opPrec(i) < Operator.opPrec(operatorStack.peek()))
)
				) {
					// pop operator from stack and push to output queue
					outputQueue.add(operatorStack.pop());
				}
				// push current operator to stack
				operatorStack.push(i);
			}
		}
		// while there are operators in the stack, pop them and push to queue
		while (!operatorStack.empty()) {
			outputQueue.add(operatorStack.pop());
		}
		// return output queue as array
		return outputQueue.toArray();
	}
}