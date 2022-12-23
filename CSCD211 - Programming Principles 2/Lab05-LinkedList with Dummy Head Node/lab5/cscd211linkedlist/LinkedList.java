package lab5.cscd211linkedlist;
import java.util.*;
/**
Name: Johanne McClenhan
Class: CSCD211
Description: LinkedList class with dummy head node along with method that are used to print, add, remove, check, the list
 * The LinkedList class with a dummy head node
 * @NOTE All preconditions will be met and all parameters will be final
 */
public class LinkedList<T extends Comparable <? super T>>
{
	/**
	 * The private Node class as discussed in class
	 */
   private class Node
   {
	   /**
	    * The Node class data element as T which is a generic that is Comparable
	    */
      public T data;
      
      /**
       * The Node class next reference for the singly linked list
       */
      public Node next;
      
      /**
       * The node class constructor that only takes the data item
       * @param data Representing the data 
       */
      public Node(final T data)
      {
    	  this.data = data;
    	  this.next = null;

      }
      
      /**
       * The node class constructor that takes the data item and the next
       * reference 
       * @param data Representing the data
       * @param next Representing the next reference
       */
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   /**
    * The Class Level Head reference that allows us access to the list
    */
   private Node head;
   
   /**
    * The variable size that is a convenience for us
    */
   private int size;
   
   /**
    * Constructs an empty list.<br>
    * Dummy Head Node
    */
   public LinkedList()
   {
      this.head = new Node(null);
      this.size = 0;
   }
   
   /**
    * Returns the number of elements in this list.
    *
    * @return int  - Representing the size
    */
   public int size()
   {
      return this.size;
   }
   
   /**
    * Removes all of the elements from this list. 
    * The list will be empty after this call returns.    
    */
   public void clear()
   {
      this.head = null;
      this.size = 0;
      
   }
   
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
         throw new IllegalArgumentException("bad params. item is null");
   //itemToAdd is used to store the item that is being added to the LinkedList as a Node object      
     Node itemToAdd = new Node(item);
   //temp is used to store the reference to the head node of the LinkedList as a Node object   
     Node temp = this.head;
   //temp.next is append to itemToAdd.next so that the first Node of head is the next Node of itemToAdd  
     itemToAdd.next = temp.next;
   //itemToAdd is append to temp.next so that the dummy head Node is attached to the new first Node
     temp.next = itemToAdd;
   //size is decreased by 1  
     this.size++; 
   }
   
   
   /**
    * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    *
    * @param item The item to find
    * @return int - The index if found or -1
    *
    * @throws IllegalArgumentException if item is null
    */
   public int indexOf(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //temp stores the reference to the first Node of the LinkedList      
      Node temp = this.head.next;
   //dataToFind is used to store the item that is being searched for   
      T dataToFind = item;
   //index keeps track of the index value of each Node of the LinkedList as an integer value   
      int index = 0;
   //for-loop is used to traverse the LinkedList
         for(int i = 0; i < size(); i++){
         //if-statement is used to check whether a Node's data field is equal to dataToFind
            if(temp.data.equals(dataToFind) == true){
            //index is returned if the a Node's data field was equal to dataToFind
               return index;
            }
         //else-statement used to traverse LinkedList by moving head up by one            
            else{
               temp = temp.next;
            }
         //index is increased by 1 each time the loop iterates
            index++;
            }
   //if the loop iterates and dataToFind is not found, -1 is returned         
      return -1;
   }
   
   
   /** 
    * Removes and returns the first element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeFirst()
   {
      if(this.head == null)
         throw new NoSuchElementException("list is empty");
   //temp is used to store reference to dummy head node
      Node temp = this.head;
   //firstElement stores first Node's data field   
      T firstElement = temp.next.data;
   //temp.next is append so that it is now temp.next.next, deleting the first Node by attaching the dummy head node to the 2nd Node
      temp.next = temp.next.next;
   //size is decreased by 1
      this.size--;
   //first element is returned          
      return firstElement;
   }
   
   /** 
    * Removes and returns the last element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeLast()
   {
      if(this.head == null)
         throw new NoSuchElementException("list is empty");
   //temp used to store reference to dummy head node   
      Node temp = this.head;
   //lastElement stores the last Node's data field   
      T lastElement;
   //while loop used to traverse through LinkedList until it reaches the last Node  
         while(temp.next != null){
               temp = temp.next;
            }
   //lastElement is set to last Node's data field          
      lastElement = temp.data;
   //last Node is set to null   
      temp = null;
   //size is decreased by 1   
      this.size--;
   //lastElement is returned
      return lastElement; 
   }
   
   /**
    * Removes the element at the specified position in this list. 
    * Shifts any subsequent elements to the left (subtracts one from their indices). 
    * Returns the element that was removed from the list.
    *
    * @param index The index of the element to be removed
    * @return T - The element previously at the specified position
    *
    * @throws IndexOutOfBoundsException - if the index is out of range (index less than 0 || index greater than or equal to size())
    */   
   public T remove(final int index)
   {
      if(index < 0 || index >= size())
         throw new IndexOutOfBoundsException("index is out of range");
   //curr is used to store reference to first element of LinkedList
      Node curr = this.head.next;
   //prev is used to store reference to dummy head node   
      Node prev = this.head;
   //removedElement stores the element that is removed   
      T removedElement;
   //for-loop used to traverse the LinkedList until it reaches index of Node that is to be removed 
      for(int i = 0; i < index; i++){
         prev = curr;
         curr = curr.next;
         
      }
   //if-statement is used to check if element to be removed is the last element
   //in this case, prev.next is set to null which erases the element that is to be removed   
         if(curr.next == null){
            removedElement = curr.data;
            prev.next = null;
         }
   //if element to be removed is not the last element, then prev.next = curr.next which unlinks the unwanted Node
         else{
            removedElement = curr.data;
            prev.next = curr.next;
         }
   //size is decreased by 1      
      this.size--;
   //removedElement is returned   
      return removedElement;
   }
   
