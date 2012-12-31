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
** • Extension.txt.                                                           **
** • Documentation.                                                           **
*******************************************************************************/

import java.awt.*;
import java.io.*;
import java.util.*;
public class Calculator {
	private static void cliMode() {
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		while (true) {
			try {
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
			catch (IOException e) {
				// in theory should never occur
				continue;
			}
			catch (NullPointerException e) {
				// should only occur when Ctrl+D is pressed, in which case the
				// program should quit
				break;
			}
		}
	}
	public static void main(String[] args) {
		if (args.length > 0 && args[0].toUpperCase().equals("FORCE-CLI")) {
			cliMode();
		}
		else {
			try {
				CalcGUI.initAll();
			}
			catch (HeadlessException e) {
				// if GUI not possible, resort to command-line mode
				cliMode();
			}
		}
	}
}