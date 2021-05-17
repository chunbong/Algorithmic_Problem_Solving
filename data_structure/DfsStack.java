package data_structure;

import java.util.*;

class Node {

	public List<Node> childNodes() {
		return null;
	}
}

class TextNode extends Node {

}

public class DfsStack {

	private static void DFS(Node root) {
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(root);

		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if (node instanceof TextNode) {
				System.out.println(node);
			}

			List<Node> nodes = new ArrayList<Node>(node.childNodes());
			Collections.reverse(nodes);

			for (Node child : nodes) {
				stack.push(child);
			}
		}
	}

}
