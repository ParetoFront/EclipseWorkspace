package P003_LongestString;

import java.util.HashSet;
import java.util.Set;

public class P003_solution2 {
    public static void main(String[] args) {
        System.out.println(new P003_solution2().lengthOfLongestSubstring("abccabdddd"));
    }
        private int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            //寻找最长不重复字符串的特点是：一旦出现重复字符。就应该从字符串头开始删除字符直到删掉重复的字符
            //设置ans作为最大长度的记录
            //while循环中，若j处的字符s(j)出现重复，则保持j不动，开始从set中删除字母s(i)、s(i+1)
            // 直到与s(j)重复的那个字母也被删掉，然后j继续前进
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

}