   /**
    * Inserts the specified element at the specified position in this list. 
    * Shifts the element currently at that position (if any) and any subsequent 
    * elements to the right (adds one to their indices).
    *
    * @param index The index at which the specified element is to be inserted
    * @param item The element to be inserted
    *
    * @throws IndexOutOfBoundsException if the index is out of range (index less than 0 || index greater than size())
    * @throws IllegalArgumentException if item is null
    */
   public void add(final int index, final T item)
   {
      if(index < 0 || index >= size())
         throw new IndexOutOfBoundsException("index is out of range");   
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //curr stores the reference to the first Node
      Node curr = this.head.next;
   //prev stores the reference to the dummy head node   
      Node prev = this.head;
   //addElmeent stores the item to be added as a Node object   
      Node addElement = new Node(item);
   //for-loop used to traverse LinkedList until it reaches the desired index
      for(int i = 0; i < index; i++){
         prev = curr;
         curr = curr.next;
      }
   //if the index is the last element, it is append to the end   
         if(curr.next == null){
            curr.next = addElement;
         }
   //addElement.next is append so that all elements after it are shifted to the right
   //prev.next = addElement so that it is connected to all the original nodes that come before it, retaining the order      
         else{
            addElement.next = curr;
            prev.next = addElement;
         }
   //size is increased by 1      
      this.size++;

   }
   
