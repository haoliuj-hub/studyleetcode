package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1499 👎 0

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @since :2023-02-14 09:43:14
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

//            // 深度优先
//            test(root, 1);
//            return count;


            // 广度优先
            Queue<TreeNode> aaa = new LinkedList<>();
            aaa.offer(root);

            int count = 0;
            while (!aaa.isEmpty()) {
                int size = aaa.size();
                while (size > 0) {
                    TreeNode poll = aaa.poll();
                    if (poll.left != null) {
                        aaa.offer(poll.left);
                    }

                    if (poll.right != null) {
                        aaa.offer(poll.right);
                    }

                    size--;
                }
                count++;
            }

            return count;
        }

        public int count = 0;

        public void test(TreeNode node, int num) {
            if (num > count) {
                count = num;
            }

            TreeNode left = node.left;
            if (left != null) {
                test(left, num + 1);
            }

            TreeNode right = node.right;
            if (right != null) {
                test(right, num + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}