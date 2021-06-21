import java.util.HashMap;
import java.util.Map;

public class LeetCode_TwoSum {

    // 처음 내 풀이 ---
    public int findIndex(int[] nums, int index, int target) {

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

    public int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            answer[0] = i;
            answer[1] = findIndex(nums, i, target);
            if (answer[1] != -1) {
                break;
            }
        }

        return answer;
    }
    // ---

    /**
     * Brute Force를 사용한 좀 더 빠른 풀이
     * 출처 - LeetCode
     */
    public static int[] twoSum_bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }

    /**
     * Hash Table을 사용한 방법 - 각 요소를 두번 탐색
     *
     * 출처 - LeetCode
     */
    public static int[] twoSum_TwoPass_HashTable(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        // 각 요소와 인덱스를 맵에 추가
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 각 요소의 보수가 테이블에 존재하는지 확인
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }

        return null;
    }

    /**
     * Hash Table을 사용한 방법 - 각 요소를 한번 탐색
     *
     * 출처 - LeetCode
     */
    public static int[] twoSum_OnePass_HashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
       twoSum_bruteForce(new int[]{3,2,4}, 6);
    }
}
