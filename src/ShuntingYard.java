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
		System.out.println(outputQueue);//***
		return outputQueue.toArray();
	}
}