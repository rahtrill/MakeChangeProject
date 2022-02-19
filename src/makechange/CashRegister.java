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
		double pVal = 0.01, nVal = 0.05, diVal = 0.1, qVal = 0.25, dVal = 1, d5Val = 5, d10Val = 10, d20Val = 20;

		// This sends the value back out. The double was giving a large decimal number
		// than it should, so I used printf to format.

		System.out.printf("Change due: $%.2f %n", changeDue);

		// Calculates different pieces of change owed by dividing change into change
		// value and then subtracting larger change from the value.
		//
		// The equation I came up with is:
		// "current piece of change amount = (int to scale) * (change due / value of the
		// coin) -
		// (subsequent value * (subsequent value of coin / current value of coin))"
		//
		// For example, "dollars10 = (int) (changeDue / 10) - (dollars20 * (20 / 10));

		dollars20 = (int) (changeDue / d20Val);
		
		dollars10 = (int) ((changeDue / d10Val) - (dollars20 * (d20Val / d10Val)));
		
		dollars5 = (int) ((changeDue / d5Val) - (dollars20 * (d20Val / d5Val)) - (dollars10 * (d10Val / d5Val)));
		
		dollars = (int) ((changeDue / dVal) - (dollars20 * (d20Val / dVal)) - (dollars10 * (d10Val / dVal))
				- (dollars5 * (d5Val / dVal)));
		
		quarters = (int) ((changeDue / qVal) - (dollars20 * (d20Val / qVal)) - (dollars10 * (d10Val / qVal))
				- (dollars5 * (d5Val / qVal)) - (dollars * (dVal / qVal)));
		
		dimes = (int) ((changeDue / diVal) - (dollars20 * (d20Val / diVal)) - (dollars10 * (d10Val / diVal))
				- (dollars5 * (d10Val / diVal)) - (dollars * (dVal / diVal)) - (quarters * (qVal / diVal)));
		
		nickels = (int) ((changeDue / nVal) - (dollars20 * (d20Val / nVal)) - (dollars10 * (d10Val / nVal))
				- (dollars5 * (d5Val / nVal)) - (dollars * (dVal / nVal)) - (quarters * (qVal / nVal))
				- (dimes * (diVal / nVal)));
		
		pennies = (int) ((changeDue / pVal) - (dollars20 * (d20Val / pVal)) - (dollars10 * (d10Val / pVal))
				- (dollars5 * (d5Val / pVal)) - (dollars * (dVal / pVal)) - (quarters * (qVal / pVal))
				- (dimes * (diVal / pVal)) - (nickels * (nVal / pVal)));

		// TODO: Random pennies go missing
		// for some reason? Talk to a
		// TA.

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
