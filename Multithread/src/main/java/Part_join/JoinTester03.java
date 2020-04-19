package Part_join;

import java.util.Date;

/**
 * @description //TODO
 *
 * 该例子主要展示了 父子线程嵌套后 join 的效果
 * 可以得出
 * （1）join 主要用来等待当前线程完成
 * （2）当前线程因为 join 完成后，才继续执行主线程
 * （3）join 可以定义父子线程的执行顺序
 *
 * @author 刘旭东
 * @date 2020/4/1 0:31
 */
public class JoinTester03 {

    public static void main(String[] args) {
        System.out.println("Main thread is Go");

        Thread thread1 = new Thread(new TaskParent("1",5000L));
        Thread thread2 = new Thread(new TaskParent("2",3000L));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }
}

class TaskParent implements Runnable {

    private String name;
    private Long sleep;

    public TaskParent(String name, Long sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        Thread a = new Thread(new TaskChildren(name + ":" + "a", sleep));
        Thread b = new Thread(new TaskChildren(name + ":" + "b", sleep));
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }
}

class TaskChildren implements Runnable {

    private String name;
    private Long sleep;

    public TaskChildren(String name, Long sleep) {
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