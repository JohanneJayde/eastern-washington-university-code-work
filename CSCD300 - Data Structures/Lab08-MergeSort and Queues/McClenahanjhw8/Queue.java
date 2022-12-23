
public class Queue <t>{

	public class Node {
		
		private Object data;
		private Node next;
		
		public Node(Object d) {
			this.data = d;
			this.next = null;
		}
		
	}
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	public Queue() {
		this.head = null;
		this.tail = this.head;
		this.size = 0;
	
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean empty() {
		if(this.size() == 0) {
			return true;
		}
		return false;
	}
	
	public Object front() {
		if(this.empty())
			return null;
		
		return this.head.data;
		
	}
	
	public void enqueue(Object data) {
		
		Node newNode = new Node(data);
		
		if(this.size() == 0) {
			this.head = newNode;
			
		}
		else {
			this.tail.next = newNode;
			
		}
	    this.tail = newNode;
		this.size++;
	}
	
	public Object dequeue() {
		if(this.empty()) {
			throw new IllegalArgumentException("Queue is empty!!!");
		}
		
		Object temp = this.head.data;
		this.head = this.head.next;
		
		if(this.head == null)
			this.tail = null;
		
		size--;
		return temp;
		
	}
	
	public String toString() {
		String result = "{";
	    for (Node node = this.head; node != null; node = node.next) {
	    		if(node.next != null)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }

}
