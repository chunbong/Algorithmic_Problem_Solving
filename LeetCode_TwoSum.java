public class LeetCode_TwoSum {

    public static int findIndex(int[] nums, int index, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }

            if (nums[index] + nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            answer[0] = i;
            answer[1] = findIndex(nums, i, target);
            if (answer[1] != -1) {
                break;
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    public static void main(String[] args) {
       twoSum(new int[]{3,2,4}, 6);
    }
}
