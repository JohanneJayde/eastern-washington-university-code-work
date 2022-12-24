package shape;

/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: AbstractFactory is a an abstract class that is used in order to create factories used for creating
 * factories that produce specific objects. Contains getShape() abstract method
 */
public abstract class AbstractFactory {
	//getShape(String shapeType) is an abstract method used to send the user's input into a factor and return the Shape to
	//where the method was called
	public abstract Shape getShape(String shapeType);
	
}
