
public class LinkedList {

	public class Node{
		
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object d, Node p, Node n) {
			this.data = d;
			this.next = n;
			this.prev = p;
		}
	}
	
	protected Node head;
	protected int size;

	public LinkedList() {
		this.head = new Node(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;	
	}
	
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		return false;
	}
	
	public void addFirst(Object data) {
		
		Node cur = this.head;
		Node newNode = new Node(data, cur, cur.next);
		cur.next.prev = newNode;
		cur.next = newNode;
		this.size++;
		
		
		
	}
	public void addLast(Object data) {
			
			Node cur = this.head.prev;
			Node newNode = new Node(data, cur, cur.next);
			cur.next.prev = newNode;
			cur.next = newNode;
			this.size++;
		
	}
	
	public void removeFirst() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException("LL IS NULL!!!!!");
		}
		
		this.head.next = this.head.next.next;
		this.size--;
	}
	
	public void removeLast() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException("LL IS NULL!!!!!");
		}
			
			Node cur = this.head.prev;
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			this.size--;
			
		}
	
	public Object getFirst() {
		if(this.isEmpty()) {
			throw new IllegalArgumentException("LL IS NULL!!!!!");
		}
		
		return this.head.next.data;
	}
	
	public boolean isSorted() {
		if(this.isEmpty() || this.size == 1) {
			return true;
		}
		
		Node cur = this.head.next;
		
		while(cur.next != this.head) {
			Comparable currentData = (Comparable) cur.data;
			
			if(currentData.compareTo((Comparable) cur.next.data) > 0) {
				return false;
			}
			cur = cur.next;
		}
		return true;	
	}
	
	public void MergeSort() {
		Queue q = new Queue();
		LinkedList tempList = new LinkedList();

		for(Node cur = this.head.next; cur != this.head; cur = cur.next) {
			LinkedList newList = new LinkedList();
			newList.addFirst(cur.data);
			q.enqueue(newList);		
		}
		
		
		while(q.size() > 1) {
			LinkedList subList1 = (LinkedList)q.dequeue();
			LinkedList subList2 = (LinkedList)q.dequeue();
			tempList = merge(subList1, subList2);
		    q.enqueue(tempList);
		}
		
		this.head = tempList.head;
		
	}
	
	public static LinkedList merge(LinkedList A, LinkedList B) {
		
		LinkedList output = new LinkedList();
		Object fa;
		Object fb;
		
		while((!A.isEmpty()) && (!B.isEmpty())) {
			fa = A.getFirst();
			fb = B.getFirst();
					
			if(((Comparable)fa).compareTo((Comparable)fb) < 0) {
				A.removeFirst();
				output.addLast(fa);
			}
			else {
				B.removeFirst();
				output.addLast(fb);
			}
		}
		while(!A.isEmpty()) {
			fa = A.getFirst();
			output.addLast(fa);
			A.removeFirst();
		}
		while(!B.isEmpty()) {
			fb = B.getFirst();
			output.addLast(fb);
			B.removeFirst();
		}
		
		return output;
	}
	
	
	public void InsertionSort() {
		Node lastSorted;
		Node sortedWalker;
		
		for(lastSorted = this.head.next; lastSorted != this.head.prev; lastSorted = lastSorted.next) {
			
			Comparable firstUndsortedData = (Comparable) lastSorted.next.data;
			
			for(sortedWalker = lastSorted; sortedWalker != this.head && ((Comparable)sortedWalker.data).compareTo(firstUndsortedData) > 0; sortedWalker = sortedWalker.prev) {
				sortedWalker.next.data = sortedWalker.data;
			}
			
			sortedWalker.next.data = firstUndsortedData;
		}
	}
	
	
	
	public String toString() {
		String result = "{";
	    for (Node node = this.head.next; node != this.head; node = node.next) {
	    		if(node.next != this.head)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
