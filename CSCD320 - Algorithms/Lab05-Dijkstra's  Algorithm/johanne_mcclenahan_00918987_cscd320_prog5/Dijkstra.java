/*
Name: Johanne McClenahan
Class: CSCD320-40
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra {
	
	public static class Graph{
		
		protected Vertex [] vertices;
		
		public Graph(int num) {
			this.vertices = new Vertex[num];
			
			for(int i = 0; i < num; i++) {
				this.vertices[i] = new Vertex(i,0);
			}			
		}

		public class Vertex{
			
			int path;
			LinkedList edges;
			int name;
			Vertex previous;
		
			public class LinkedList {
				
				private Edge head;
				private int size;
	
					public class Edge {
						
						private Object path;
						private Edge next;		
						private Vertex V;
		
						private Edge(Integer v, Object path) {
							this.path = path;;
							this.V = vertices[v];
							
						}
					}	
				
				public  LinkedList(int i) {
					this.head = new Edge(i, null); //with a dummy head Edge
					this.size = 0;
				}
				
				public int size() {
					return this.size;
				}
	
				public boolean isEmpty() {
					return size == 0;
				}
				//adds Edge to the beginning of a adjacency list for a given vertex
				public void addFirst(Integer e, Object data){
					Edge edge = new Edge(e, data);
					edge.next = head.next;
					head.next = edge;
					size++;
					
				}
				//adds Edge to the end of a adjacency list a given vertex
				public void addLast(Integer e, Object o) {	
					Edge cur = this.head;
					
					if(cur == null) {
						cur = new Edge(e, o);
					}
					
					while(cur.next != null) {
						cur = cur.next;
					}
					this.size++;	
					cur.next = new Edge(e, o);
				}
				//prints out each path weight of an edge that is connected to a given vertex
				public void printPathWeight() {
					if(head.next == null) {
						return;
					}
					Edge cur = this.head.next;
	
					for(int i = 0; i < this.size() - 1; i++ ) {
						System.out.print(cur.path + ", ");
						cur = cur.next;
					}
					
					System.out.println(cur.path);
				}
				//prints out the name or index of all the edges that are connected to a given vertex.
				public void printEdges() {
					
					if(head.next == null) {
						return;
					}
					
					Edge cur = this.head.next;
	
					for(int i = 0; i < this.size() - 1; i++ ) {
						System.out.print(cur.V.name + ", ");
						cur = cur.next;
					}
					
					System.out.println(cur.V.name);
				}
				//prints out each edge's information including its path weight from a given vertex and its name (index)
				public void printEdgeInfo() {
					if(head.next == null) {
						return;
					}
					Edge cur = this.head.next;
	
					for(int i = 0; i < this.size() - 1; i++ ) {
						System.out.print(cur.V.name + ", " + cur.path + "; ");
						cur = cur.next;
					}
					
					System.out.print(cur.V.name + ", " + cur.path);
				}
		}
			
		public Vertex(int i, Object o) {
			this.path = Integer.MAX_VALUE;
			this.edges = new LinkedList(i);
			this.name = i;
			this.previous = null;
		}
	}	
		//prints out the edge path that is the lightest from the starting vertex to the vertex at index c in the 
		//graph and prints the edges that are needed to be traversed to land at each edge
		//will print out unreachable if that vertex cannot be reached by the starting vertex
		public void printEdgePath(int c) {
				
			Vertex vert = this.vertices[c];
			int weight = this.vertices[c].path;
			
			if(weight == Integer.MAX_VALUE) {
				System.out.println("[" + vert.name + "]unreachable");
			}
			else {
				System.out.print( "[" + vert.name + "]shortest path:");
				System.out.print("(");
				printReverseEdgePath(c);
				System.out.print(")");
				System.out.println( " shortest distance:" + weight);
			}
		}
		//reverses the printing of an edge path. Instead of printing from the end to the starting vertex, this method will reverse it and 
		//print from the starting vertex to any other vertex in graph that it has a path to.
		public void printReverseEdgePath(int c) {
			
			Vertex vert = this.vertices[c];
			int [] path = {-1, -1, -1};
			
			int i = 0;
	
			while(vert.previous != null) {
				
				path[i] = vert.name;		
				vert = this.vertices[c].previous;
				
				c = vert.name;
				i++;
			}
			
			path[i] = vert.name;
	
			for(int j = path.length - 1; j > 0; j--) {
				
				if(path[j] == -1 ) {
					
				}
				else {
				System.out.print(path[j] + ", ");
				}
				
			}
			System.out.print(path[0]);
		}
		//wrapper method that prints out the edge path and shortest distance starting from the given starting vertex
		//and going to all connected vertices
		public void printAllEdgePaths(int v) {
			
			for(int i = 0; i < this.vertices.length; i++) {
				
				if(i == v) {
					
				}
				else {
				printEdgePath(i);
				
				}
			}
		}
	//converts a text file, which has been converted into a string array, into a Graph that is using adjacency list representation
	public void convert_to_adj_list(String [] line) {
		
		for(int i = 0; i < line.length; i++) {
			int pos = Integer.parseInt(line[i].substring(0,1));
			
			String [] edges = line[i].substring(2).split(";");
			
			for(int j = 0; j < edges.length; j++) {
				
				if(edges[j].isEmpty()) {
					
				}
				
				else {
					
				int vert = Integer.parseInt(edges[j].substring(0,1));
				int weight = Integer.parseInt(edges[j].substring(2,3));
				this.vertices[pos].edges.addLast(vert,weight);
				
				}
			}			
		}		
	}
	//prints out the adjacency list including the vertex, its edges and the path weight from it to each edge
	public void print_adj_list() {	
		for(int i = 0; i < vertices.length; i++) {
			System.out.print(i + ": ");
			this.vertices[i].edges.printEdgeInfo();
			System.out.println();
		}		
	}
	//prints out all the vertices and the lightest path weight found from the given starting vertex
	public void print_vertices() {	
		for(int i = 0; i < vertices.length; i++) {
			System.out.print(this.vertices[i].name + ", " + this.vertices[i].path + "; ");
			
			System.out.println();
		}		
	}	
	//returns an array of Vertex objects that represent all the vertices connected to a given vertex represented by u
	//if a vertex has no path to vertex u then it won't be added and returned via the array
	public Vertex [] find_connecting_paths(int u) {
		
		Vertex [] vert = new Vertex[this.vertices[u].edges.size + 1];
		vert[0] = this.vertices[u];
		Dijkstra.Graph.Vertex.LinkedList.Edge edge = this.vertices[u].edges.head.next;
		for(int i = 1; i < vert.length; i++) {
			vert[i] = edge.V;
			
			edge = edge.next;
		}
		
		return vert;
	}
}
	//Calculates the lightest paths from a given vertex s to every other connecting vertex in Graph g
	public void Dijkastra(Graph g, int s){
			
		g.vertices[s].path = 0;
		g.vertices[s].previous = null;
		//create priority_queue that stores the lightest paths of the vertices of a given graph g
		priority_queue A = new priority_queue(g.find_connecting_paths(s));
		A.build_priority_queue(g.find_connecting_paths(s));
			
		while (A.size != 0) {
			Dijkstra.Graph.Vertex v = A.extract_min();
			int u = v.name;
			
			//add checker for sets	
			Dijkstra.Graph.Vertex.LinkedList.Edge e =  g.vertices[u].edges.head.next;
			for(int i = 0; i < g.vertices[u].edges.size; i++) {
							
				if(e.V.path > g.vertices[u].path + (int) e.path) {
						
					e.V.path = g.vertices[u].path + (int) e.path;
						
					A.priority_queue_decrease_key(e.V.name, e.V.path);
					
					e.V.previous = g.vertices[u];
					e = e.next;
				}
			}			
		}
	}
	//priority queue used to help with Dijkastra() method
	public static class priority_queue{
		
		 Dijkstra.Graph.Vertex [] arr;
		 int heap_size;
		 int size;
		
		public priority_queue(Object [] a){
			this.heap_size = a.length;
			this.size = a.length;
			this.arr = (Dijkstra.Graph.Vertex[]) a;
		}
		
		//makes sure priority queue is in good shape by converting a bad vertex (k) into the proper spot
		public void min_heapify(int k) {
			
			if(this == null || this.heap_size == 1)
				return;
			
			if(k > this.heap_size)
				throw new IllegalArgumentException("k is out of heap!");
			
			if(k > Math.floor(this.heap_size/2)){
				return;
			}
			
			Dijkstra.Graph.Vertex temp;
			
			if(2*k == this.heap_size) {
				if(this.arr[k].path >= this.arr[2*k].path) {
					temp = this.arr[k];
					this.arr[k] = this.arr[2*k];
					this.arr[2*k] = temp;
					return;
				}
				return;
			}
			
			if(this.arr[2*k].path >= this.arr[k].path && this.arr[2*k].path <= this.arr[2*k + 1].path) {
					return;
			}
			
			if(this.arr[2*k].path <= this.arr[k].path && this.arr[2*k].path <= this.arr[2*k + 1].path) {
				temp = this.arr[k];
				this.arr[k] = this.arr[2*k];
				this.arr[2*k] = temp;
				this.min_heapify(2*k);
			}
			
			if(this.arr[2*k + 1].path <= this.arr[k].path && this.arr[2*k + 1].path <= this.arr[2*k].path) {
				temp = this.arr[k];
				this.arr[k] = this.arr[2*k + 1];
				this.arr[2*k + 1] = temp;
				this.min_heapify(2*k + 1);
			}
		}
		
		//builds a full priority queue given an array of Vertex objects
		public void build_priority_queue(Dijkstra.Graph.Vertex [] arr) {
				 
			Dijkstra.Graph.Vertex [] arrIndex1 = new Dijkstra.Graph.Vertex[arr.length + 1];
			
			arrIndex1[0] = null;
			
			for(int i = 0; i < arr.length; i++) {
				arrIndex1[i + 1] = arr[i];
			}
			
			this.arr = arrIndex1;
								 
			for(int i = (int) Math.floor(this.heap_size/2); i >= 1; i--) {
				 this.min_heapify(i);
			}
		}
		// returns the Vertex in the queue that has the lowest weight among the others in the queue.
		public Dijkstra.Graph.Vertex extract_min() {
			
			Dijkstra.Graph.Vertex min = this.arr[1];		
			this.arr[1] = this.arr[heap_size];		
			this.min_heapify(1);		
			this.size--;
			return min;
		}
		
		//i = name of vert
		//key is path weight of vert i
		//decreases the key of a given vertex (name) with a new value of (key)
		//i.e the vertex that has its field name that is the same as the parameter name will have its path field updated with the parameter key
		//then it will continuously moved up the queue to its new proper place.
		public void priority_queue_decrease_key(int name, int key) {
			
			for(int k = 1; k < this.size; k++) {
				
				if(name == this.arr[k].name) {
					int i = k;
					if(key > this.arr[i].path) {
							return;
					}
					
					this.arr[i].path = key;
					
					while(i > 1 && arr[(int) Math.floor(i/2)].path > arr[i].path) {
						Object temp = arr[i];
						arr[i] = arr[(int) Math.floor(i/2)];
						arr[(int) Math.floor(i/2)] = (Dijkstra.Graph.Vertex) temp;
						
						i = (int) Math.floor(i/2);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		  //array to hold large values as number of lines in file input is undetermined
		   String [] holder = new String[100];

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
		      //the holder array and increments count
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
		
		Graph g = new Graph(arr.length);
		
		g.convert_to_adj_list(arr);
		
		Dijkstra path = new Dijkstra();		
		path.Dijkastra(g, Integer.valueOf(args[1]));
		
		g.printAllEdgePaths(Integer.valueOf(args[1]));
	}
}
	
