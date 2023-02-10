package leetcode.editor.cn;

//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
//
// Related Topics 双指针 字符串 👍 235 👎 0

/**
 * 一次编辑
 *
 * @since :2023-02-02 15:34:40
 */
public class OneAwayLcci {

    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int length1 = first.length();
            int length2 = second.length();

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}