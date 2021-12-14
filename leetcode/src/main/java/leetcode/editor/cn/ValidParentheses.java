package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2810 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的括号
 * @since :2021-12-07 10:15:38
 */
public class ValidParentheses{
    
    public static void main(String[] args) {
         Solution solution = new ValidParentheses().new Solution();
    }
    
    
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public boolean isValid(String s) {
              if(s == null){
                  return false;
              }

              if(s.length()%2 != 0){
                  return false;
              }

              Map<Character,Character> let = new HashMap<>();
              let.put(')','(');
              let.put(']','[');
              let.put('}','{');

              Deque aa = new ArrayDeque();

              for(int i = 0; i<s.length() ; i++ ){
                  char aChar = s.charAt(i);
                  if(let.containsKey(aChar)){
                      if(aa.isEmpty() || let.get(aChar) != aa.peek()){
                          return false;
                      }else{
                          aa.pop();
                      }
                  }else{
                      aa.push(aChar);
                  }
              }
              if(aa.isEmpty()){
                  return true;
              }
              return false;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

      
      
}