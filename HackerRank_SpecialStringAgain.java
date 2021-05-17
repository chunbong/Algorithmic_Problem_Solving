import java.util.ArrayList;
import java.util.List;

class Counting {
    char alpha;
    int count;

    public Counting(char alpha, int count) {
        this.alpha = alpha;
        this.count = count;
    }

    public char getAlpha() {
        return alpha;
    }

    public int getCount() {
        return count;
    }

    public void setAlpha(char alpha) {
        this.alpha = alpha;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

/**
 * 모든 문자가 동일하면
 * 중간 문자를 제외한 모든 문자가 동일하면
 *
 */
public class HackerRank_SpecialStringAgain {

    static long substrCount(int n, String s) {
        int count = 0;

        List<Counting> countingList = new ArrayList<>();
        char current;
        Counting prevCounting = new Counting(s.charAt(0), 1);
        countingList.add(prevCounting);

        for(int i = 1; i < s.length(); i++) {
            current = s.charAt(i);

            if (current == prevCounting.getAlpha()) {
                prevCounting.setCount(prevCounting.getCount() + 1);
            } else {
                Counting newCounting = new Counting(s.charAt(i), 1);
                prevCounting = newCounting;
                countingList.add(newCounting);
            }

        }

        int counting;
        for(int i = 0; i < countingList.size(); i++) {
            counting = countingList.get(i).getCount();
            count += (counting * (counting + 1)) / 2;

            if (counting == 1) {
                if (i - 1 >= 0 && i + 1 < countingList.size()) {
                    Counting prev = countingList.get(i-1);
                    Counting next = countingList.get(i+1);
                    if (prev.getAlpha() == next.getAlpha()) {
                        count += Math.min(prev.getCount(), next.count);
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(substrCount(7, "mnonopoo"));
    }
}
