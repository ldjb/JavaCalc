/*******************************************************************************
** Calculator.java                                                            **
** -------------------------------------------------------------------------- **
** Contains main() method. Initialises GUI mode if possible, otherwise        **
** interacts with user in CLI mode.                                           **
** -------------------------------------------------------------------------- **
** Developed by Leon Byford <ldjb20@bath.ac.uk>                               **
** Last modified: 1 January 2013                                              **
*******************************************************************************/

// import packages
import java.awt.*;
import java.io.*;
import java.util.*;
public class Calculator {
	// command-line interface (CLI) mode
	private static void cliMode() {
		// BufferedReader for retrieving input from CLI
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		// iterate indefinitely
		while (true) {
			try {
				// retrieve user input
				String input = stdin.readLine();
				if (input.toUpperCase().equals("QUIT")) {
					// if user enters "QUIT" command, break out of loop and quit
					break;
				}
				else if (input.equals("")) {
					// if input is "", continue to next line of input
					continue;
				}
				// determine output
				String output = CalcIO.process(input);
				// if output is null, an error has occurred so display message
				if (output == null) {
					System.err.println("Error. Please try again.");
				}
				else {
					// display output
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
		// if "FORCE-CLI" argument has been used, force CLI mode
		if (args.length > 0 && args[0].toUpperCase().equals("FORCE-CLI")) {
			cliMode();
		}
		else {
			// try to initialise graphical user interface (GUI) mode
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