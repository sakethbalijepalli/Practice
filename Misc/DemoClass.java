package Misc;

public class DemoClass implements Runnable{

    private Thread t;
    private String threadName;

    DemoClass (String threadName){
        this.threadName = threadName;
    }

    public void run(){
        while(true){
            System.out.println(threadName);
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}

class TestThread{
    static void main() {
        DemoClass A = new DemoClass("A");
        DemoClass B = new DemoClass("B");

        B.start();
        A.start();
    }
}
