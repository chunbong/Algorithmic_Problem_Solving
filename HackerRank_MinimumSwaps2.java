/**
 * 오름차순으로 배열을 정렬하는데 필요한 최소 스왑 수 찾기
 */
public class HackerRank_MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {

        int temp = -1;
        int count = 0;
        boolean found = true;

        // 바꿀게 하나도 없을 때까지 반복
        while(found) {
            for (int i = 0; i < arr.length; i++) {

                // 제 위치가 아닌 값을 만나면
                if (i + 1 != arr[i]) {

                    int indexOfRightSpot = arr[i] - 1;

                    // 알맞은 인덱스로 옮기기
                    temp = arr[indexOfRightSpot];
                    arr[indexOfRightSpot] = arr[i];
                    arr[i] = temp;

                    count++;

                    break;
                }

                if (i == arr.length-1) {
                    found = false;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
    }
}
