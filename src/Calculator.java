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
** • Ctrl+D                                                                   **
** • Divide by zero.                                                          **
** • Do I really need "throws IOException"?                                   **
** • Extension.txt.                                                           **
** • Documentation.                                                           **
*******************************************************************************/

import java.io.*;
import java.util.*;
public class Calculator {
	private static void cliMode() throws IOException {
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		while (true) {
			String input = stdin.readLine();
			if (input.toUpperCase().equals("QUIT")) {
				break;
			}
			else if (input.equals("")) {
				continue;
			}
			String output = CalcIO.process(input);
			if (output == null) {
				System.err.println("Error. Please try again.");
			}
			else {
				System.out.println(output);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		if (args.length > 0 && args[0].toUpperCase().equals("FORCE-CLI")) {
			cliMode();
		}
		else {
			try {
				CalcGUI.initAll();
			}
			catch (Exception e) {
				cliMode();
			}
		}
	}
}