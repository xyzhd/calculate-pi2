import java.util.Scanner;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *  Calculate Pi 
 *  @date 19 August 2014
 *  @author Nefari0uss
 * 
 * This program will request the approximate number of calculations to run in calculating π.
 * The final result will be displayed on the console. Assumption is that the user inputs an int. 
 * 
 *
**/

public class Pi {

	public static void main(String[] args) {

		int n = 100;
		double piValue = calculatePi(n);
		printResult(piValue);
		BigDecimal d = new BigDecimal(1); 
		d = d.divide(new BigDecimal(3),5000,BigDecimal.ROUND_HALF_UP);
		System.out.println(d); 
	} 

	private static double calculatePi(double n) {

		double pi = 1; double x = 1;
		for (int i = 1; i < n; i++) {
	       x = x*i/(2*i+1);
	       pi = pi+x;  
		} 
		return 2 * pi;
	} 

	private static int getInput() {
		int n = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("How many calculations should be run for the approximation?");
		try {
			n = Integer.parseInt(input.nextLine());
		} /** Handle input greater than Java's MAX_INT. **/
		catch (NumberFormatException e) {
			System.out.println("n is too large. Setting n to be the largest possible int value.");
			n = Integer.MAX_VALUE;
		}

		input.close();
		return n;
	}

	
	

	private static void printResult(double piValue) {
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("The value of pi is approximately " + piValue + ".");
		
	}

} 
