import java.util.Stack;

public class LeetCode_ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
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

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
