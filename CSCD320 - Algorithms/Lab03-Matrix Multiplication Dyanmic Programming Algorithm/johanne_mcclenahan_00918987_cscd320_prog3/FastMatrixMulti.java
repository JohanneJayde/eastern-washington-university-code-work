/*
Name: Johanne McClenahan
Class: CSCD320-40
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FastMatrixMulti {

	public static class multiplicationBracks{
		protected int [][] timeComp;
		protected int [][] bracketPlacement;
		
		public multiplicationBracks(int [][] a, int [][] b) {
			this.timeComp = a;
			this.bracketPlacement = b;
		}
		
	}
	
	public static multiplicationBracks matrix_chain_order(int [] p){
		
		int n = p.length - 1;
		
		int [][] m = new int[n][n];
		int [][] s = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			m[i][i] = 0;

		}
		
			for(int h = 2; h <= n; h++) {				
				for(int i = 0; i < n - h + 1; i++) {	
					int j = i+h - 1;
					m[i][j] = 2147483647;
					
					for(int k = i; k <= j -1; k++ ) {
						int q = m[i][k] + m[k+1][j] + p[i] * p[k + 1] * p[j + 1];			
						if(q < m[i][j]) {
							m[i][j] = q;
							
							s[i][j] = k;

						}				
					}						
				}
			}	
			
		multiplicationBracks A = new multiplicationBracks(m,s);
	
		return A;
	}
	
	public void print_optimal_parens(int [][] s,int i,int j){
		
		if (i==j) {
			int k = i + 1;
			System.out.print("A" + k);
		}
		
		else {
			System.out.print("(");
				print_optimal_parens(s,i,s[i][j]);
				print_optimal_parens(s,s[i][j] + 1, j);
			System.out.print(")");
		}
					
	}

	public static void main(String[] args) throws Exception {
		
		  //array to hold large values as number of lines in file input is undetermined
		   int [] holder = new int[10000000];

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
		         holder[count] = Integer.parseInt(fileRead.nextLine());
		         count++;
		      }
		      //arr stores the elements from the file but is the proper size to use in finding ith order statistic
		      int [] arr = new int[count];
		      
		      //for-loop used to copy over data to arr from holder array
		      for(int i = 0; i <= arr.length - 1; i ++){
		        arr[i] = holder[i];
		     }
		
		FastMatrixMulti A = new FastMatrixMulti();		
		
		multiplicationBracks B = A.matrix_chain_order(arr);
		
		A.print_optimal_parens(B.bracketPlacement, 0, arr.length - 2);
		System.out.println();
		System.out.println(B.timeComp[0][arr.length - 2]);
	}

}
