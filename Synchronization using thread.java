class A extends Thread{
   public synchronized void run(){
    for(int i=1;i<=5;i++){
      if(i==1){
try{
 Thread.yield();
}catch(Exception e){
 System.out.println("Exception Caught in Class A "+ e);
}
      }
      System.out.println("\t From thread A: i="+i);
    }
      System.out.println("Exit From A");
  }
}

class B extends Thread{
  /*public void run(){
    for(int i=1;i<=5;i++){
      System.out.println("\t From thread B: j="+i);
      if(i==1){
stop();
      }
    }
      System.out.println("Exit From B");
  }*/

  private boolean stopThread = false;
  public synchronized void run() {
        for (int i = 1; i <= 5; i++) {
            if (stopThread) break;  // Gracefully stop the thread when the flag is true
            System.out.println("\t From thread B: j=" + i);
            if (i == 1) {
                stopThread = true;  // Set the flag to true at i == 1
            }
        }
        System.out.println("Exit From B");
    }
}

class C extends Thread{
  public synchronized void run(){
    for(int i=1;i<=5;i++){
      System.out.println("\t From thread C: k="+i);
      if(i==1){
try{
 sleep(1000);
}catch(Exception e){
 System.out.println("Exception Caught in Class C "+ e);
}
      }
    }
      System.out.println("Exit From C");
  }
}


class Synchronous{
  public static void main(String args[]){
    A a = new A();
    B b = new B();
    C c = new C();
    a.start();
    b.start();
    c.start();
  }
}
