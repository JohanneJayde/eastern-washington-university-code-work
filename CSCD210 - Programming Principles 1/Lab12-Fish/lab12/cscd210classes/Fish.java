package lab12.cscd210classes;

public class Fish implements Comparable<Fish>
{
   private String species;
   private double weight;

public Fish(final String species, final double weight) {
   if(species == null)
      throw new IllegalArgumentException("species is null in Fish");
   if(species.isBlank())
      throw new IllegalArgumentException("species is blank in Fish");
   if(weight < 0.01)
      throw new IllegalArgumentException("weight is than 0.01");
      
      this.species = species;
      this.weight = weight;
   
  }
@Override   
public String toString() {
   String str = this.species + " - " + this.weight;
      return str; 

}
@Override
public boolean equals(Object obj) {
   if(obj == null) return false;
   if(obj == this) return true;
   if(obj instanceof Fish == false) return false;
   Fish another = (Fish)obj;
   
   return this.species.equals(another.species) && Double.valueOf(this.weight).equals(Double.valueOf(another.weight));
}
@Override
public int hashCode() {
   int num = this.species.hashCode() + Double.hashCode(this.weight); 
   return num;
}
@Override
public int compareTo(Fish another) {
   if(another == null)
      throw new IllegalArgumentException("another is null in compareTo method");
      
   int resultSpecies = this.species.compareTo(another.species);
   if(resultSpecies != 0)
      return resultSpecies;
   int resultWeight = Double.valueOf(this.weight).compareTo(Double.valueOf(another.weight));
   if(resultWeight != 0)
      return resultWeight;
      
    return 0;
}

}