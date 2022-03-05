// Thalia La Pommeray

package ddx.Multithreading;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Scanner;

public class prob2{
    public static int n;
    public static class spinlock {
    private final AtomicReference<Thread> cas;
    spinlock(AtomicReference<Thread> cas){
        this.cas = cas;
    }
    public void lock() {
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
            System.out.println("I am spinning");
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Guests?");
        n = sc.nextInt();
        AtomicReference<Thread> cas = new AtomicReference<>();

        for (int m = 0; m< n; m++){
            Thread Curthread = new Thread(new Task(cas));
            Curthread.start();
        }
        }


//Spin lock
static class Task implements Runnable {
    private final prob2.spinlock slock ;

    public Task(AtomicReference<Thread> cas) {
        this.slock = new prob2.spinlock(cas);
    }

    @Override
    public void run() {
        slock.lock();
        for (int i = 0; i < n; i++) {
            //Thread.yield();
            System.out.println(i);
        }
        slock.unlock();
    }
}
}