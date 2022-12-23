/*
Name: Johanne McClenahan
Course#: CSCD211-F20
Description: created during class. This is an example program for how to implement LinkedList
and how to print them. New elements of the the a linked list are added using different ways

*/
import java.util.Scanner;

public class LinkedList0 {

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
   
   public LinkedList0(){
      first = new Node("Debby");//building list for debby
      first.next = new Node("Elaine");
      first.next.next = new Node("Fred");
      first = new Node("Chuck", first);
      
      String [] names = {"Bob", "Allen"};
      
      for (String s : names)
         first = new Node(s, first);
   }  
    
   public void print(){
      Node ref = first;
      while(ref != null){
         System.out.print(ref.value + ", ");
         ref = ref.next;
      }
   }

public static void main(String [] args){
   LinkedList0 ll = new LinkedList0();
   String str = "The contents of the list is: ";
   System.out.print(str);
   ll.print();
   
}

}