package concepts.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceUsage {

    ExecutorService executorService;

    public ExecutorServiceUsage() {
        this.executorService = Executors.newWorkStealingPool(5);
    }

    static void performAction(){

    }

    public static void main(String[] args) {
        ExecutorServiceUsage.performAction();
    }
}
