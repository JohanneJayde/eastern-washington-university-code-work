package lab2.cscd211classes;


public class Publisher
{

private String city;
private String name;

public Publisher(String name, String city){
   this.city = city;
   this.name = name;
}

public int compareTo(Publisher pi){
   return pi.getPubName().compareTo(this.name);

}

public String getPubCity()
{return this.city;}
public String getPubName()
{return this.name;}

@Override
public String toString(){
   return (this.name + ", " + this.city);

}

}