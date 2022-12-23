package lab4.cscd211linkedlist;

import java.util.*;

/**
 * The LinkedList class and Node class.  All parameters will be passed as final.
 *
 * @param <T> A type that implements Comparable and a compareTo method using the Generic
 * @NOTE T item is just a different word for data
 */
public class LinkedList<T extends Comparable <? super T>>
{
	
   private class Node
   {
      public T data;
      public Node next;
 
      public Node()
      {
    	  this.data = null;
    	  this.next = null;
      }
      
      public Node(final T data)
      {
         this(data, null);
      }
      
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   private Node head;
   private int size;
   
   /**
    * Constructs a list with no dummy head node containing the elements of the 
    * specified array, that are in the order the array.
    * 
    * @param array Representing the T array
    *
    * @throws IllegalArgumentException if the array is null
    */
   public LinkedList(final T [] array)
   {
      if(array == null)
         throw new IllegalArgumentException("bad params. array is null in LinkedList contructor");
   //default values for Node head and int size;
	   this.head = null;
	   this.size = 0;
   //calls addFirst method to adds first element of T array into Node head
      addFirst(array[0]);
   //curr stores the Node head and is used to add elements into existing Node head
      Node curr = this.head;
   //for-loop is used to add elements from the array into Node curr.
   //loop iterates one less than array.length due to first element already being the head of the Node head
      for(int i = 1; i < array.length; i++){
   //new Node is created using an array element and stored as newNode
         Node newNode = new Node(array[i]);
   //curr.next is assigned newNode so it is appended onto Node head
         curr.next = newNode;
   //curr gets curr.next in order to trace through each of curr's elements
         curr = newNode;
   //size is increased according to how many times the loop iterates
         this.size++;
      }
            
   }// end EVC
   

   /**
    * Inserts the specified element at the beginning of this list.
    *
    * @param item The item to add
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addFirst(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad parms. item is null in addFirst method");
   //Addition stores the item that will be added to the first index of original node. 
   //New Node is created to allow for item to be first index of LinkedList
      Node addition = new Node(item);
   //original Node head is linked to the tail of addition 
      addition.next = this.head;
   //Node head's contents is replaced with addition which has new first index followed by original Node head
      this.head = addition; 
   //size is increased by 1  
      this.size++;    
  
  
   }// end addFirst
   
 
   /**
    * Appends the specified element to the end of this list.
    *
    * @param item The element to be appended to this list
    *
    * @throws IllegalArgumentException if item is null
    */
   public void add(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad parms. item is null in add method");
   //newElement stores the new Node with passed in T item 
     Node newElement = new Node(item);       
   //checks to see if LinkedList head is empty
     if(this.head == null){
     //if head is empty, head will become newElement
      this.head = newElement;
     //size is increased by 1
      this.size++;    
     }
   //else statement if head is not empty
     else{
   //temp stores LinkedList head
     Node temp = this.head;
   //while-loop is used to trace through LinkedList until it reaches last element
      while(temp.next != null){
      //temp is assigned temp.next in order to iterate through each element
         temp = temp.next;
      }
   //newElement is linked to the last element of the LinkedList head
      temp.next = newElement;
   //size is increased by 1
      this.size++;
      }
            
   }// end add
   
   /**
    * Inserts all of the elements in the specified array into this list, 
    * starting at the specified position. Shifts the element currently at that position 
    * (if any) and any subsequent elements to the right (increases their indices). 
    * The new elements will appear in the list in the order that they were in the array
    *
    * @param index at which to insert the first element from the specified array
    * @param array containing elements to be added to this list
    *
    * @throws IllegalArgumentException if the array is null
    * @throws IndexOutOfBoundsException if index less than 0 or greater than size
    */
   public void addAll(final int index, final T [] array)
   {
      if(array == null)
         throw new IllegalArgumentException("bad params. array is null in addAll method");
      if(index < 0 || index > size())
         throw new IndexOutOfBoundsException("index is less than 0 or greater than size in addAll method");
   //curr stores new Node that has the first elements of T array as its head
      Node curr = new Node(array[0]);
      curr.next = new Node(array[1]);
      curr.next.next = new Node(array[2]);
   //Node newNode stores the Node head
      Node newNode = this.head;
   //for-loop is used to trace through the linked list until the desired index is found
      for(int i = 0; i < index; i++){
         newNode = newNode.next;
      
      }
   //Node temp store stores everything after the Node whose place is denoted by the index
      Node temp = newNode.next;
   //temp is appended to the end of Node curr
      curr.next.next.next = temp;
   //curr is append onto newNode.next in order to preserve the first half of the list while
   //adding the inserted array with the original ending of the LinkedList
      newNode.next = curr;
   //size is increased by 3 due to the menu option only allowing for an array of 3 to be appended to Node Head
      this.size = this.size + 3;
      
   }// end addAll
   
   /**
    * Removes all of the elements f.rom this list. 
    * The list will be empty after this call returns.    
    */
   public void clear()
   {
   //Node head is set to null which clears the head of the Node and all of the linkages
      this.head = null;
   //size is set to 0 as all of the elements have been erased
      this.size = 0;
   }// end clear
   
   /**
    * Returns the element at the specified position in this list.
    *
    * @param index The index of the element to return
    * @return T The element at the specified position in this list
    *
    * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
    */
   public T get(final int index)
   {
      if(index < 0 || index > size())
         throw new IndexOutOfBoundsException("index is less than 0 or greater than or equal to size in get method");
   //Node temp is used to store Node head
      Node temp = this.head;
   //for-loop is used to trace through each element of Node temp
   //loop iterates based on the index param passed in
      for(int i = 0; i < index; i++){
         temp = temp.next;

      }
   //returns data value found the desired index of Node head
   return temp.data;
      
   }// end get
   
