/*******************************************************************************
** CalcIO.java                                                                **
** -------------------------------------------------------------------------- **
** Relays data between the interface (CLI or GUI) and other components of the **
** system. The process() method takes a String as input, then returns the     **
** result of the calculation. If the calculation is not possible, null is     **
** returned.                                                                  **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 31 December 2012                                            **
*******************************************************************************/

public class CalcIO {
	// result: stores result before rounding
	private static Double result = 0d;
	// storedVal: value stored using "STORE" command
	private static Double storedVal = 0d;
	public static String process(String input) {
		try {
			// if user has entered "STORE" command
			if (input.toUpperCase().equals("STORE")) {
				storedVal = result;
				return "Stored. \"VAR\" will be substituted with result.";
			}
			// if input is blank
			else if (input.equals("")) {
				return "";
			}
			else {
				// calculate expression and determine result
				result = RPNcalc.eval(ShuntingYard.convert(StringParser.parse(
						 input.replaceAll("(?i)VAR", storedVal.toString()))));
				// round the result to nine decimal places;
				// counteract floating-point arithmetic errors
				Double output = Math.round(result*1.0e9d)/1.0e9d;
				// if result is an integer
				if (Math.round(result) == output) {
					// return result in integer form (without decimal value)
					return Integer.toString(output.intValue());
				}
				else {
					// return result in decimal form
					return output.toString();
				}
			}
		}
		catch (NullPointerException e) {
			// occurs if input is invalid -- null is returned
		}
		// return null if error occurs
		return null;
	}
}