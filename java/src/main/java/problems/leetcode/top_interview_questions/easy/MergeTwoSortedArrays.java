package problems.leetcode.top_interview_questions.easy;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0;
        if(n>0)
            while(i< m){
                int j=0;
                if(nums1[i]> nums2[j]){
                    while(j< n && nums1[i]> nums2[j])
                        j++;
                    j--;
                    int temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j]= temp;
                }
                else
                    i++;
            }
        for(i=m; i< m+n; i++){
            nums1[i] = nums2[i-m];
        }
    }

    public void mergeEfficient(int[] nums1, int m, int[] nums2, int n) {

        if(n>0) {
            int i = m + n - 1;

            int j = n - 1;
            int k= m-1;

            while(i>=0 && j>=0 && k>=0){

                if(nums2[j] >= nums1[k]){
                    nums1[i--]= nums2[j--];
                }
                else
                    nums1[i--]= nums1[k--];
            }

            while(j>=0){
                nums1[i--]= nums2[j--];
            }
        }

    }

}
