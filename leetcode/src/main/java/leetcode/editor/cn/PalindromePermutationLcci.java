package leetcode.editor.cn;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
//
// Related Topics 位运算 哈希表 字符串 👍 102 👎 0

/**
 * 回文排列
 *
 * @since :2023-02-02 14:51:06
 */
public class PalindromePermutationLcci {

    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
        solution.canPermutePalindrome("aab");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);
//            int length = chars.length;
//            int num = 0;
//            for (int i = 0; i < length; i++) {
//                if (i + 1 < length && chars[i] == chars[i + 1]) {
//                    i++;
//                } else {
//                    num++;
//                    if (num > 1) {
//                        return false;
//                    }
//                }
//            }
//            return true;

            int[] temp = new int[128];
            char[] chars = s.toCharArray();
            int length = chars.length;
            int count = 0;
            for (int i = 0; i < length; i++) {
                temp[chars[i]] += 1;
                if (temp[chars[i]] % 2 == 0) {
                    count--;
                } else {
                    count++;
                }
            }

            if (count > 1) {
                return false;
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}