import java.net.CacheRequest;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import org.graalvm.compiler.word.Word;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    // public String minWindow(String s, String t) {
    //     Map<Character, Integer> need = new HashMap<>();
    //     Map<Character, Integer> window = new HashMap<>();
    //     for(char c : t.toCharArray()){
    //         need.put(c, need.getOrDefault(c, 0) + 1);
    //     }
    //     int left = 0, right = 0;
    //     int start = 0;
    //     int length = Integer.MAX_VALUE;
    //     // 与need中字符的数量相等的个数
    //     int valid = 0;
    //     while(right < s.length()){
    //         char c = s.charAt(right);
    //         right++;
    //         if(need.containsKey(c)){
    //             window.put(c, window.getOrDefault(c, 0) + 1);
    //             // 使用equals进行比较
    //             if(need.get(c).equals(window.get(c))){
    //                 valid++;
    //             }
    //         }

    //         while(valid == need.size()){
    //             if(right - left < length){
    //                 start = left;
    //                 length = right - left;
    //             }
    //             char d = s.charAt(left);
    //             left++;
    //             if(need.containsKey(d)){
    //                 //使用equals进行比较
    //                 if(window.get(d).equals(need.get(d))){
    //                     valid--;
    //                 }
    //                 window.put(d, window.getOrDefault(d, 0) - 1);
    //             }
    //         }
    //     }
    //     return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    // }


    public String minWindow(String s, String t){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int start = 0, length = Integer.MAX_VALUE;
        int count = 0;
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    count++;
                }
            }

            while(count == need.size()){
                if(right - left < length){
                    length = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        count--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    } 
}
// @lc code=end

