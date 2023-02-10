package leetcode.editor.cn;

//给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 
//输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 
//输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
//
// Related Topics 哈希表 字符串 排序 👍 148 👎 0

/**
 * 判定是否互为字符重排
 *
 * @since :2023-02-02 11:04:59
 */
public class CheckPermutationLcci {

    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            if (length2 != length1) {
                return false;
            }

//
//            char[] chars1 = s1.toCharArray();
//            char[] chars2 = s2.toCharArray();
//
//            Arrays.sort(chars1);
//
//            Arrays.sort(chars2);
//
//            if (String.valueOf(chars1).equals(String.valueOf(chars2))) {
//                return true;
//            }
//
//            return false;

            int[] temp = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                temp[s1.charAt(i)] = temp[s1.charAt(i)] + 1;
            }

            for (int i = 0; i < s2.length(); i++) {
                temp[s2.charAt(i)] = temp[s2.charAt(i)] - 1;
                if (temp[s2.charAt(i)] < 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}