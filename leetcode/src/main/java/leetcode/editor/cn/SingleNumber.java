package leetcode.editor.cn;

//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [2,2,1]
//输出：1
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [4,1,2,1,2]
//输出：4
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics 位运算 数组 👍 2742 👎 0

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * @since :2023-02-13 09:23:42
 */
public class SingleNumber {

    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] a = {4, 1, 2, 1, 2};
        solution.singleNumber(a);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int length = nums.length;
            if(length == 1){
                return nums[0];
            }

//            for (int i = 1; i < length; i++) {
//                for (int j = 0; j < length - i; j++) {
//                    if (nums[j] > nums[j + 1]) {
//                        int temp = nums[j];
//                        nums[j] = nums[j + 1];
//                        nums[j + 1] = temp;
//                    }
//                }
//            }
//
//            int left = 0;
//            int right = length - 1;
//
//            while (left <= right) {
//                if (nums[left] != nums[left + 1]) {
//                    return nums[left];
//                } else {
//                    left += 2;
//                }
//
//                if (nums[right] != nums[right - 1]) {
//                    return nums[right];
//                } else {
//                    right -= 2;
//                }
//            }
//
//
//            return 1;

            // 位运算
            for(int i = 1 ; i < length ; i++){
                nums[0] = nums[0] ^ nums[i];
            }

            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}