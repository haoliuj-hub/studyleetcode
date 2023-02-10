package leetcode.editor.cn;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 
//输入: s = "abc"
//输出: true
// 
//
// 限制： 
//
// 
// 0 <= len(s) <= 100 
// s[i]仅包含小写字母 
// 如果你不使用额外的数据结构，会很加分。 
// 
//
// Related Topics 位运算 哈希表 字符串 排序 👍 263 👎 0

/**
 * 判定字符是否唯一
 *
 * @since :2023-02-02 10:44:50
 */
public class IsUniqueLcci {

    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            char[] chars = astr.toCharArray();

            int length = chars.length;
            if (length > 26) {
                return false;
            }
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (chars[j] > chars[j + 1]) {
                        char temp = chars[j];
                        chars[j] = chars[j + 1];
                        chars[j + 1] = temp;
                    }
                }
            }

            for (int i = 0; i < length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}