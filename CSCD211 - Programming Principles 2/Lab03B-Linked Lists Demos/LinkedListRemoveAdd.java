/*
Name: Johanne McClenahan
Course#: CSCD211-F20
Description: created during class. This is an example program for how to implement LinkedList
and how to print them. This is an edit version of LinkedList0 but with more methods that were implemented.
adding an element to the beginning, removing the last element, removing an element based on index, and
adding an element to the end of the list were all implement using the lectures in class. Clear
method is also included that clears a LinkedList of its contents.
*/
import java.util.Scanner;

public class LinkedListRemoveAdd {

private class Node{

   String value;   
   Node next;

      Node(String val, Node n){
         this.value = val;
         next = n;
         
      }
      
      Node(String val){
         this.value = val;
         next = null;
      
      }
   }
      
   private Node first = null;
   private int size = 0;
   
   public LinkedListRemoveAdd(){
      first = new Node("Debby");//building list for debby
      first.next = new Node("Elaine");
      first.next.next = new Node("Fred");
      first = new Node("Chuck", first);
      
      String [] names = {"Bob", "Allen"};
      
      for (String s : names)
         first = new Node(s, first);
      size = 6;
   }  
    
   public void print(){
      Node ref = first;
      while(ref != null){
         System.out.print(ref.value + ", ");
         ref = ref.next;
      }
   }
  void clear(){
      size = 0;
      first = null;
      }
      
   String removeIndex(int index){
   if(index < 0 || index >= size)
      throw new IllegalArgumentException("index is less than 0 or greater than or equal to size");
   String removedElement;
      if(index == 0){
         removedElement = first.value;
         first = first.next;
      }
      Node newList = first;
      
      for(int i = 0; i < index - 1; i++){
         newList = newList.next;
      }
      removedElement = newList.next.value;
         newList.next = newList.next.next;
         return removedElement;
         
   }
   
   void removeLast()
	{
      Node newList = first;
      
      while(newList.next.next != null){
      
      newList = newList.next;
      }
      
      newList.next = null;
      size++;
	}
   
  void addFirst(String val){
  
      Node newElement = new Node(val);   
      newElement.next = first;     
      first = newElement;
      size = size + 1;

   }

   public void add(String val)
   {

     Node endElement = new Node(val);    
     if(first == null)
         first = endElement;
     
     Node temp = first;
     
      while(temp.next != null){
      
      temp = temp.next;
      }
      
      temp.next = endElement;
      size++;
      
   }

public static void main(String [] args){
   LinkedListRemoveAdd ll = new LinkedListRemoveAdd();
   String str = "The contents of the list is: ";
   System.out.print(str);
   ll.print();
 
   ll.removeIndex(5);
   System.out.print("\n" + str);
   ll.print();
   
   ll.addFirst("Ronald");
   System.out.print("\n" + str);
   ll.print();
   
   ll.add("Johnny");
   System.out.print("\n" + str);
   ll.print();
   
   ll.removeLast();
   System.out.print("\n" + str);
   ll.print();
   
   ll.clear();
   System.out.print("\n" + str);
   ll.print();

}

}