### Make Change Project


#### Description
This program is designed to calculate the exact change of a purchase.

For example, you owe $4.25 and you enter a $20 bill. Your change is $15.75. It will tell you that the bills and coins due are one $10 bill, one $5 bill, and three quarters.


#### Lessons Learned
After completing the math required to make this program run, I noticed that the pennies would occasionally be one value below the actual value of pennies dispensed. I used a "sysout" to print out the exact value of the change due, and found that the double value would be imprecise at random. I tried converting the value to a float value, and it would have the same issue with different values.

After some help with ideas to counter this problem, I came up with a way to specifically count the pennies and made a new method to keep my original code organized. I decided to pass in an argument that had the value of the change due, and I would multiply it by 100 to simulate pennies. I then wanted to find a way to round a value up (instead of scaling it to the floor value) if it was imprecise and worth less than the actual value. I found a Math function called Math.ceil() that would bump a decimal value to the next value up. After this, I divide the value by 100 and pass it back to the pennies counting equation.

This, however, did not account for when you would use Math.ceil() on values that were imprecise and worth **more than** the actual value. I found that if I use Math.ceil() on that value, and then divide it by 0.01 to find how many pennies are in the value, it would always give another imprecise value below the value. I would then run another Math.ceil() on the product of that equation, and it would give the correct output every time.


#### Technologies Used
There were multiple technologies used in this code to make it work properly.

In order to receive user input for the amount due and the amount tendered, the java utility Scanner was used. In order to make the format of the output for change due look more organized and stop at two decimal places after the decimal point, I used printf. I used scaling at multiple points to force double values into integers and vice versa for accuracy. In order to round imprecise numbers up instead of scaling them down, I used the Math.ceil() function.


#### What was the most difficult part of this project?
The double and float imprecise values causing problems with counting the change was the most difficult part of this project. I was stuck for a bit on how to resolve the issue. When writing out the logic and math for this problem, I fully expected the arithmetic to work without any problems. Having to make a workaround for this problem taught me that double and float values are not always precise and it is something I'm going to have to look out for in future projects.
