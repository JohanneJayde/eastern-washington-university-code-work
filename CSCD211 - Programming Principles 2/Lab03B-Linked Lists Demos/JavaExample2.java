/*
Name: Johanne McClenahan
Course#: CSCD211-F20
Description: created during class. Examples of using LinkedList class built in methods from java.util.LinkedLists
we practiced how to remove the first index and the last index. Also learned how to user iterators in order
make it easier to print a LinkedList's contents
*/

import java.util.*;

public class JavaExample2{
   public static void main(String [] args){
   
   LinkedList<String> list = new LinkedList<String>();  
   
   //Adding elements to the Linked list
   list.add("Steve");  //0
   list.add("Luka");   //1
   list.add("Raj");    //2
   list.add("Johnny"); //3
   list.add("Rick");   //4
   
   //Removing first element
   //Same as list.remeove(0);
   list.removeFirst();
   
   //Removing last element
   list.removeLast();
   
   //Iterating LinkedList
   Iterator<String> iterator = list.iterator();
   while(iterator.hasNext())
      System.out.print(iterator.next() + " ");
      
   //removing 2nd element, index starts with 0
   list.remove(1);
   
   System.out.print("\nAfter removing the second element: ");
   //Iterating the list again
   Iterator<String> iterator2 = list.iterator();
   while(iterator2.hasNext())
      System.out.print(iterator2.next() + " ");
   
   }
}