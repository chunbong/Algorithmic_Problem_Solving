/*
 * 여러 자식 노드를 가질 수 있는 트리 노드
 */

package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data;
    private List<Node<T>> childList = new ArrayList<>();

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getChildList() {
        return childList;
    }
}
