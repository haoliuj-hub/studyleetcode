package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2356 👎 0

/**
 * 整数反转
 *
 * @since :2020-11-20 09:40:23
 */
public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int z = 1234;
        System.out.println(solution.reverse(z));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                int j = x % 10;
                x = x / 10;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && j > Integer.MAX_VALUE % 10)) {
                    result = 0;
                    break;
                } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && j < Integer.MIN_VALUE % 10)) {
                    result = 0;
                    break;
                }
                result = result * 10 + j;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}