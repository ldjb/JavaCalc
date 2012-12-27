public class Addition extends Operator {
	public Addition() {
		super.setData(new Object[] {2, "left"});
	}
	public Double operate(Double var1, Double var2) {
		return var1 + var2;
	}
}