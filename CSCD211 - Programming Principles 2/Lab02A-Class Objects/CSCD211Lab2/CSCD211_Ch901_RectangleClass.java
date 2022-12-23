
/*
Johanne McClenahan
Class: CSCD211_Ch901_RectangleClass & Class
Description:
program that creates two rectangle objects and includes methods that allows to compute area and parameter
also includes accessor and mutator methods that modify and access the rectangle object when being called from main

*/


public class CSCD211_Ch901_RectangleClass{

public static void main(String [] args){
   //creates rectangle with width of 4 and height of 40
   Rectangle rect1 = new Rectangle(4, 40);
   //creates rectangle with width of 3.5 and height of 35.9
   Rectangle rect2 = new Rectangle(3.5, 35.9);
   //displays rectangle 1's width, height and computed area using accessor methods
      System.out.println("The area of a rectange with width " + rect1.getWidth() + " and height " + rect1.getHeight() + " is " + rect1.getArea());
      System.out.println("the perimeter is a rectange with width " + rect1.getWidth() + " and height " + rect1.getHeight() + " is " + rect1.getPerimeter());
   //displays rectangle 1's width, height and computed area using accessor methods
      System.out.println("The area of a rectange with width " + rect2.getWidth() + " and height " + rect2.getHeight() + " is " + rect2.getArea());
      System.out.println("the perimeter is a rectange with width " + rect2.getWidth() + " and height " + rect2.getHeight() + " is " + rect2.getPerimeter());

}
}
