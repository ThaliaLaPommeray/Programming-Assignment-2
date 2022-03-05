package ddx.Multithreading;// Thalia La Pommeray

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Scanner;
import java.util.Random;

public class prob2{
    public static int n;
    public static int t = 0;
    public static boolean [] visited;
    public static class spinlock {
    private final AtomicReference<Thread> cas;
    spinlock(AtomicReference<Thread> cas){
        this.cas = cas;
    }
    public void lock() {
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null, current)) {
            t++;
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
        Random random = new Random();
        int guest;
        visited = new boolean[n];
        Thread [] threads = new Thread[n];
        int count = 0;
        int entries = 0;
        for (int m=0; m<n; m++){visited[m]= false;}
        AtomicReference<Thread> cas = new AtomicReference<>();

        while (count<n){
            guest = random.nextInt(n);
            if (!visited[guest]){
                visited[guest] = true;
                count++;
            }
            threads[guest] = new Thread(new Task(cas));
            threads[guest].start();
            entries++;
        }


        System.out.println("All guests have been in the showroom!");
        System.out.printf("Number of showroom visits: %d", entries);
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
            //System.out.println(i);
        }
        slock.unlock();
    }
}
}