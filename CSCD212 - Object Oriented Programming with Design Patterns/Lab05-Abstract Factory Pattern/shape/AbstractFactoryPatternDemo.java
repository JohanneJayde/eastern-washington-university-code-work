package shape;

/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: AbstractFactoryPatternDemo is a class used for testing the abstract factory pattern. Four shapes are created to test
 * the programs functionality and check each possible case
 */

public class AbstractFactoryPatternDemo {
	//main class
	public static void main(String[] args) {
		//(FactoryProdcucer) factoryProdcucer is used to create factories that a set of shapes 
		FactoryProducer factoryProducer = new FactoryProducer();
		
		//(Shape) shape1 is created and set to a rectangle using getFactory to get the appropriate factory to create the shape
		Shape shape1 = factoryProducer.getFactory("Rectangle");
			//draw() method is called to display the shape and which method was called
			shape1.draw();
		//shape2 is set to a square (inputed as upper case to show that the program can handle it)
		Shape shape2 = factoryProducer.getFactory("SQUARE");
			//draw() displays the shape type of shape2
			shape2.draw();
		//shape3 is set to a rounded rectangle
		Shape shape3 = factoryProducer.getFactory("Rounded Rectangle");
			//draw() displays the shape type of shape3
			shape3.draw();
		//shape4 is set to a rounded square (inputed as upper case with no space to show that the program can handle it)
		Shape shape4 = factoryProducer.getFactory("ROUNDEDSQUARE");
			//draw() displays the shape type of shape4
			shape4.draw();	
			
			
	}

}
