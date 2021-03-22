import java.util.*;

public class Programmers_위장 {

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        String key = "";
        Integer value = 0;
        for (int i = 0; i < clothes.length; i++) {
            key = clothes[i][1];

            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value+1);
            } else {
                map.put(key, 1);
            }
        }

        for (String k : map.keySet()) {
            answer *= (map.get(k)+1);
        }

        System.out.println(answer-1);

        return answer - 1;
    }

    public static void main(String[] args) {
        solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
//        solution(new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});
    }
}
