// Thalia La Pommeray
import java.util.Random;
import java.util.Scanner;
public class pa2 {

    public static volatile int count;
    private static volatile int n;
    public static volatile int cake = 1;
    public static volatile int t;
    public static boolean [] visited;
    public static int currentGuest;

    public static class myrun implements Runnable {

        @Override
        public synchronized void run() {
            if (cake == 0) {
                cake = 1;
                count++;
               // System.out.println("one more has entered the labyrinth");
            }
        }
    }

    public static class myrun1 implements Runnable {

        @Override
        public synchronized void run() {
            if (cake==1) {
                cake=0;
                visited[currentGuest] = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Guests?");
        n = sc.nextInt(); // number of Guests
        count = 1; // tracking how many guest
        cake = 1;
        t = 0;
        visited = new boolean[n];
        Thread [] threads = new Thread[n];
        int leader = random.nextInt(n);

        for (int m=0; m<n; m++){
            visited[m] = false;
        }

        myrun lead = new myrun();
        myrun1 my = new myrun1();

        while (count<n){
            currentGuest = random.nextInt(n);
                if (currentGuest==leader){
                    threads[currentGuest] = new Thread(lead);
                    threads[currentGuest].start();
                }
                else{
                    if (!visited[currentGuest]){
                        threads[currentGuest] = new Thread(my);
                        threads[currentGuest].start();
                    }
                }

                t++;
            }

        if (count == n) System.out.println("Mr. Minotaur, All the guests have entered the labyrinth!");
        System.out.printf("total labyrinth visits: %d", t);

    }

}

