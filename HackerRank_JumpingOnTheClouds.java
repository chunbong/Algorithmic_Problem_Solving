import java.util.Arrays;
import java.util.List;

public class HackerRank_JumpingOnTheClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {

        int result = 0;
        int jump = 0;

        for (int i = 0; i < c.size(); i += jump) {

            int j = i + 2;
            if (j < c.size()) {
                if (c.get(j) != 1) {
                    jump = 2;
                } else {
                    jump = 1;
                }
                result++;
            } else {
                j = i + 1;

                if (j < c.size()) {
                    jump = 1;
                    result++;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(Arrays.asList(0, 0, 0, 0, 1, 0)));
    }
}
