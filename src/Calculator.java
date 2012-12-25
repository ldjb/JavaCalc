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
** • Objectify operators.                                                     **
** • Implement a graphical user interface.                                    **
** • Implement capability to store results for further computations.          **
** • Documentation.                                                           **
*******************************************************************************/

import java.io.*;
import java.util.*;
public class Calculator {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		while (true) {
			try {
				String input = stdin.readLine();
				if (input.toUpperCase().equals("QUIT")) {
					break;
				}
				Double unrounded = RPNcalc.eval(ShuntingYard.convert(
								   StringParser.parse(input)));
				Double rounded = Math.round(unrounded*1000000000)/1000000000.0;
				if (Math.round(unrounded) == rounded) {
					System.out.println(rounded.intValue());
				}
				else {
					System.out.println(rounded);
				}
			}
			catch (Exception e) {
				System.err.println("Error. Please try again.");
			}
		}
	}
}