package leetcode.editor.cn;

//给你一个链表的头节点 head ，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环 ，则返回 true 。 否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 10⁴] 
// -10⁵ <= Node.val <= 10⁵ 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
//
// 
//
// 进阶：你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// Related Topics 哈希表 链表 双指针 👍 1737 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 环形链表
 *
 * @since :2023-02-13 10:51:53
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null ||  head.next == null){
                return false;
            }

            // 采用Hash表方式
//            ListNode next = head.next;
//            Map<ListNode,Integer> map = new HashMap<>();
//
//            while(next != null){
//                if(map.containsKey(next)){
//                    return true;
//                }
//                map.put(next,next.val);
//                next = next.next;
//            }
//
//            return false;

            // 快慢指针
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null){
                fast = fast.next;
                if(fast != null){
                    fast = fast.next;
                }

                if(fast == slow){
                    return true;
                }

                slow = slow.next;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}