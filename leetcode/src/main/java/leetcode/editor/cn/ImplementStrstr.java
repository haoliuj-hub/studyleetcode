package leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1141 👎 0

/**
 * 实现 strStr()
 *
 * @since :2021-12-07 10:08:03
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("mississippi","issipi"));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if("".equals(needle)){
                return 0;
            }

            if(haystack.length() == 0 || needle.length() > haystack.length()){
                return -1;
            }

            char[] chars1 = haystack.toCharArray();
            char[] chars2 = needle.toCharArray();
            int length1 = chars1.length;
            int length2 = chars2.length;

            int start = -1;
            int i = 0 ;
            int j = 0;
            while(true){
                if(i > length1 -1){
                    return -1;
                }

                if(chars1[i] == chars2[j]){
                    if(start == -1){
                        start = i;
                    }
                    if(j == length2 - 1){
                        return start;
                    }
                    i++;
                    j++;
                }else{
                    if(j > 0){
                        j=0;
                        i = start + 1;
                    }else{
                        i++;
                    }
                    start = -1;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /*  最简单 利用String  Api
            public int strStr(String haystack, String needle) {
            if("".equals(needle)){
                return 0;
            }

            if(haystack.length() == 0){
                return -1;
            }

            return haystack.indexOf(needle);
        }
     */

}