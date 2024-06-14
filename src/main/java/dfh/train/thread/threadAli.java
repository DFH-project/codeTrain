package dfh.train.thread;

import java.util.Stack;

public class threadAli {
    // 给三个线程ABC， 输出ABCABCABC...
    static int count =0 ;
    static final Object lock = new Object();

    static class Threadprint extends Thread{
        public String name;
        public int code;
        public Threadprint(String name, int code){
            this.name = name;
            this.code = code;
        }
        void print() throws InterruptedException {
            synchronized (lock) {
                while(count %3 !=code){
                    lock.wait();
                }
                System.out.println(name);
                count++;
                lock.notifyAll();
            }
        }
        @Override
        public void run() {
            while(true){
                try {
                    print();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 =new Threadprint("A",0);
        Thread t2 =new Threadprint("B",1);
        Thread t3 =new Threadprint("C",2);

        t1.start();
        t2.start();
        t3.start();
    }
}
