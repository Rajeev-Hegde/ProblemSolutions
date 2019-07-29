package problems.interviewbit.binarysearch;

public class PowerFunction {

    public int pow(int x, int n, int d) {
        long currentNumber = x;
        for (int i = 1; i < n; i++) {
            currentNumber = currentNumber*x;
            if(currentNumber<0)
                currentNumber = d+currentNumber;
        }
        if(currentNumber<0)
            return (int)(d+currentNumber);
        return (int)(currentNumber%(long)d);
    }


    public static void main(String[] args) {
        System.out.println(new PowerFunction().pow(-1,1,20));
    }
}
