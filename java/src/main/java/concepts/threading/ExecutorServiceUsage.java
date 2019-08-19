package concepts.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class ExecutorServiceUsage {

    ExecutorService executorService;

    public ExecutorServiceUsage() {
        this.executorService = Executors.newWorkStealingPool(5);
    }

    static void performAction(){

    }


    public static  ExecutorService getThreadPoolExecutor(int numThreads){
        return Executors.newFixedThreadPool(3);
    }

    public static void main(String[] args) {
        //ExecutorServiceUsage.performAction();

        ExecutorService executorService = ExecutorServiceUsage.getThreadPoolExecutor(3);


        IntStream.range(0,5).forEach(num-> executorService.submit(() -> System.out.println("For "+num+": "+ num/2)));

    }
}
