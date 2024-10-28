class Gen<T,V>{
T ob1;
V ob2;
Gen(T O1,V O2){
ob1=O1;
ob2=O2;
}

void showtype(){
System.out.println("The genric data type of first object is"+" "+ob1.getClass().getName());
System.out.println("The genric data type of second object is"+" "+ob2.getClass().getName());
}
T getob1(){
return ob1;
}
V getob2(){
return ob2;
}
}
class Gendemo1{
public static void main(String args[]){
Gen<Integer,Double>iob;
iob=new Gen<Integer,Double>(10,20.00);
iob.showtype();
int b=iob.getob1();
double c=iob.getob2();
System.out.println("The integer data type value is"+" "+b);
System.out.println("The double data type value is"+" "+c);
}
}
