class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Temp = new ListNode(-1, l1);
        ListNode l2Temp = new ListNode(-1, l2);
        
        ListNode answer = null;
        ListNode prev = null;
        
        int carry = 0;
        int sum = 0;

        boolean end = false;
        
        while (true) {

            // 두 리스트 모두 다음 노드가 없으면, 아래에서 마지막 노드를 처리하고 끝내기 위해 체크
            if (l1Temp.next == null && l2Temp.next == null) {
                end = true;
            }

            // l1 값을 더하기
            if (l1Temp.next != null) {
                sum += l1Temp.next.val;
                l1Temp = l1Temp.next;
            }
            // l2 값을 더하기
            if (l2Temp.next != null) {
                sum += l2Temp.next.val;
                l2Temp = l2Temp.next;
            }

            sum += carry;

            if (sum >= 10) {
                carry = sum / 10;
            } else {
                // 이전에 담긴 carry 값을 초기화하기
                carry = 0;
            }

            ListNode newListNode = new ListNode(sum % 10);

            if (answer == null) {
                answer = newListNode;
                prev = answer;
            } else {
                if (end) {
                    // 마지막으로 추가할 수가 남아있으면 추가하고 끝내기
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
}
