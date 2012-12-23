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
			System.out.println(RPNcalc.eval(StringParser.parse(input)));
		}
	}
}