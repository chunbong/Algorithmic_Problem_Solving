import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HackerRank_FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();

        // 숫자 : 갯수
        TreeMap<Integer, Integer> store = new TreeMap<>();

        int operation = 0;
        int operand = 0;

        for (List<Integer> query : queries) {

            operation = query.get(0);
            operand = query.get(1);

            if (operation == 1) {
                if (store.get(operand) != null) {
                    store.put(operand, store.get(operand)+1);
                } else {
                    store.put(operand, 1);
                }
            } else if (operation == 2) {
                if (store.get(operand) != null) {
                    if (store.get(operand) > 0) {
                        store.put(operand, store.get(operand)-1);
                    }
                }
            } else if (operation == 3) {
                boolean found = false;

                if (operand > 1000000) {
                    found = false;
                } else {
                    if (store.containsValue(operand)) {
                        found = true;
                    }
                }

                if (found) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
