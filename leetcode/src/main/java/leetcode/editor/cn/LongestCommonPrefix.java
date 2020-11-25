package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1356 👎 0

/**
 * 最长公共前缀
 *
 * @since :2020-11-24 11:28:25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            StringBuffer result = new StringBuffer();
            for (int y = 0; y < strs[0].length(); y++) {
                char s = strs[0].charAt(y);
                for (int x = 0; x < strs.length; x++) {
                    if (y >= strs[x].length()) {
                        return result.toString();
                    }
                    char temp = strs[x].charAt(y);
                    if (s != temp) {
                        return result.toString();
                    }
                }
                result.append(s);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}