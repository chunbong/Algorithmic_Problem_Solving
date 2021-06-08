package DataStructure.Tree;

public class Example {

    public static void main(String[] args) {
        Node<Integer> root = Tree.newNode(0);

        Node<Integer> parent = Tree.findNode(root, 0);
        Tree.addChild(parent, 1);
        Tree.addChild(parent, 2);
        Tree.addChild(parent, 3);

        Node<Integer> parent2 = Tree.findNode(root, 1);
        Tree.addChild(parent2, 4);

        Node<Integer> parent3 = Tree.findNode(root, 2);
        Tree.addChild(parent3, 5);

        Node<Integer> parent4 = Tree.findNode(root, 3);
        Tree.addChild(parent4, 8);
        Tree.addChild(parent4, 9);
        Tree.addChild(parent4, 10);

        Node<Integer> parent5 = Tree.findNode(root, 5);
        Tree.addChild(parent5, 6);

        Node<Integer> parent6 = Tree.findNode(root, 6);
        Tree.addChild(parent6, 7);

        Tree.preOrder(root);
        System.out.println();

        Tree.postOrder(root);
        System.out.println();

        Tree.levelOrder(root);
        System.out.println();

    }
}
