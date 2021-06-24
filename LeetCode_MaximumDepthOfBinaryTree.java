public class LeetCode_MaximumDepthOfBinaryTree {

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

    public int maxDepth(TreeNode root) {

        return findMaxDepth(root, 0);
    }

    public int findMaxDepth(TreeNode root, int depth) {

        if (root == null) {
            return depth;
        }

        depth++;

        int leftDepth = depth;
        if (root.left != null) {
            leftDepth = Math.max(depth, findMaxDepth(root.left, depth));
        }

        int rightDepth = depth;
        if (root.right != null) {
            rightDepth = Math.max(depth, findMaxDepth(root.right, depth));
        }

        return Math.max(leftDepth, rightDepth);
    }
}
