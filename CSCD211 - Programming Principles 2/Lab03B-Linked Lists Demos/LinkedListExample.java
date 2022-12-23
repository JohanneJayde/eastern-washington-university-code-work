/*
Name: Johanne McClenahan
Course#: CSCD211-F20
Description: created during class. Examples of using LinkedList class built in methods from java.util.LinkedLists
we practiced how to add and remove elements by index, learned how to change an element's contents, and
retrieving an element from the LinkedList

*/
import java.util.*;

public class LinkedListExample{
   public static void main(String [] args) {
   
   //Linked List Declaration
   LinkedList<String> linkedlist = new LinkedList<String>();
         
   //add(String Element) is used for adding the elements to the linked list
   linkedlist.add("Item1");
   linkedlist.add("item5");
   linkedlist.add("item3");
   linkedlist.add("item6");
   linkedlist.add("item2");
   
   //Display the linked list content
   System.out.println("Linked List content: " + linkedlist);
   
   //add first and last element
   linkedlist.addFirst("First Item");
   linkedlist.addLast("Last Item ");
   
   //Display the linked list content with new elements
   System.out.println("Linked List content after addition of new first and last elements: " + linkedlist);
   
   //setting and getting values from linked list
   Object firstVar = linkedlist.get(0);
   System.out.println("first element is: " + firstVar);
   linkedlist.set(0, "changed first item");
   Object firstVar2 = linkedlist.get(0);
   System.out.println("first element after update by set method: " + firstVar2);
   
   //remove first and last element
   linkedlist.removeFirst();
   linkedlist.removeLast();
   
   //Display the linked list content after removal of first and last elements
   System.out.println("Linked List content after deletion of first and last elements: " + linkedlist);
   
   //add to a position and remove from a position
   linkedlist.add(0, "new position element");
   linkedlist.remove(1);
   
   //Display the linked list content after alterations
   System.out.println("Linked List final contents: " + linkedlist);
  
}
}

