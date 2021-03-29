import java.util.*;

public class Programmers_가장큰수 {

    public static String solution(int[] numbers) {
        String answer = "";

        Arrays.sort(numbers);
        int maxNum = numbers[numbers.length-1];
        String maxNumStr = String.valueOf(maxNum);

        Map<Integer, Integer> indexNumbersMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            // 0 : 970
            // 1 : 800
            // 2 : 100
            // ...
            // 6 : 360
            indexNumbersMap.put(i, Integer.valueOf(String.format("%-" + maxNumStr.length() + "s", numbers[i]).replace(" ", "0")));
        }

        // 맵의 값을 기준으로 정렬
        List<Integer> keySetList = new ArrayList<>(indexNumbersMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (indexNumbersMap.get(o2).compareTo(indexNumbersMap.get(o1))));

        // 1 : 970
        // 3 : 800
        // 7 : 100
        // ...
        // 5 : 360

        boolean isAllZero = true;
        for (Integer key : keySetList) {
            if (numbers[key] == 0) {
                isAllZero = isAllZero && true;
            } else {
                isAllZero = isAllZero && false;
            }
            answer += numbers[key];
        }

        if (isAllZero) {
            answer = "0";
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{97, 800, 709, 1, 37, 707, 360});
    }
//[10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//        987654321101000
//
//    [412, 41]
//            [303,30]
}
