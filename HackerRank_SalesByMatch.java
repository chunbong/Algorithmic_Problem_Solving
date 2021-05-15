import java.util.*;

public class HackerRank_SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
        int result = 0;

        Map<Integer, Integer> pairMap = new HashMap<>();

        for (Integer color : ar) {
            if (pairMap.containsKey(color)) {
                pairMap.put(color, pairMap.get(color) + 1);
            } else {
                pairMap.put(color, 1);
            }
        }

        for (Integer color : pairMap.keySet()) {
            int pair = pairMap.get(color);
            if (pair >= 2) {
                result += (pair / 2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sockMerchant(15, Arrays.asList(6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5)));
    }
}
