import java.util.*;

public class ExpressionEvaluation<E> {

	public static String convertToPostfix(String exp) {
		
		String postfix = "";
		Stack<Character> holder = new Stack<>();
			
		for(int i = 0; i < exp.length(); i++) {
			
			char curItem = exp.charAt(i);
			
			if(Character.isDigit(curItem)) {
				postfix = postfix + curItem;
			}
					
			else if(curItem == '(') {
				holder.push(curItem);
					
				}
				
			else if(curItem == ')') {
				while(holder.peek() != '(') {
					postfix += holder.pop();
				}
				holder.pop();
			}
				
			else {
				while(!holder.isEmpty() && stackPrec(holder.peek()) > curPrec(curItem)) {
					postfix += holder.pop();
				}
				
				holder.push(curItem);	
			}
		}
		
		while(!holder.isEmpty()) {
			postfix += holder.pop();
		}
		
		return postfix;
	}
	
	public static int evaluatePostfix(String exp) {
		
		int result = 0;
		Stack<String> holder = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			
			char curItem = exp.charAt(i);
		
			if(Character.isDigit(curItem)) {
				holder.push(Character.toString(curItem));
				
			}
			
			else {
				int right = Integer.valueOf(holder.pop());
				int left = Integer.valueOf(holder.pop());
				result = evalExpression(left, right, curItem);
				String c = String.valueOf(result);
				holder.push(c);
			}	
		}
		
		if(holder.size() == 1) {
		 result = Integer.valueOf(holder.pop());
		}
		else {
			throw new IllegalArgumentException("error in postfix expression!");
		}
		
		return result;
	}
	
	public static int evalExpression(int left, int right, char op){

	    switch(op){
		    case '+':
		        return left + right;
		  
		    case '-':
		        return left - right;
		   
		    case '*':
		        return left * right;
		    
		    case '/':
		        return left / right;
		  
		    case '^':
		    	return (int) Math.pow(left,right);   
		    default:
		        return 0;
	    }
	}
	
	public static int curPrec(char s) {
		
	    switch(s){
		    case ')':
		    	return 0;
		    case '+':
		    	return 1;
		    case '-':
		    	return 1;
		    case '*':
		    	return 3;
		    case '/':
		    	return 3;
		    case '%':
		    	return 3;
		    case '^':
		    	return 6;
		    case '(':
		    	return 100;
		    default:
		        return 0;
	    }
	}
	
	public static int stackPrec(char s) {
		
	    switch(s){
		    case '(':
		    	return 0;
		    case '+':
		    	return 2;
		    case '-':
		    	return 2;
		    case '*':
		    	return 4;
		    case '/':
		    	return 4;
		    case '%':
		    	return 4;
		    case '^':
		    	return 5;
		    default:
		        return 0;
	    }
	}

}
