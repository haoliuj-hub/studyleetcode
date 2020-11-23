package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4577 👎 0

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @since :2020-11-13 13:16:45
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abcabcbb";

        System.out.println(solution.lengthOfLongestSubstring(s));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用map特性做key字符判断
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    /* 不使用map，执行速度快
          public int lengthOfLongestSubstring(String s) {
            int length = s.length();

            if (length == 1) {
                return 1;
            } else if (length == 0) {
                return 0;
            }

            int j = 0;
            int result = 0;
            for (int i = 1; i < length; i++) {
                String c = String.valueOf(s.charAt(i));
                String substring = s.substring(j, i);
                if (substring.contains(c)) {
                    if (i - j > result) {
                        result = i - j;
                    }
                    int i1 = substring.indexOf(c);
                    j = j + i1 + 1;
                } else if (i == length - 1) {
                    if (i - j + 1 > result) {
                        result = i - j + 1;
                    }
                }
            }

            return result;
        }
     */

}