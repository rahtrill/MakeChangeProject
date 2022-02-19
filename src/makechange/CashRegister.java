package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		System.out.println("Please enter the total due (Format 0.00):"); // Enters purchase price
		double amountDue = kb.nextDouble();
		System.out.println("Please enter how much was tendered (Format 0.00):"); // Enters amount tendered
		double tendered = kb.nextDouble();

		if (tendered > amountDue) {
			calculateChange(amountDue, tendered); // Change! It will send to the change calculation method
		} else if (tendered == amountDue) {
			System.out.println("No change due!"); // The total is the same as the amount tendered, no change due
		} else {
			System.out.println("Not enough tendered, please enter more."); // Not enough tendered, return with error
		}

		kb.close();
	}

	public static void calculateChange(double amountDue, double tendered) {
		double changeDue = (double) (tendered - amountDue); // Calculates the change due
		int pennies = 0, nickels = 0, dimes = 0, quarters = 0, dollars = 0, dollars5 = 0, dollars10 = 0, dollars20 = 0;

		// This sends the value back out. The double was giving a large decimal number
		// than it should, so I used printf to format.
		System.out.printf("Change due: $%.2f %n", changeDue);

		// Calculates different pieces of change owed by dividing change into change
		// value and then subtracting larger change from the value.
		
		dollars20 = (int) (changeDue / 20);
		dollars10 = (int) ((changeDue / 10) - (dollars20 * 2));
		dollars5 = (int) ((changeDue / 5) - (dollars20 * 4) - (dollars10 * 2));
		dollars = (int) ((changeDue / 1) - (dollars20 * 20) - (dollars10 * 10) - (dollars5 * 5));
		quarters = (int) ((changeDue / 0.25) - (dollars20 * 80) - (dollars10 * 40) - (dollars5 * 20) - (dollars * 4));
		dimes = (int) ((changeDue / 0.1) - (dollars20 * 200) - (dollars10 * 100) - (dollars5 * 50) - (dollars * 10)
				- (quarters * 2.5));
		nickels = (int) ((changeDue / 0.05) - (dollars20 * 400) - (dollars10 * 200) - (dollars5 * 100) - (dollars * 20)
				- (quarters * 5) - (dimes * 2));
		pennies = (int) ((changeDue / 0.01) - (dollars20 * 2000) - (dollars10 * 1000) - (dollars5 * 500)
				- (dollars * 100) - (quarters * 25) - (dimes * 10) - (nickels * 5)); //TODO: Random pennies go missing for some reason? Talk to a TA.

		// If statements will prevent any pieces of currency with a value of 0 from
		// being shown

		if (dollars20 > 0) {
			System.out.println("$20 bills due: " + dollars20);
		}
		if (dollars10 > 0) {
			System.out.println("$10 bills due: " + dollars10);
		}
		if (dollars5 > 0) {
			System.out.println("$5 bills due: " + dollars5);
		}
		if (dollars > 0) {
			System.out.println("$1 bills due: " + dollars);
		}
		if (quarters > 0) {
			System.out.println("Quarters due: " + quarters);
		}
		if (dimes > 0) {
			System.out.println("Dimes due: " + dimes);
		}
		if (nickels > 0) {
			System.out.println("Nickels due: " + nickels);
		}
		if (pennies > 0) {
			System.out.println("Pennies due: " + pennies);
		}

	}

}
