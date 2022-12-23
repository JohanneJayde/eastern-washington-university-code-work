import java.io.*;
import java.lang.Math;
import java.util.*;

public class Richest {
	public static class min_heap{
		
		 int [] arr = new int[10000];
		 int heap_size;
		 int size;
		
		public min_heap(int a){
			this.heap_size = a;
			this.size = arr.length;
		}
		
		public void min_heapify(min_heap a, int k) {
			
			if(a == null || a.heap_size == 1)
				return;
			
			if(k > a.heap_size)
				throw new IllegalArgumentException("k is out of heap!");
			
			if(k > Math.floor(a.heap_size/2)){
				return;
			}
			
			int temp;
			
			if(2*k == a.heap_size) {
				if(a.arr[k] >= a.arr[2*k]) {
					temp = a.arr[k];
					a.arr[k] = a.arr[2*k];
					a.arr[2*k] = temp;
					return;
				}
				return;
			}
			
			if(a.arr[2*k] >= a.arr[k] && a.arr[2*k] <= a.arr[2*k + 1]) {
					return;
			}
			
			if(a.arr[2*k] <= a.arr[k] && a.arr[2*k] <= a.arr[2*k + 1]) {
				temp = a.arr[k];
				a.arr[k] = a.arr[2*k];
				a.arr[2*k] = temp;
				min_heapify(a, 2*k);
			}
			
			if(a.arr[2*k + 1] <= a.arr[k] && a.arr[2*k + 1] <= a.arr[2*k]) {
				temp = a.arr[k];
				a.arr[k] = a.arr[2*k + 1];
				a.arr[2*k + 1] = temp;
				min_heapify(a, 2*k + 1);
			}
		}
		
		public void build_min_heap(min_heap b, int [] arr) {
				 
			int [] arrIndex1 = new int[arr.length + 1];
			
			arrIndex1[0] = 0;
			
			for(int i = 0; i < arr.length; i++) {
				arrIndex1[i + 1] = arr[i];
			}
			
			
			b.arr = arrIndex1;
								 
			for(int i = (int) Math.floor(b.heap_size/2); i >= 1; i--) {
				 min_heapify(this, i);
			}
		
		
		}
		
		public void is_min(min_heap b, int n) {
			if(b.arr[1] <= n) {
				b.arr[1] = n;
				 min_heapify(b, 1);
			}
			
		}
	
		
	public void HeapSort(int [] arr) {
		
		min_heap B = new min_heap(arr.length);
		B.arr = arr;			
		B.build_min_heap(B, arr);
		
		for(int i = B.heap_size; i >= 2; i -- ) {
			
			int temp = B.arr[1];
			B.arr[1] = B.arr[i];
			B.arr[i] = temp;
			
			B.heap_size--;
			B.min_heapify(B,1);
		}
		
		this.arr = B.arr;
		
	}
}

	public static void main(String[] args) throws Exception {
				
		 int [] holder = new int[10000];

		   String fileName = args[0];
		   
		   File file = new File(fileName);
		      
		      if(file.exists() == false){
		         throw new IllegalArgumentException("File doesn't exist!");
		      }
		       
		      Scanner fileRead = new Scanner(file);
	    
		      for(int i = 0; i < 10000; i++){        
		         holder[i] = Integer.parseInt(fileRead.nextLine());

		      }
		      fileRead.close();
		      
		  min_heap A = new min_heap(holder.length);
		  
		  A.build_min_heap(A, holder);
		     
	      while(fileRead.hasNextLine()){        
	          int n = Integer.parseInt(fileRead.nextLine());
	         A.is_min(A, n);
	         
	       }
	      	
	      A.HeapSort(A.arr);
			      
	      FileWriter write = new FileWriter("richest.txt");
	      
	      for(int i = 1; i < A.arr.length - 1; i++) {
	    	   	  
	    	  write.write(new Integer(A.arr[i]).toString() + "\n");
	      }
	      write.close();
	      
	}
	
}

