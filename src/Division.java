public class Division extends Operator {
	public Division() {
		super.setData(new Object[] {3, "left"});
	}
	public Double operate(Double var1, Double var2) {
		return var1 / var2;
	}
}