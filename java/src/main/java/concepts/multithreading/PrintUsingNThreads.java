package concepts.multithreading;

public class PrintUsingNThreads {

    private static int counter = 1;
    private static int NUM_THREADS=3;
    private static int n = 12;

    static class Printer {


        synchronized void print(int initialNumber, int num) throws InterruptedException {

            while ((counter - initialNumber) % NUM_THREADS != 0) {
                wait();
            }
            counter++;
            notifyAll();
            System.out.println(Thread.currentThread().getName() + ": " + num);
        }

    }


    static class PrintNumbers implements Runnable {

        private int initialNumber;
        private Printer printer;

        PrintNumbers(int initialNumber,Printer printer) {
            this.initialNumber = initialNumber;
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = initialNumber; i <= n; i += NUM_THREADS) {
                try {
                    printer.print(initialNumber,i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        Printer printer = new Printer();
        for(int i=1; i<= NUM_THREADS; i++){
            new Thread(new PrintNumbers(i,printer),"Thread-"+ i).start();
        }
    }
}
