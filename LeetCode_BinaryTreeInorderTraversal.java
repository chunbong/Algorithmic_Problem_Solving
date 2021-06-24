import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class LeetCode_BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> answer = new ArrayList<>();

		if (root == null) {
			return answer;
		}

		if (root.left != null) {
			answer.addAll(inorderTraversal(root.left));
		}

		answer.add(root.val);

		if (root.right != null) {
			answer.addAll(inorderTraversal(root.right));
		}

		return answer;
    }
}