   /**
    * Removes the last occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeLastOccurrence(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //calls contain method to check whether or not the passed in item is in the LinkList, if it isn't false is returned      
      if(contains(item) == false){
            return false;
      }
   //curr stores the reference to the first Node for the LinkList
      Node curr = this.head.next;
   //prev stores the reference to the dummy head Node   
      Node prev = this.head;
   //addressOfElement is used to store the reference of Node's data that matches the passed in item     
      Node addressOfElement = new Node(null);
   //dataToFind stores the item being passed in   
      T dataToFind = item;
   //for loop is used to traverse LinkdList
         for(int i = 0; i < size(); i++){
         //if a Node's data is found to be the same as dataToFind, addressOfElement stores that Node's reference
         //after the Node's reference is stored, the listed are traversed as normal
            if(prev.next.data.compareTo(dataToFind) == 0){
               addressOfElement = prev;
               prev = curr;
               curr = curr.next;
              
            }            
            else{
         //if a Node's data does not match the dataToFind, the list is traversed again   
               prev = curr;
               curr = curr.next;
               }
            }
         //addressOfElement's next field is set to the 3rd Node in the list, which erases the 2nd Node 
         //the 2nd Node stored the reference to the last occurrence of dataToFind as 
         //addressOfElement was changed if a later Node's data also matched dataToFind and set to that 
               addressOfElement.next = addressOfElement.next.next;
         //size is decreased by 1       
               this.size--;
         //true is returned      
               return true;
            
   }

   /**
    * Removes the first occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeFirstOccurrence(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //curr stores the reference to the first Node for the LinkList         
      Node curr = this.head.next;
   //prev stores the reference to the dummy head Node   
      Node prev = this.head;
   //dataToFind stores the item being passed in    
      T dataToFind = item;
   //for loop is used to traverse LinkdList
         for(int i = 0; i < size(); i++){
         //if a node's data is found to be equal to dataToFind, prev's next is connected too curr's next, erasing the node
            if(curr.data.compareTo(dataToFind) == 0){
               prev.next = curr.next;
         //size is decreased by 1      
               this.size--;
         //true is returned      
               return true;
              
            }
         //LinkedList is traversed again                
            else{
               prev = curr;
               curr = curr.next;
            }
            }
        //if-loop iteration is done, and no Node's data was found to be equal, size is decreased by 1 and false is returned    
            this.size--;
            return false;
   }

   /**
    * Appends the specified element to the end of this list.
    * 
    * @param item The element to be added to this list
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addLast(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //temp is used to store the reference to the dummy head node      
      Node temp = this.head;
   //while-loop used to traverse the LinkedList until head references the last Node
      while(temp.next != null){
               temp = temp.next;
            }
   //new Node is created with passed in item and it is append to temp which is now refers the last item of the list
      temp.next = new Node(item);
   //size is increased by 1   
      this.size++;
      
   
   }

   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String - Representing the contents of the list
    */
   public String toString()
   {
   //temp is used to store dummy head node
      Node temp = this.head;
   //if list is empty, it returns an empty list   
      if(temp == null){
      return "[ ]";
      }
   //temp is moved forward by 1 so that the dummy head node isn't printed   
      temp = temp.next;
   //String LinkedList is used to store the string representation of the LinkedList in desired format
      String LinkedList = "[";
      for(int i = 0; i < size() - 1; i++){
   //Each Node's data field is added to LinkedList
         LinkedList = LinkedList + (temp.data + ", ");
   //head Node is moved forward by 1
         temp = temp.next;
      }       
   //Last Node's data is added along with a bracket to LinkedList   
      LinkedList = LinkedList + temp.data + "]";
   //String is returned to where it was called
      return LinkedList;
   }
   
   /**
    * Returns true if this list contains the specified element. 
    * More formally, returns true if and only if this list contains at 
    * least one element AKA first occurrence
    *
    * @param item The element whose presence in this list is to be tested
    * @return boolean - true if this list contains the specified element
    *
    * @throws IllegalArgumentException if item is null
    */
   public boolean contains(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("bad params. item is null");
   //curr stores the reference to the first Node         
      Node curr = this.head.next;
   //prev stores the reference to the dummy head node   
      Node prev = this.head;
   //dataToFind stores the item that is being checked
      T dataToFind = item;
   //for-loop is used to traverse the LinkedList
         for(int i = 0; i < size(); i++){
         //if a Node's data is found to be equal to dataToFind, true is returned
            if(curr.data.compareTo(dataToFind) == 0){
               return true;
              
            }            
            else{
         //if a Node's data isn't equal, the list is traversed again
               prev = curr;
               curr = curr.next;
            }
            }
   //if the loop iteration is done but true isn't returned, then false is returned as dataToFind wasn't found in LinkedList   
            return false;
   }
   
   

}