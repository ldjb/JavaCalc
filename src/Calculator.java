import java.io.*;
public class Calculator {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(
							   new InputStreamReader(System.in));
		while (true) {
			String input = stdin.readLine();
			if (input.toUpperCase().equals("QUIT")) {
				break;
			}
			Double unrounded = RPNcalc.eval(
							   ShuntingYard.convert(StringParser.parse(input)));
			Double rounded = Math.round(unrounded*1000000000)/1000000000.0;
			if (Math.round(unrounded) == rounded) {
				System.out.println(rounded.intValue());
			}
			else {
				System.out.println(rounded);
			}
		}
	}
}