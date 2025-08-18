public class LinkedList{
    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        int n = MiddleOfLinkedList(one);
        System.out.println(n);
        
    }

    public static class ListNode{
        int val = 0;
        ListNode next;
        ListNode prev;
        ListNode(int val){
            this.val = val;
        }
    }

    public static int MiddleOfLinkedList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

}