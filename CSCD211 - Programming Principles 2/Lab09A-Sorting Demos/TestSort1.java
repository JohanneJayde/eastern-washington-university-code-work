/*
Name: Johanne McClenahan
Class: CSCD21
Description:
TestSort1 is an example of using Collections.sort() to sort String objects

*/

//importing java.util.* in order to use Collections class, ArrayList class, and Iterator class
import java.util.*;

//TestSort1 Class
public class TestSort1{
   //main class
   public static void main(String [] args){
   
   //al is an ArrayList that stores String objects
   ArrayList<String> al = new ArrayList<String>();
   
   //using .add() from ArrayList class to add four String objects into ArrayList al
   al.add("Viru");
   al.add("Saurav");
   al.add("Mukesh");
   al.add("Tahir");
   
   //using Collections.sort() to sort al in ascending order
   Collections.sort(al);
   
   //creating an Iterator itr to iterate through al
   Iterator itr = al.iterator();
   
   //while-loop is used to check whether itr has more elements to iterate through
   while(itr.hasNext()){
      //Printing out each element of al using itr.next() until there is no elements left to iterate through
      System.out.println(itr.next());
   }
   
   }
}

