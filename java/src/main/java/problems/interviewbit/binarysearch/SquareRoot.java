package problems.interviewbit.binarysearch;

public class SquareRoot {

    public int sqrt(int a) {
        if(a==0)
            return 0;
        if(a==1|| a==2)
            return 1;
        int i=1;
        int j=a/2;
        while(i<= j){
            int mid = (i+j)/2;
            if ((long)mid*(long)mid == (long)a|| (((long)mid*(long)mid<(long)a) && ((long)mid+1)*((long)mid+1)>(long)a))
                return mid;
            else if((long) mid*(long) mid<(long) a)
                i=mid+1;
            else
                j=mid-1;

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().sqrt(930675566));
    }
}
