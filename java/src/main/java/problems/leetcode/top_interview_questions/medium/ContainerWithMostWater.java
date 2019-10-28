package problems.leetcode.top_interview_questions.medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea=0;
        int i=0, j=height.length-1;

        while(i< j){
            int currentArea= (j-i)* Math.min(height[i],height[j]);
            maxArea= Math.max(currentArea, maxArea);
            if(height[i]< height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
