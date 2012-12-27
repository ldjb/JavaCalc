public class Multiplication extends Operator {
	public Multiplication() {
		super.setData(new Object[] {3, "left"});
	}
	public Double operate(Double var1, Double var2) {
		return var1 * var2;
	}
}