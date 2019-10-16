package problems.leetcode.top_interview_questions.easy;

public class MaximizeDistToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int[] leftDist = new int[seats.length];
        int[] rightDist = new int[seats.length];
        leftDist[0]= seats.length;
        rightDist[seats.length-1]= seats.length;
        for(int i=1; i< seats.length; i++){
            if(seats[i] == 1){
                leftDist[i]= 0;
            }
            else{
                leftDist[i]=leftDist[i-1]+1;
            }
        }
        for(int i=seats.length-2; i>=0; i--){
            if(seats[i] == 1){
                rightDist[i]= 0;
            }
            else{
                rightDist[i]=rightDist[i+1]+1;
            }
        }

        int pos=-1, maxDist = 0;
        for(int i=0; i<seats.length; i++){
            if(seats[i] == 0){
                if(Math.min(leftDist[i], rightDist[i])> maxDist){
                    pos = i;
                    maxDist = Math.min(leftDist[i], rightDist[i]);
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(new MaximizeDistToClosestPerson().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
