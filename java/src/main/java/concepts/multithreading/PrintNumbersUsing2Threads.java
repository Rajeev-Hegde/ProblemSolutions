package concepts.multithreading;

public class PrintNumbersUsing2Threads {

    static class Printer {
        public synchronized void printNumber(int n) throws InterruptedException {
            System.out.println("current thread: " + Thread.currentThread().getName());
            System.out.println(n);
            notify();
            wait();
        }
    }


    public static void printNumbers(int start,int n, Printer printer) throws InterruptedException {
        for (int i=start; i<= n; i+=2 ){
            printer.printNumber(i);
        }
    }

    public static void main(String[] args) {
        Printer printer =  new Printer();
        Thread thread1 = new Thread(()-> {
            try {
                PrintNumbersUsing2Threads.printNumbers(1,10,printer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()-> {
            try {
                PrintNumbersUsing2Threads.printNumbers(2,10,printer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
