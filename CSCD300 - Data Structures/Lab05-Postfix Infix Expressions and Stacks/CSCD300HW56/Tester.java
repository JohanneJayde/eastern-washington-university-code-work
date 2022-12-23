import java.util.*;

public class Tester {
	
	public static void main(String[] args) {
		
	    Scanner kb = new Scanner(System.in);
	    
		System.out.print("Please enter the infix expression to process: ");		
		String expression = kb.nextLine();
		
		expression = expression.replaceAll("\\s","");
		
		String postfix = ExpressionEvaluation.convertToPostfix(expression);
		System.out.println("The postfix expression for the input infix is: " + postfix.replaceAll(".(?=.)", "$0 "));
		
		int finalResult = ExpressionEvaluation.evaluatePostfix(postfix);
		System.out.println("The final result after evaluating the postfix is: " + finalResult);

	}

}
