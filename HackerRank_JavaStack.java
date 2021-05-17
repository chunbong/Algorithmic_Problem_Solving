import java.util.Scanner;
import java.util.Stack;

public class HackerRank_JavaStack {

	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);

		Stack<Character> stack = new Stack<>();

		while (sc.hasNext()) {
			String input = sc.next();
			char pop;
			boolean valid = true;
			stack.clear();

			// {{}} {{()} [{}]()
			for (int i = 0; i < input.length(); i++) {

				if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
					stack.push(input.charAt(i));
				} else if (input.charAt(i) == '}') {
					if (!stack.isEmpty()) {
						pop = stack.pop();

						if (pop != '{') {
							valid = false;
							break;
						}
					} else {
						valid = false;
						break;
					}
				} else if (input.charAt(i) == ']') {
					if (!stack.isEmpty()) {
						pop = stack.pop();

						if (pop != '[') {
							valid = false;
							break;
						}
					} else {
						valid = false;
						break;
					}
				} else if (input.charAt(i) == ')') {
					if (!stack.isEmpty()) {
						pop = stack.pop();

						if (pop != '(') {
							valid = false;
							break;
						}
					} else {
						valid = false;
						break;
					}
				}
			}

			if (valid && stack.isEmpty()) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}

	}
}
