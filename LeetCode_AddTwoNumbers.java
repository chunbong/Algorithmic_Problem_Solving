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

            /*
                32 Line ~ 42 Line 을 바꾸면
                int x = (l1Temp != null) ? l1Temp.val : 0;
                int y = (l2Temp != null) ? l2Temp.val : 0;
                int sum = carry + x + y;
                이렇게 바꿀 수 있다
             */

            if (sum >= 10) {
                carry = sum / 10;
            } else {
                // 이전에 담긴 carry 값을 초기화하기
                carry = 0;
            }

            /*
                52 Line ~ 57 Line 을 바꾸면
                carry = sum / 10;

                if (sum >= 10) => 이 조건이 필요없다. 10 보다 작으면 당연히 0인걸..
             */


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

            /*
                69 Line ~ 72 Line 을 바꾸면

                ListNode dummyHead = new ListNode(0);
                이렇게 더미 값을 하나 넣고 시작하면 if (answer == null) 을 체크해서 첫 번째 노드로 추가해야되는 조건을 줄일 수 있다

             */

            sum = 0;
        }

        return answer;
    }
}
