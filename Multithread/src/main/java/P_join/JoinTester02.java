package P_join;

import java.util.Date;

public class JoinTester02 {

    public static void main(String[] args) {
        System.out.println("Main thread is Go");

        Thread thread1 = new Thread(new Task("1",3000L));
        Thread thread2 = new Thread(new Task("2",1000L));
        Thread thread3 = new Thread(new Task("3",2000L));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }
}

class Task implements Runnable {

    private String name;
    private Long sleep;

    public Task(String name, Long sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }
}