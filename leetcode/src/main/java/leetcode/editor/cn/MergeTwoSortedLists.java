package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2079 👎 0

/**
 * 合并两个有序链表
 *
 * @since :2021-12-07 10:15:43
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode newNode;
            ListNode temp;
            if (l1.val <= l2.val) {
                newNode = l1;
                temp = l2;
            } else {
                newNode = l2;
                temp = l1;
            }
            get(newNode, temp);
            return newNode;
        }

        private void get(ListNode newNode, ListNode temp) {
            if (newNode.next == null) {
                newNode.next = temp;
                return;
            }
            if (temp == null) {
                return;
            }

            if (newNode.next.val > temp.val) {
                ListNode aNode = temp;
                temp = newNode.next;
                newNode.next = aNode;
            }
            get(newNode.next, temp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}