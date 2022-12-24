package shape;

/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: ShapeFactory is used to create regular Shape objects. It is a subclass of AbtractFactory and therefore
 * has to implement the getShape(String shapeType) method
 */

public class ShapeFactory extends AbstractFactory{
	//regularShape stores the Shape object created after the user's inputed String 
	//is taken and the corresponding shape is created
		Shape regularShape;

//getShape(String shapeType) takes the user's String and uses it to create a Shape object based off it
	public Shape getShape(String shapeType){
		
		//if the shapeType contains circle in it, then a new Circle() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		if(shapeType.toLowerCase().contains("circle")) {
			//Circle() is created and regularShape is set as it and returned to where the method was called
			regularShape = new Circle();
			return regularShape;
		}
		//if the shapeType contains square in it, then a new Square() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		else if(shapeType.toLowerCase().contains("square")) {
			//regularShape is set to a new Square object and is returned to where the method was called
			regularShape = new Square();
			return regularShape;
		}
		//if the shapeType contains rectangle in it, then a new Rectangle() is created
		//.toLowerCase() and contains() is once again used to check whether shapeType contains certain characters
		else if(shapeType.toLowerCase().contains("rectangle")){
			regularShape = new Rectangle();
			return regularShape;
		}
		//if the user's input doesn't match any of the three possible rounded shapes, 
		else {
			throw new IllegalArgumentException("user input does not match three possible shape (rectangle, square, or circle");
		}
		
	}
}
