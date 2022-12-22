package lab14.cscd210comparators;

import java.util.Comparator;
import lab14.cscd210classes.*;

public class BookISBNComparator implements Comparator<Book> 
{
   @Override
   public int compare(final Book o1, final Book o2) {
   
      return o1.getISBN().compareTo(o2.getISBN());
   
 }
} 