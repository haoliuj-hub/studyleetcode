package leetcode.editor.cn;

//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 动态规划 👍 488 👎 0

/**
 * 数字 1 的个数
 *
 * @since :2023-02-09 10:57:28
 */
public class NumberOfDigitOne {

    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {

            String s = String.valueOf(n);
            int length = s.length();

            return 1;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}