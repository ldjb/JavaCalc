/*******************************************************************************
** Calculator.java [work in progress]                                         **
** -------------------------------------------------------------------------- **
** Contains main() method and communicates with the other components of the   **
** program.                                                                   **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: •••                                                         **
** -------------------------------------------------------------------------- **
** [To do]                                                                    **
** • Implement a graphical user interface.                                    **
** • Divide by zero.
** • Do I really need "throws IOException"?                                   **
** • Double unrounded = 0d; Double result = 0d; -- need private/public?       **
** • Extension.txt.                                                           **
** • Documentation.                                                           **
*******************************************************************************/

import java.io.*;
import java.util.*;
public class Calculator {
	/*public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		Double unrounded = 0d;
		Double result = 0d;
		while (true) {
			try {
				String input = stdin.readLine();
				if (input.toUpperCase().equals("QUIT")) {
					break;
				}
				if (input.toUpperCase().equals("STORE")) {
					result = unrounded;
					System.out.println("Result stored. The string \"VAR\" will"+
									   " be substituted with this result.");
				}
				else if (!input.equals("")) {
					unrounded = RPNcalc.eval(ShuntingYard.convert(
								StringParser.parse(
								input.replaceAll("(?i)VAR",
												 result.toString()))));
					Double rounded = Math.round(unrounded*1000000000)/
									 1000000000.0;
					if (Math.round(unrounded) == rounded) {
						System.out.println(rounded.intValue());
					}
					else {
						System.out.println(rounded);
					}
				}
			}
			catch (Exception e) {
				System.err.println("Error. Please try again.");
			}
		}
	}*/
	public static void main(String[] args) throws IOException {
		CalcGUI.initAll();
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		while (true) {
			System.out.println(CalcIO.process(stdin.readLine()));
		}
		
	}
}