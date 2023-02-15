package leetcode.editor.cn;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2269 👎 0

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * @since :2023-02-14 10:35:34
 */
public class SymmetricTree {

    public static void main(String[] args) {
        Queue<TreeNode> left = new LinkedList<>();
        left.add(null);

        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {

            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }


//            // 广度
//            Queue<TreeNode> all = new LinkedList<>();
//
//            TreeNode left1 = root.left;
//            TreeNode right1 = root.right;
//
//            all.offer(left1);
//            all.offer(right1);
//
//            while (!all.isEmpty()) {
//                TreeNode leftPoll = all.poll();
//                TreeNode rightPoll = all.poll();
//
//                if (leftPoll == null && rightPoll == null) {
//                    continue;
//                } else if (leftPoll == null || rightPoll == null) {
//                    return false;
//                }
//
//                if (leftPoll.val != rightPoll.val) {
//                    return false;
//                }
//
//
//                all.offer(leftPoll.left);
//                all.offer(rightPoll.right);
//
//                all.offer(leftPoll.right);
//                all.offer(rightPoll.left);
//            }
//
//            return true;


            // 深度
            return dept(root.left, root.right);
        }

        public boolean dept(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            return dept(left.left, right.right) && dept(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}