package leetcode.editor.cn;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1317 👎 0

/**
 * 回文数
 *
 * @since :2020-11-23 17:18:24
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        solution.isPalindrome(123456);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 官方思路调试
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /* 下面数学解题优化，不需要幂次方
         public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int z = 1;
            while (x / z >= 10) {
                z *= 10;
            }

            while(x > 0){
                int left = x / z;
                int right = x % 10;
                if (left != right) return false;
                x = (x % z) / 10;
                z /= 100;
            }

            return true;
        }
     */


    /* 数学解题
    public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int temp = x;
            int z = 0;
            while (temp != 0) {
                temp = temp / 10;
                z++;
            }

            if (z < 2) {
                return true;
            }

            for (int y = 1; y <= z / 2; y++) {
                double powLeft = Math.pow(10, z - y);
                double powRight = Math.pow(10, y);
                int right = (int) ((x % powRight) / (Math.pow(10, y-1)));
                int left = (int) (x / powLeft);
                if (left != right) {
                    return false;
                }
                x = (int) ((x - left * powLeft));
            }
            return true;
        }
     */

    /* 采用反转后判断相等
            public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int temp = x;
            int result = 0;
            while (temp != 0) {
                int j = temp % 10;
                temp = temp / 10;
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && j > Integer.MAX_VALUE % 10)) {
                    result = 0;
                    break;
                }
                result = result * 10 + j;
            }
            if (result == x) {
                return true;
            }
            return false;
        }
     */


    /*
        // 字符串解法
        public boolean isPalindrome(int x) {
            StringBuffer s = new StringBuffer().append(x);
            String before = s.toString();
            String after = s.reverse().toString();
            return after.equals(before);
        }
     */
}