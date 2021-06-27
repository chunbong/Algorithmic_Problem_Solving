public class LeetCode_MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int answer = -100001;

        for (int i = 0; i < nums.length; i++) {
            int prev = 0;
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    prev = nums[i];
                } else {
                    prev += nums[j];
                }

                answer = Math.max(answer, prev);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
