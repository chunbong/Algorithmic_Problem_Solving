import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int answer = 0;

		int prev = -101;

		LinkedList<Integer> list = (LinkedList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != prev) {
				answer++;
				prev = nums[i];
			} else {
				list.remove(i);
			}
		}

		return answer;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
	}
}
