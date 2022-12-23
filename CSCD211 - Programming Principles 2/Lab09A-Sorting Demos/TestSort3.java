/*
Name: Johanne McClenahan
Class: CSCD21
Description:
TestSort3 is an example of sorting Wrapper class objects
Wrapper class objects are used to treat primitive data types as objects such as int to Integer

*/

//importing java.util.* in order to use Collections class, ArrayList class, and Iterator class
import java.util.*;

//TestSort3 Class
public class TestSort3{
   //main class
   public static void main(String [] args){
   
      //al is an ArrayList that stores objects
      ArrayList al = new ArrayList();
      
      //using .add() from ArrayList class to add three Integer objects into ArrayList al
      //Integer.valueOf() is used to convert int primitive value into Integer object
      al.add(Integer.valueOf(201));
      al.add(Integer.valueOf(101));
      al.add(230); //internally will be converted into objects as integer.valueOf(230)
   
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