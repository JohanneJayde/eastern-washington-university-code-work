/*
Name: Johanne McClenahan
Class: CSCD320-40
*/
import java.util.*;
import java.io.File;

public class OS_Finding{

   //partition() method takes an integer array and its bounding indices as int values.
   //The pivot value is chosen to the last number in the array. All values in the array are then compared
   //to the pivot value to see if they are larger or smaller. if the value is larger, then it wil be placed on
   //the right of the pivot value; smaller values will be placed to the left.
   //After all the values have been rearranged then the pivot value will be swapped into the position
   //that separates the larger values from the smaller values.
   //Lastly, the pivot value's position index is returned from the method.
   public static int partition(int [] arr, int left, int right){
   
      int pivot = arr[right];
      int index = left;
      
      //for-loop steps through arr, index is the eventual position that the pivot value will be.
      //Only when values are lower than the pivot will the index value be incremented. This is
      //because the number of smaller values increases by one so index needs to be ahead of the last
      //index of the smaller values or where the index where the lager values begin.
      for(int i = left; i < right; i++){
            if(arr[i] <= pivot){
                 //if arr[i] is found to be less than the pivot then the value will need to be swapped with the
                 //value in arr[index] because index is always at the end of the region of smaller values.
                 swap(arr, index, i);
                 index++;    
            }  
      }
      //this swaps the pivot value which is stored at the arr[right] into the arr[index] which is where the the seperation of
      //larger and smaller values happen.
      swap(arr, index, right);
      
      //pivot index is returned
      return index;
   }
   
   //basic swap method that takes an int array and then two indices and swaps the values at arr[i] and arr[j].
   public static void swap(int [] arr, int i, int j){
      //temp stores arr[j] so that it doesn't get lost when arr[j] is set to arr[i]
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   
   }
   
   //this method makes it so that any value in the input array can be the pivot value when partitioning.
   //This is achieved by using a random number generator with a range depending on the size of the index, or right,
   //once the random number between 0 and right has been generated, then it is swapped with the last element of the
   //array. This makes it so that when partition() is called, value at the randomly generated number index will now be
   //at the end which is where the pivot value is always.
   public static int randomized_partition(int [] arr, int left, int right){
   
      int randomInt = (int)(Math.random() * right);
      swap(arr, randomInt, right);
      return partition(arr, left, right);
      
   }
   
   //randomizedSelect finds the ith order statistic using divide and conquer method.
   //ith order statistic means the ith the smallest number in an array
   public static Object randomizedSelect(int [] arr, int left, int right, int i){
      //if i is out of bounds, then null is returned as there can't be an ith term
      //if arr is size of i - 3.
      if(i > arr.length){
         return null;
      }
      //base case: if there is only one element that that means it is automatically the
      //smallest order statistic and can be returned
      if(left == right){
         return arr[left];
      }
      
      //q is used as a way to separate the larger values than the smaller values relative to q.
      int q = randomized_partition(arr, left, right);
      //k represents the index at which all values including k index and after it will be larger
      //than the q.
      int k = q - left + 1;
      
      //if i is equal to k then that means that the ith order statistic is the pivot value so
      //the arr[q] is returned.
      if(i == k){
         return arr[q];
      }
      //if i is less than k then that means that it has a value that is less than the values of q.
      //this means you can recursively call the randomizedSelect() the indices of the first smaller value
      //to the ending smaller value. This also means you don't have to scan through the larger values.
      else if( i < k){
         return randomizedSelect(arr, left, q - 1, i);
      }
      //this means that the ith order statistic is the larger value region so that is scanned
      //using randomizedSelect() but with indices starting after the pivot value until end of the
      //larger value region.
      else{
         return randomizedSelect(arr, q + 1, right, i - k);
      }
   
   }
      
   public static void main(String[] args) throws Exception
   {
   //array to hold large values as number of lines in file input is undetermined
   int [] holder = new int[10000000];

   //fileName stores the file that will be read from inputted by the user via the command line
   String fileName = args[0];
   //num stores the position of the ith smallest number that the user wants to find
   int num = Integer.parseInt(args[1]);
   File file = new File(fileName);
      
      //checks if the file that the user inputted is able to be read from
      if(file.exists() == false){
         throw new IllegalArgumentException("File doesn't exist!");
      }
       
      //scanner used to read through file. 
      Scanner fileRead = new Scanner(file);
      //counter keeps track of number of lines or amount of elements that will be in the array
      //that will be inputted
      int count = 0;
    
      //while loop is used to read through file line by line and then add each line into
      //the holder array and increments count
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
      
      //prints out the ith order statistic for user
      System.out.println(randomizedSelect(arr, 0, arr.length - 1, num)); 

   }

}