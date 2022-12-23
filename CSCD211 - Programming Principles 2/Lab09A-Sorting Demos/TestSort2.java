/*
Name: Johanne McClenahan
Class: CSCD21
Description:
TestSort2 is an example of sorting an ArrayList in reverse order
Collections.sort() is used to sort while Collections.reverseOrder() is used to modify the sorting so its in descending order

*/

//importing java.util.* in order to use Collections class, ArrayList class, and Iterator class
import java.util.*;

//TestSort2 Class
public class TestSort2{
   //main class
   public static void main(String [] args){
   
   //al is an ArrayList that stores String objects
   ArrayList<String> al = new ArrayList<String>();
   
   //using .add() from ArrayList class to add four String objects into ArrayList al
   al.add("Viru");
   al.add("Saurav");
   al.add("Mukesh");
   al.add("Tahir");
   
   //using Collections.sort() and Collections.reverseOrder() to sort al in descending order
   Collections.sort(al, Collections.reverseOrder());
   
   //creating an Iterator itr to iterate through al
   Iterator itr = al.iterator();
   
   //while-loop is used to check whether itr has more elements to iterate through
   while(itr.hasNext()){
      //Printing out each element of al using itr.next() until there is no elements left to iterate through
      System.out.println(itr.next());
   }
   
   }
}