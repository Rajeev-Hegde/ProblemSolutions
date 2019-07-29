package problems.interviewbit.bitmanipulation;

import java.util.List;

public class SingleNumber2 {


    public int singleNumber(final List<Integer> A){
        int one = 0, two = 0, three = ~0;

        for(int i = 0; i < A.size(); ++i) {
            int cur = A.get(i);
            int one_next = (one & (~cur)) | (cur & three);
            int two_next = (two & (~cur)) | (cur & one);
            int three_next = (three & (~cur)) | (cur & two);
            one = one_next;
            two = two_next;
            three = three_next;
        }

        return one;
    }

    public static void main(String[] args) {

    }
}
