import java.util.*;
abstract class Figure{
    double dim1,dim2;
  Figure(double i,double j){
      dim1=i;
      dim2=j;
}
  abstract double area();
}
class Rectangle extends Figure{
       Rectangle(double a,double b){
           super(a,b);
  }
    double area(){
     return dim1*dim2;
  }
}
class Triangle extends Figure{
      Triangle(double a,double b){
          super(a,b);
     }
    double area(){
      return 0.5*dim1*dim2;
   }
}
class Circle extends Figure{
    Circle(double a,double b){
         super(a,b);
  }
    double area(){
     return 3.14*dim1*dim1;
}
}
public class Area1{
    public static void main(String args[]){
        Rectangle r1=new Rectangle(2.0,3.0);
        System.out.println("Area of the Rectangle:"+ r1.area());
        Triangle t1=new Triangle(2.0,4.0);
        System.out.println("Area of the Triangle:"+  t1.area());
        Circle c1=new Circle(2.0,2.0);
        System.out.println("Area of the Circle:"+ c1.area());
 }
}  
