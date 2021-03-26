import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */

// @lc code=start
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] strs = text.split(" ");
        if(strs.length < 3){
            return new String[]{};
        }
        for(int i = 2; i < strs.length; i++){
            if(first.equals(strs[i - 2]) && second.equals(strs[i - 1])){
                list.add(strs[i]);
            }
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
// @lc code=end

