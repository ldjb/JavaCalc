public class CalcIO {
	private static Double unrounded = 0d;
	private static Double result = 0d;
	public static String process(String input) {
		try {
			if (input.toUpperCase().equals("STORE")) {
				result = unrounded;
				return "Result stored. The string \"VAR\" will be substituted "+
					   "with this result.";
			}
			else if (!input.equals("")) {
				unrounded = RPNcalc.eval(ShuntingYard.convert(
							StringParser.parse(
							input.replaceAll("(?i)VAR",
											 result.toString()))));
				Double rounded = Math.round(unrounded*1000000000)/
								 1000000000.0;
				if (Math.round(unrounded) == rounded) {
					return Integer.toString(rounded.intValue());
				}
				else {
					return rounded.toString();
				}
			}
		}
		catch (Exception e) {
			System.err.println("Error. Please try again.");
		}
		return null;
	}
}