//class that contains Rectangle class and methods that access and modify the object
public class Rectangle
{
//used to store width, set to 1 by default
double width = 1;
//used to store height, set to 1 by default
double height = 1;
//default constructor
Rectangle(){

}
//Constructor that takes in width and height and stores them
Rectangle(double width, double height){
   this.width = width;
   this.height = height;

}
//returns the width of the rectangle. Returns double value.
double getWidth(){
   return this.width;
}
//returns the height of the rectangle. Returns double value.
double getHeight(){
   return this.height;
}
//computes the area of rectangle by multiplying the width and the height. Returns double value.
double getArea(){
   return this.width * this.height;
}
//computes the parameter of rectangle by adding 2 times the width and 2 times the height. Returns double value.
double getPerimeter(){
   return (2 * this.width) + (2 * this.height);
}


}