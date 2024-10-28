class Gen<T>{
T ob;
Gen(T O){
ob=O;
}
void showtype(){
  System.out.println("The generic data type is"+" "+ob.getClass().getName());
}
T getob(){
   return ob;
}
}
class Main{
  public static void main(String[] args){
  Gen<Integer>iob;
  iob=new Gen<Integer>(10);
  iob.showtype();
  int b=iob.getob();
  System.out.println("The value of a is"+" "+b);
  Gen<Double>iob1=new Gen<Double>(20.0);
  iob1.showtype();
  double c=iob1.getob();
  System.out.println("The DataType is"+" "+c);
}
}
