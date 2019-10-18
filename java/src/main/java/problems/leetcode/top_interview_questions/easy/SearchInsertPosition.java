package problems.leetcode.top_interview_questions.easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int pos = search(nums, 0, nums.length-1, target);
        if(pos==-1)
            return 0;
        else if(pos == nums.length)
            return nums.length;
        else
            return pos;
    }

    public int search(int[] nums, int left, int right, int target){
        while(left<= right){
            int mid= (right+left)/2;
            if(nums[mid]== target)
                return mid;
            if(nums[mid]< target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

}
