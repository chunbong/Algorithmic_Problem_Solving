public class LeetCode_RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int indexToFill = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[indexToFill]) {
				nums[indexToFill] = nums[i];
				indexToFill++;
			}
		}

		return indexToFill;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
	}
}
