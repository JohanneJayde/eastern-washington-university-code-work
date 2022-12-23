import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TopoSort {
	
	public static class Graph{
		
		protected LinkedList V;
		protected LinkedList finish_times;
		protected LinkedList [] adj;

		int time;
		
		public Graph(int num) {
			this.V = new LinkedList();
			this.finish_times = new LinkedList();
			this.adj = new LinkedList[num];
			this.time = 0;
			
			for(int i = 0; i < this.adj.length; i++) {
				this.adj[i] = new LinkedList();
			}
		}
		
		public class LinkedList {
			
			private Node head;
			private int size;

			private class Node {
				
				private Object data;
				private Node next;
				private boolean visited; 
				private Node previoudNode;
				private int metTime;
				private int doneTime;
				
				private Node(Object d) {
					this.data = d;
					this.next = null ;
					this.visited = false;
					this.previoudNode = null;
					
				}

			}
			
			public  LinkedList() {
				this.head = new Node(null); //with a dummy head node
				this.size = 0;
			}
			
			public int size() {
				return this.size;
			}

			public boolean isEmpty() {
				return size == 0;
			}
		
			public void addFirst(Object e)
			{
				Node node = new Node(e);
				node.next = head.next;
				head.next = node;
				size++;
			}
			
			public void addLast(Object o) {	
				Node cur = this.head;
				
				if(cur == null) {
					cur = new Node(o);
				}
				
				while(cur.next != null) {
					cur = cur.next;
				}
				this.size++;	
				cur.next = new Node(o);
				
			}
			
			public void printList() {
				
				if(this.head.next == null) {
					System.out.println();
					return;
				}
				
				Node cur = this.head.next;

				for(int i = 0; i < this.size() - 1; i++ ) {
					System.out.print(cur.data + ", ");
					cur = cur.next;
				}
				
				System.out.println(cur.data);
			
			}
						
			public void set_list_Flag(Object f) {
				Node cur = this.head.next;
				while(cur != null) {
					if(cur.data == f) {
						cur.visited = true;
					}
					cur = cur.next;
				}
				
			}
	}
			
		public void convert_to_adj_list(String [] line) {
			
			for(int i = 0; i < line.length; i++) {
					
					int index = Integer.parseInt(line[i].substring(0,1));
					String [] split = line[i].substring(2).split(",");
					this.V.addLast(index);
					for(int j = 0; j < split.length; j++) {
					
						if(split[0].isEmpty()) {
							
						}
						else {
							this.adj[index].addLast(Integer.parseInt(split[j]));
						}
					}
				}			
		}
		
		public void printVertices() {		
			this.V.printList();
		}
		
		public void print_adj_list() {
			
			for(int i = 0; i < this.adj.length; i++) {
				System.out.print(i + ": ");
				this.adj[i].printList();
				
			}
		}
		
		public void set_all_flags(Object f) {
			
			for(int i = 0; i < this.adj.length; i++) {
				this.adj[i].set_list_Flag(f);
			}
		}
	
	}
	
	public void graph_DFS(Graph G, Object u){
		TopoSort.Graph.LinkedList.Node vert = G.V.head;
		
		while(vert.data != u) {
			vert = vert.next;
		}
			
		G.time++;
		
		vert.visited = true;
		G.set_all_flags(vert.data);
		vert.metTime = G.time;
		
		TopoSort.Graph.LinkedList.Node edge = G.adj[(int) vert.data].head.next;
			
		while(edge != null) {
			if(edge.visited == false) {
				this.graph_DFS(G, edge.data);
			}
			G.time++;
			vert.doneTime = G.time;
			edge = edge.next;
		}
		G.finish_times.addFirst(vert.data);
	}

	public void depth_first_search(Graph G){
		
		TopoSort.Graph.LinkedList.Node head = G.V.head.next;
		
		while(head != null) {
			if(head.visited == false) {
				this.graph_DFS(G, head.data);
			}
			
			head = head.next;
		}
		
	}
	
	public void topological_sort(Graph G) {
		this.depth_first_search(G);
		
		G.finish_times.printList();
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		  //array to hold large values as number of lines in file input is undetermined
		   String [] holder = new String[10000000];

		   //fileName stores the file that will be read from inputed by the user via the command line
		   String fileName = args[0];
		   //num stores the position of the ith smallest number that the user wants to find
		   File file = new File(fileName);
		      
		      //checks if the file that the user inputed is able to be read from
		      if(file.exists() == false){
		         throw new IllegalArgumentException("File doesn't exist!");
		      }
		       
		      //scanner used to read through file. 
		      Scanner fileRead = new Scanner(file);
		      //counter keeps track of number of lines or amount of elements that will be in the array
		      //that will be inputed
		      int count = 0;
		    
		      //while loop is used to read through file line by line and then add each line into
		      //the holder array and incrments count
		      while(fileRead.hasNextLine()){        
		         holder[count] = fileRead.nextLine();
		         count++;
		      }
		      //arr stores the elements from the file but is the proper size to use in finding ith order statistic
		      String [] arr = new String[count];
		      
		      //for-loop used to copy over data to arr from holder array
		      for(int i = 0; i <= arr.length - 1; i ++){
		        arr[i] = holder[i];
		     }
		      
		     
		Graph G = new Graph(count);		
		G.convert_to_adj_list(arr);	

		TopoSort Sort = new TopoSort();
		Sort.topological_sort(G);
		
	}

}

