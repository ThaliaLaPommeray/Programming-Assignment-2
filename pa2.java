// Thalia La Pommeray

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class pa2 {

    public static volatile int count;
    private static volatile int n;
    public static volatile int cake = 1;

    public static class myrun implements Runnable {

        @Override
        public synchronized void run() {
            if (cake==1) {
                cake=0;
                count++;
            }
        }
    }

    public static class myrun1 implements Runnable {

        @Override
        public synchronized void run() {
            if (cake==0) {
                cake=1;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        n = 5;
        count = 1;
        cake = 1;
        int t = 0;
        Thread[] threads = new Thread[n];
        boolean [] visited = new boolean[n];

        for (int m=0; m<n; m++){
            visited[m] = false;
        }

        myrun lead = new myrun();
        myrun1 my = new myrun1();

        boolean isT = true;
        while (count<n-1){

           // for(int t=0; t<=n; t++){
                if (!isT) try {
                    threads[t].join();
                } catch (NullPointerException ignored) {}
                else isT = false;
                if (t==0){
                    threads[t] = new Thread(lead);
                    threads[t].start();
                }
                else{
                    if (!visited[t]){
                        threads[t] = new Thread(my);
                        threads[t].start();
                        visited[t] = true;
                    }
           //     }
                }
            t++;
            if (t==(n+1)) t=0;
            }


        for(t=0; t<=n; t++){
            try {
                threads[t].join();
            }
            catch (NullPointerException ignored) {}
        }

        if (count==n-1) System.out.println("Mr. Minotaur, All the guests have entered the labyrinth.");

    }

}

