package lab14.cscd210classes;

public class Book implements Comparable<Book> 
{
   private String author;
   private String isbn;
   private int pages;
   private String title;

   public Book(final String title, final String isbn, final int pages, final String author)
   {
   if(title == null || title.isBlank() == true)
      throw new IllegalArgumentException("title is a either null or blank in Book class");
   if(isbn == null || isbn.isBlank() == true)
      throw new IllegalArgumentException("isbn is a either null or blank in Book class");
   if(author == null || author.isBlank() == true)
      throw new IllegalArgumentException("author is a either null or blank in Book class");
   if(pages < 1)
      throw new IllegalArgumentException("pages is less than 1 in Book class");
   
      this.author = author;
      this.isbn = isbn;
      this.pages = pages;
      this.title = title;
   }
   public String getISBN() {
      return this.isbn;
   }
   public int getPages() {
      return this.pages;
   }
   @Override
   public String toString() {
   String str = "Title: " + this.title + "\nAuthor: " + this.author + "\nISBN: " + this.isbn + "\nPages: " + this.pages;
      return str;
   }
   @Override
   public boolean equals(Object obj) {
      if(obj == null) return false;
      if(obj == this) return true;
      if(obj instanceof Book == false) return false;
      Book another = (Book)obj;
   
   return this.title.equals(another.title) && this.author.equals(another.author) && Integer.valueOf(this.pages).equals(Integer.valueOf(another.pages)) && this.isbn.equals(another.isbn);
   
   }
   @Override
   public int hashCode() {
   int num = this.title.hashCode() + this.author.hashCode() + this.isbn.hashCode();
   
   return num;
   }
   @Override
   public int compareTo(Book another) {
   if(another == null)
      throw new IllegalArgumentException("another is null in compareTo method");
   
  int resultAuthors = this.author.compareTo(another.author);
      if(resultAuthors != 0)
         return resultAuthors;
  int resultTitles = this.title.compareTo(another.title);
      if(resultTitles != 0)
         return resultTitles;
  int resultPages = this.pages - another.pages;
      if(resultPages != 0)
         return resultPages;
  int resultISBN = this.isbn.compareTo(another.isbn);
      if(resultISBN != 0)
         return resultISBN; 
         
     return 0;
   }
}