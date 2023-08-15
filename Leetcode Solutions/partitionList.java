class Solution {
    public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode head1, p1 = new ListNode(0), head2, p2 = new ListNode(0);
    head1 = p1;
    head2 = p2;
    while (head != null) {
        if (head.val < x) {
            p1.next = head;
            p1 = p1.next;
        } else {
            p2.next = head;
            p2 = p2.next;
        }
        head = head.next;
    }
    p2.next = null;
    p1.next = head2.next;
    return head1.next;
}
}