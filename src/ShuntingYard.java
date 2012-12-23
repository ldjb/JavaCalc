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
				System.out.println("operator");
			}
		}
		while (!operatorStack.empty()) {
			outputQueue.add(operatorStack.pop());
		}
		System.out.println(outputQueue);//***
		return outputQueue.toArray();
	}
}