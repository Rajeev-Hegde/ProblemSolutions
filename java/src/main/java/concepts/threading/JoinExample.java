package concepts.threading;

import java.util.stream.IntStream;

public class JoinExample {




    public interface CustomTask{
        void execute(int numTasks);
    }


    public static void main(String[] args) throws InterruptedException {

        CustomTask customTask = (numTasks)-> {
            IntStream.range(1,numTasks+1).forEach(num-> System.out.println(Thread.currentThread().getName()+ " Task finished: "+ num));
        };

        Thread thread1= new Thread(()-> customTask.execute(2));
        Thread thread2=new Thread(()-> customTask.execute(6));
        Thread thread3=new Thread(()-> customTask.execute(10000));

        thread3.start();
        thread3.join();
        //thread1 and thread2 begins execution only after thread3 finishes execution
        thread1.start();
        thread2.start();

        //thread1.join();
        //thread2.join();
        //thread3.join();
    }
}
