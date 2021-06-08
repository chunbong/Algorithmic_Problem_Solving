package DataStructure.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Tree {

    /**
     * 새로운 트리 노드를 1개 생성
     * @param data 노드가 가질 데이터
     */
    public static <T> Node<T> newNode(T data) {
        return new Node<T>(data);
    }

    /**
     * data 값을 가지는 노드를 찾기
     * @param node 탐색을 시작할 노드
     * @param data 찾을 데이터
     */
    public static <T> Node<T> findNode(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (node.getData() == data) {
            return node;
        }

        List<Node<T>> childList = node.getChildList();
        for (Node<T> child : childList) {
            Node<T> found = findNode(child, data);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    /**
     * node에 새로운 node를 자식 노드로 추가
     * @param node 자식 노드를 추가할 노드
     * @param data 추가될 자식 노드가 가질 값
     */
    public static <T> void addChild(Node<T> node, T data) {
        node.getChildList().add(new Node<>(data));
    }

    /**
     * 전위 순회
     * @param node 순회를 시작할 노드
     */
    public static <T> void preOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getData());

        List<Node<T>> childList = node.getChildList();
        for (Node<T> child : childList) {
            preOrder(child);
        }
    }

    /**
     * 후위 순회
     * @param node 순회를 시작할 노드
     */
    public static <T> void postOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        List<Node<T>> childList = node.getChildList();
        if (childList.size() != 0) {
            for (Node<T> child : childList) {
                postOrder(child);
            }
        }
        System.out.print(node.getData());
    }

    /**
     * 층별 순회
     * @param node 순회를 시작할 노드
     */
    public static <T> void levelOrder(Node<T> node) {
        Deque<Node<T>> deque = new ArrayDeque<>();
        deque.offer(node);

        Node<T> currentNode = null;
        while (!deque.isEmpty()) {
            currentNode = deque.pollFirst();

            System.out.print(currentNode.getData());

            List<Node<T>> childNode = currentNode.getChildList();
            for (Node<T> child : childNode) {
                deque.offer(child);
            }
        }
    }
}
