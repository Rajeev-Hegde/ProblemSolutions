package problems.leetcode.top_interview_questions.hard;

/**
 * TODO:// understand this
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1Len = nums1.length;
        int num2Len = nums2.length;
        boolean isEven = (num1Len + num2Len) % 2 == 0;
        int medianPos = isEven ? (num1Len + num2Len) / 2 - 1 : (num1Len + num2Len + 1) / 2 - 1;

        int i = 0, j = 0, k = -1, value = 0;
        while (i < num1Len || j < num2Len) {

            if (i < num1Len && j < num2Len) {

                if (nums1[i] <= nums2[j]) {

                    value = (k >= medianPos) ? value + nums1[i] : nums1[i];
                    i++;
                } else {

                    value = (k >= medianPos) ? value + nums2[j] : nums2[j];
                    j++;
                }
            } else if (i == num1Len) {

                value = (k >= medianPos) ? value + nums2[j] : nums2[j];
                j++;
            } else if (j == num2Len) {

                value = (k >= medianPos) ? value + nums1[i] : nums1[i];
                i++;
            }
            k++;
            if (k > medianPos && isEven) {
                return 1.0 * value / 2;
            } else if (k >= 0 && !isEven & k == medianPos) {
                return value;
            }

        }
        return 0.0;
    }


    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}
