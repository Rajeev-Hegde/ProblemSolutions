package problems.leetcode.top_interview_questions.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] res = new int[nums1.length+nums2.length];
        int i=0, j=0, pos=0;
        while(i< nums1.length && j< nums2.length){
            if(nums1[i]== nums2[j]){
                res[pos++] = nums1[i];
                i++;
                j++;

            }
            else if(nums1[i]< nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, pos);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println(new IntersectionOfTwoArrays2().intersect(nums1,nums2));
    }
}
