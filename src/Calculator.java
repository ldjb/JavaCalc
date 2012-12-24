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
			//System.out.println(ShuntingYard.convert(StringParser.parse(input)));
			double unrounded = RPNcalc.eval(
							   ShuntingYard.convert(StringParser.parse(input)));
			System.out.println(Math.round(unrounded*1000000000)/1000000000.0);
		}
	}
}