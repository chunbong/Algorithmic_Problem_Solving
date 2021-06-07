import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	ListNode l1Temp = new ListNode(-1, l1);
    	ListNode l2Temp = new ListNode(-1, l2);

    	ListNode answer = null;
    	int roundsNum = 0;
    	int sum = 0;
    	ListNode prev = null;
    	boolean end = false;

		while (true) {

			if (l1Temp.next == null && l2Temp.next == null) {
				end = true;
			}

			if (l1Temp.next != null) {
				sum += l1Temp.next.val;
				l1Temp = l1Temp.next;
			}
			if (l2Temp.next != null) {
				sum += l2Temp.next.val;
				l2Temp = l2Temp.next;
			}

			sum += roundsNum;

			if (sum >= 10) {
				roundsNum = sum / 10;
			} else {
				roundsNum = 0;
			}

			ListNode newListNode = new ListNode(sum % 10);

			if (answer == null) {
				answer = newListNode;
				prev = answer;
			} else {
				if (end) {
					if (newListNode.val != 0) {
						prev.next = newListNode;
					}
					break;
				} else {
					prev.next = newListNode;
					prev = prev.next;
				}
			}

			sum = 0;
		}

    	return answer;
    }

	public static void main(String[] args) {
		ListNode listNode = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
		while(listNode.next != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}
