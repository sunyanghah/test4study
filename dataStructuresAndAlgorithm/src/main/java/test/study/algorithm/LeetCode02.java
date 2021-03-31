package test.study.algorithm;

/**
 * 两数相加
 *
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author sunYang
 * @Date 2021-03-20
 */
public class LeetCode02 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l1Curr = l1;
        for (int i = 0;i<7;i++){
            l1Curr.next = new ListNode(9);
            l1Curr = l1Curr.next;
        }

        ListNode l2 = new ListNode();
        ListNode l2Curr = l2;
        for (int i = 0;i<4;i++){
            l2Curr.next = new ListNode(9);
            l2Curr = l2Curr.next;
        }

        ListNode result = addTwoNumbers(l1.next, l2.next);

        System.out.println();
        while(result != null){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode curr = result;
        int upNum = 0;
        while (l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int thisNum = val1 + val2 + upNum;
            upNum = thisNum/10;
            curr.next = new ListNode(thisNum%10);

            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (upNum != 0){
            curr.next = new ListNode(upNum);
        }
        return result.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
