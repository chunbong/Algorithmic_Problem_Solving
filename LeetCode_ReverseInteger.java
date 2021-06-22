public class LeetCode_ReverseInteger {

    public static int reverse(int x) {

        long answer = 0;

        int digit = (int)(Math.log10(Math.abs(x))+1);
        int divisor = (int)Math.pow(10, digit-1);
        int multiple = 1;

        while (divisor >= 1) {
            answer += ((long) (x / divisor) * multiple);
            x %= divisor;
            divisor /= 10;
            multiple *= 10;

            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)answer;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }
}
