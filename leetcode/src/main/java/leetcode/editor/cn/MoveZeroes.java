package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 847 👎 0

/**
 * 移动零
 *
 * @since :2020-11-19 17:41:21
 */
public class MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] z = new int[]{1};
        solution.moveZeroes(z);
        System.out.println();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int z = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[z++] = nums[i];
                }
                if (i != z - 1) {
                    nums[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}