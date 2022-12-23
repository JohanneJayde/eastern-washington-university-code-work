/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: TreeTester serves as the tester file for creating HolidayItem objects and adding components to them
 * four different HolidayItems are created and tested.
 * 
 * 
 */

//imports holiday_decoration.* in order to access HolidayItems and its subclasses
import holiday_decorations.*;

public class TreeTester {

	public static void main(String[] args) {
		//creating tree1 with Fraser Fir, a star, 2 sets of ruffles, and lights
		HolidayItem tree1 = new FraserFir(); //HolidayItem is super type for Decorator scenario
		tree1 = Star.getStar(tree1);
		tree1 = new Ruffles(tree1);
		tree1 = new Ruffles(tree1);
		//a second star is not allowed to be added when one already exists so a message will be displayed
		//to the user telling them that the star already has a tree
		tree1 = Star.getStar(tree1);
		tree1 = new Lights(tree1);	
		
		//print statements used to display the tree name as well as its description and price to the user
		System.out.print("Tree1: ");
		System.out.print(tree1.getDescription());
		System.out.println(" costs $" + tree1.price());
		
		//creating tree2 with Colorado Blue Spruce, red balls, silver balls, 2 sets of ruffles, and LEDs
		HolidayItem tree2 = new ColoradoBlueSpruce();
		tree2 = new Ruffles(tree2);
		tree2 = new BallsRed(tree2);
		tree2 = new BallsSilver(tree2);
		tree2 = new Ruffles(tree2);
		tree2 = new LEDs(tree2);	
		
		//print statements used to display the tree name as well as its description and price to the user
		System.out.print("Tree2: ");
		System.out.print(tree2.getDescription());
		System.out.println(" costs $" + tree2.price());
		
		//creating tree3 with Balsam Fir, ribbons, a star, blue balls, ruffles, and LEDs
		HolidayItem tree3 = new BalsamFir();
		tree3 = new Ribbons(tree3);
		tree3 = Star.getStar(tree3);
		tree3 = new BallsBlue(tree3);
		tree3 = new Ruffles(tree3);
		tree3 = new LEDs(tree3);
		
		//print statements used to display the tree name as well as its description and price to the user
		System.out.print("Tree3: ");
		System.out.print(tree3.getDescription());
		System.out.println(" costs $" + tree3.price());
		
		//creating tree4 with Douglas Fir, ruffles, a star, LEDs, and red balls
		HolidayItem tree4 = new DouglasFir();
		tree4 = new Ruffles(tree4);
		tree4 = Star.getStar(tree4);
		tree4 = new LEDs(tree4);
		tree4 = new BallsRed(tree4);
		
		//print statements used to display the tree name as well as its description and price to the user
		System.out.print("Tree4: ");
		System.out.print(tree4.getDescription());
		System.out.println(" costs $" + tree4.price());
		
	}

}