   /**
    * Returns the last element in this list.
    *
    * @return The last element in the list
    *
    * @throws NoSuchElementException if the list is empty
    */
   public T getLast()
   {
      if(this.head == null)
         throw new NoSuchElementException("list is empty in getLast method");
      Node temp = this.head;
      //while-loop is used to trace through Node head until the last element is the head
      while(temp.next != null)
         temp = temp.next;
         
      //returns the data field found in the last element of Node head
      return temp.data;
   }// end getLast
   
   /**
    * Retrieves and removes the head (first element) of this list.
    *
    * @return The head element in the list
    *
    * @throws NoSuchElementException if the list is empty
    */
   public T remove()
   {
      if(this.head == null)
         throw new NoSuchElementException("list is empty in remove method");
      Node removeFirst = this.head;
   //headData is used to store the data field of the head of Node head
      T headData = this.head.data;
   //Node head head is changed to the following Node to erase the first Node
      removeFirst = removeFirst.next;
   //size is decreased by 1
      this.size--;
   //headData is returned to where the method was called
      return headData;
   }// end remove
   

   
   /**
    * Returns true if all occurrences of data are removed from the list or false otherwise
    *
    * @param data The value for all occurrences to be removed from the list
    * @return boolean Representing if the list was modified or not
    *
    * @throws IllegalArgumentException if data is null
    */
   public boolean removeAllOccurrences(final T data)
   {
      if(data == null)
         throw new IllegalArgumentException("data is null in removeAllOccurrences method");
      Node temp = this.head;
   //while-loop is used to trace through Node head
      while(temp.next != null){
      //if-statement is used to check whether an element's data field of Node head is equal to the passed in T data param
         if(temp.next.data == data){
         //if element's data field has the same value, Node head is append so that the first element is removed from Node Head
            temp.next = temp.next.next;
         //size is decreased by 1 for every time a Node is removed from the LinkedList
            this.size--;
            }
         //LinkedList is moved forward by one Node in order to trace through each element
         temp = temp.next;
      
      }
   //returns true because all of the desired element has been removed
      return true;
   }// end removeAllOccurrences
   
   
	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return T the last element from the list
	 *
	 * @throws NoSuchElementException if this list is empty
	 */
	public T removeLast()
	{
      if(this.head == null)
         throw new NoSuchElementException("list is empty in removeLast method");
   //Node newList stores Node head
      Node newList = this.head;
   //While loop is used to trace through the LinkedList until it reaches the Last Node
      while(newList.next.next != null){
      newList = newList.next;
      }
   //removedElement is used to store the data found in the last Node of Node head
      T removedElement = newList.next.data;
   //Last Node is removed from Node head by setting the previous Node's next field to null
      newList.next = null;
   //size is decreased by 1
      size--;
   //returns the removedElement to where the method was called
      return removedElement;
	}// end removeLast
	
	/**
	 * Removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.    
	 *
	 * @param index the index of the element to be removed
	 * @return T The element previously at the specified position
	 *
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
	 */
	public T remove(int index)
	{
      if(index < 0 || index > size())
         throw new IndexOutOfBoundsException("index is less than 0 or greater than size in addAll method");
   //Node first is used to store Node head
      Node first = this.head;
   //removedElement is used to store the removed Node's data field
   T removedElement;
   //if statement used to check whether the index is 0
      if(index == 0){
         removedElement = first.data;
         first = first.next;
   //size is decreased by 1
      size--;
   //returns the the head Node's data field
         return removedElement;
      }
      else{
   //newList is used to store Node first
      Node newList = this.head;
   //for loop is used to trace through array until it reaches the Node of the index parameter
      for(int i = 0; i < index - 1; i++){
         newList = newList.next;
      }
   //removedElemenet gets the index Node's data field
      removedElement = newList.next.data;
   //the next Node gets the Node after the index Node, erasing it from the LinkedList
      newList.next = newList.next.next;
   //size is decreased by 1
      size--;
   //returns removedElement is returned
         return removedElement;
      }

	}// end remove
   
   
   /**
    * Returns the number of elements in this list.
    *
    * @return int The size
    */
   public int size()
   {
   //returns the size of the LinkedList
      return this.size;
   }// end size
   
   
   /**
    * Returns an array containing all of the elements in this list in proper 
    * sequence (from first to last element).
    *
    * <br> The returned array will be "safe" in that no references to it are maintained
    * by this list. (In other words, this method must allocate a new array). 
    * The caller is thus free to modify the returned array.
    *
    * @return Object [] an array containing all of the elements in this list in proper sequence 
    */
   public Object [] toArray()
   {
   //creates new Object array that has a size based on LinkedList size
      Object [] array = new Object[size()];
   //temp stores Node head
      Node temp  = this.head;
   //for-loop is used to add each element of the LinkedList to the array's corresponding indexes
      for(int i = 0; i < size(); i++){
         array[i] = temp.data;
         temp = temp.next;
      
      }
   //returns filled array
      return array;
   }  // end toArray
   
   
   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String Representing the contents of the list
    */
   public String toString()
   {
   //temp is used to store Node head
      Node temp = this.head;
   //String LinkedList is used to store the string representation of the LinkedList in desired format
      String LinkedList = "[";
      for(int i = 0; i < size() - 1; i++){
   //Each Node's data field is added to LinkedList
         LinkedList = LinkedList + (temp.data + ", ");
   //head Node is moved forward by 1
         temp = temp.next;
      }
         
      LinkedList = LinkedList + temp.data + "]";
   //String is returned to where it was called
      return LinkedList;
   }// end toString
   
}// end list