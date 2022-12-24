package shape;

/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: FactoryProducer is used to create new factories based on what the user inputs
 * if the user inputs a rounded shape, then the roundedShapeFactory is used to create the Shape object
 * otherwise, the regular ShapeFactory is used to create the Shape object
 */

public class FactoryProducer {
		
		//factory is created as an AbstractFactory object and its state is set once the shape type is determined
		AbstractFactory factory;

		//getFactory(String shapeType) takes in a String value and based on the contents of the string
		//getFactory returns one of the two factories or null
		public Shape getFactory(String shapeType) {
			
			//if-statement checks if the shapeType is null.
			if(shapeType == null) {
				//if shapeType is null, null is returned to where the method was called
				return null;
			}
			
			//if-statement is used to check whether or not shapeType contains the character sequence "round"
			//toLowerCase() is used to convert the string to lower case in order to test it without having to deal with case sensitivity
			//.contains("round") checks if the lower case shapeType contains "round"
			if(shapeType.toLowerCase().contains("round")) {
				//if shapeType contains round, factory's state set to a RoundedShapeFactory() and factory.getShape() is called in order to create the shape, using one of the rounded
				//shape interfaces 
				factory = new RoundedShapeFactory();
				return factory.getShape(shapeType);
			}
			
			//if "rounded" is not found, factory's state set to a ShapeFactory() and factory.getShape() is called in order to create the shape, using one of the regular
			//shape interfaces 
			else { 
				factory = new ShapeFactory();
				return factory.getShape(shapeType);
			}
		}

}
