package problems.leetcode.top_interview_questions.easy;

public class RotatedDigits {

    private int rotatedDigits(int N) {
        int total=0;
        for(int i=2; i<=N;i++ ){
            if(i%10== 1|| i%10==0|| i%10==2||i%10== 8|| i%10== 5|| i%10==6|| i%10== 9){
                String numString = String.valueOf(i);
                if(!(numString.contains("3")|| numString.contains("4")|| numString.contains("7"))
                        && (numString.contains("2")|| numString.contains("5")||
                        numString.contains("6") || numString.contains("9")))
                    total++;
            }
        }
        return total;
    }


    int rotatedDigitsSimpleSolution(int N)
    {
        int c=0;
        for(int i=1;i<=N;i++)
        {
            int z=i;
            int f=0;
            while(z!=0)
            {
                int y=z%10;

                if(y==3 || y==4 || y==7)
                {
                    f=1;
                    break;
                }
                if(y==2 || y==5 || y==6 || y==9)
                {
                    f=2;
                }
                z/=10;
            }

            if(f==2)
                c+=1;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(10));
    }
}
