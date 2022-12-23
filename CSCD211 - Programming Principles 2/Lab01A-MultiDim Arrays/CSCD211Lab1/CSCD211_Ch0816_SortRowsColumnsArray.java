
/*
Johanne McClenahan - CSCD211 Lab01 from Ch08 Section16 - SortRowsColumnsArray

Objective of Program: 
1. Write a method to sort a two-dimensional array
2. Method header must be: public static void sort(int m[][])
3. Display sorted matrix row by row to users
4. Display format is: [column#0], [column#1]
*/
public class CSCD211_Ch0816_SortRowsColumnsArray{
//main method
public static void main(String [] args) {
//define array which is a 6x2 array and holds 12 elements
   int [][] array = {{4,2},{1,7},{4,5},{1,2},{1,1},{4,1}};
//calling the sort method that sorts the array that is passed to it (in this case, array is passed)
   sort(array);
//cycles through each row and prints the first column, then a comman, followed by the second column 
   for(int i = 0; i < array.length; i++){
         System.out.println(array[i][0] + ", " + array[i][1]);
   }

}
//sort method that takes in an array that is used to sort the first column, followed by the second column if needed
public static void sort(int m[][]){
//sorts the array's first and second column in ascending order
   for(int i = 0; i < m.length; i++) {
      int temp = m[i][0];
//sorting the first column from lowest to highest
      for(int j = i+1; j < m.length; j++) {
         if(m[i][0] > m[j][0]) {
            temp = m[i][0];
            m[i][0] = m[j][0]; 
            m[j][0] = temp;
//sorting the second column based on the sorted first column
            temp = m[i][1];
            m[i][1] = m[j][1]; 
            m[j][1] = temp;
          }
//checks whether or not the two first column elements are the same which determines if the corresponding second column elements need to be sorted
         if(m[i][0] == m[j][0]) {
//sorts the second column from lowest to highest (first column elements have already been checked to be the same, preserving the sorted first column elements)
            if(m[i][1] > m[j][1]) {                
               temp = m[i][1];
               m[i][1] = m[j][1]; 
               m[j][1] = temp;
            }
         }
      }
   }

}

}