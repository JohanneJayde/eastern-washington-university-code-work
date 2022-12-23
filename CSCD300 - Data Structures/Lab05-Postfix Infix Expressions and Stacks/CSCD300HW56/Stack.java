
public class Stack<T> {
	
	private class Node {
		private T data;
		private Node next;
		
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}	
	}
	
	protected Node top;
	protected int size;

	public Stack() {
		 this.top = null;
		 this.size = 0;		
	}
	
	public int size() {	
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.top == null)
			return true;
		return false;
	}
	
	public void push(T data) {
		Node newNode = new Node(data, this.top);
		this.top = newNode;
		this.size++;
	}
	public T pop() {
		if(this.isEmpty())
			throw new EmptyStackException("Stack is empty!");
		
		T temp = top.data;
		this.top = top.next;
		this.size--;
		
		return temp;
	}
	
	public T peek() {
		if(this.isEmpty())
			throw new EmptyStackException("Stack is empty!");
		
		return this.top.data;
	}
	
	/**
	  * Returns a string representation of the stack as a list of elements,
	  * with the top element at the end: [ ... , prev, top ].
	  * This method runs in O(n) time, where n is the size of the stack.
	  * @return textual representation of the stack.
	  */
	  public String toString() {
		  
	    String s;
	    Node cur = null;
	    s = "[";
	    int n = size();
	    
		    if (n > 0) {
		      cur = top;
		      s += cur.data;
		    }
		    if (n > 1)
		      for (int i = 1; i <= n-1; i++) {
		    	  	cur = cur.next;
		    	  	s += ", " + cur.data;
		      }
		    
		    s += "]";
		    
		    return s;
	  }
	
}
