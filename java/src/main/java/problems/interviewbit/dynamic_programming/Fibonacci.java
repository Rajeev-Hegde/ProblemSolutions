package problems.interviewbit.dynamic_programming;

public class Fibonacci {

    private Integer fib(int n){
        Integer[] fibResult= new Integer[n];
        fibResult[0] = 1;
        fibResult[1] = 1;
        //get prev memorized values to compute current fib number
        for (int i = 2; i < n; i++) {
            fibResult[i]= fibResult[i-1]+ fibResult[i-2];
        }

        return fibResult[n-1];
    }


    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(3));
        System.out.println(new Fibonacci().fib(10));
    }
}
