package shape;

/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: RounedShapeFactory is used to create rounded Shape objects. It is a subclass of AbtractFactory and therefore
 * has to implement the getShape(String shapeType) method
 */

public class RoundedShapeFactory extends AbstractFactory {
		//roundedShape stores the Shape object created after the user's inputed String 
		//is taken and the corresponding shape is created
		Shape roundedShape;
	
	//getShape(String shapeType) takes the user's String and uses it to create a Shape object based off it
	public Shape getShape(String shapeType){
		
		//if the shapeType contains circle in it, then a new RoundedCircle() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		if(shapeType.toLowerCase().contains("circle")) {
			//RoundedCircle() is created and roundedShape is set as it and returned to where the method was called
			roundedShape = new RoundedCircle();
			return roundedShape;
		}
		//if the shapeType contains square in it, then a new RoundedSquare() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		if(shapeType.toLowerCase().contains("square")) {
			//roundedShape is set to a new RoundedSquare object and is returned to where the method was called
			roundedShape = new RoundedSquare();
			return roundedShape;
		}
		//if the shapeType contains rectangle in it, then a new RoundedRectangle() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		else if(shapeType.toLowerCase().contains("rectangle")){
			roundedShape = new RoundedRectangle();
			return roundedShape;
		}
		//if the user's input doesn't match any of the three possible rounded shapes, 
		else {
			throw new IllegalArgumentException("user input does not match three possible shape (rouned rectangle, rounded square, or rounded circle");
		}

		
	}
	
	
}
