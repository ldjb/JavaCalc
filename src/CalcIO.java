public class CalcIO {
	private static Double unrounded = 0d;
	private static Double result = 0d;
	public static String process(String input) {
		try {
			if (input.toUpperCase().equals("STORE")) {
				result = unrounded;
				return "Stored. \"VAR\" will be substituted with result.";
			}
			else if (input.equals("")) {
				return "";
			}
			else {
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
		catch (NullPointerException e) {
		}
		return null;
	}
}