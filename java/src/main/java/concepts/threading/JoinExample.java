package concepts.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

public class JoinExample {

    private static CustomTask customTask = (numTasks,delayMilliSecs)-> {
        IntStream.range(1,numTasks+1).forEach(num-> {
            System.out.println(Thread.currentThread().getName()+ " Task finished: "+ num);
            try {
                Thread.sleep(delayMilliSecs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    };


    public interface CustomTask{
        void execute(int numTasks,int delay);

        default void executeDefault(int numTasks){
            IntStream.range(1,numTasks+1).forEach(num->
                    System.out.println(Thread.currentThread().getName()+ " Task finished: "+ num));
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Thread thread1= new Thread(()-> customTask.execute(2,1000));
        Thread thread2=new Thread(()-> customTask.execute(6,1000));
        Thread thread3=new Thread(()-> customTask.executeDefault(10000));
        FutureTask<String> futureTask = new FutureTask<>(() -> "This is a returned result from thread execution");
        Thread thread4 = new Thread(futureTask);

        thread3.start();
        thread3.join();
        //thread1 and thread2 begins execution only after thread3 finishes execution
        thread1.start();
        thread2.start();
        thread4.start();

        System.out.println(futureTask.get());

        //thread1.join();
        //thread2.join();
        //thread3.join();
    }
}
