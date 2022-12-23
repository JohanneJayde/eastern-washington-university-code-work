/*
Name: Johanne McClenahan
Class: CSCD21
Description:
CollectionsDemo demonstrates how to use the Collections.sort() method on an ArrayList.
Program also uses Arrays.asList() to convert Array into arrayList.

*/

//importing java.util.* in order to use ArrayList Class and Collections Class
import java.util.*;

//CollectionsDemo class 
public class CollectionsDemo {
   //main class
   public static void main(String [] args) {
   
   //initializing an Array with String objects named init
   String init[] = {"One", "Two", "Three", "One", "Two", "Three"};
   
   //list stores init after calling Arrays.asList(init) to convert Array into ArrayList
   List list = new ArrayList(Arrays.asList(init));
   
   //displaying the list before calling a Collections.sort() method to sort the list
   System.out.println("List value before: "  + list);
   
   //using Collections.sort() method from Collections class to sort list in ascending order
   Collections.sort(list);
   
   //displaying the list after calling a Collections.sort() method, sorting the list
   System.out.println("List value after sort: " + list);
   
   }


}