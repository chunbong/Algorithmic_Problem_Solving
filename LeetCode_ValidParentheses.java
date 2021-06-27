import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_ValidParentheses {

    // ----- 내 풀이
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char open;

                if (!stack.empty()) {
                    open = stack.pop();
                } else {
                    return false;
                }

                if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '[')) {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }
    // -------

    // ------- Leet Code Solution 1
    private Map<Character, Character> mappings = new HashMap<>();

    public LeetCode_ValidParentheses() {
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid_LeetCodeSolution1(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (this.mappings.containsKey(c)) {
                // 닫는 괄호를 만나면 pop

                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // 여는 괄호를 만나면 push
                stack.push(c);
            }

        }

        return stack.empty();
    }
    // -------

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
