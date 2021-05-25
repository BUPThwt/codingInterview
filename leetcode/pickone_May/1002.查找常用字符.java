import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {
        if(A.length == 0){
            return new ArrayList();
        }
        int[] hash = new int[26];
        for(int i = 0; i < A[0].length(); i++){
            hash[A[0].charAt(i) - 'a']++;
        }
        for(int j = 1; j < A.length; j++){
            int[] otherHash = new int[26];
            for(int k = 0; k < A[j].length(); k++){
               otherHash[A[j].charAt(k) - 'a']++; 
            }
            for(int i = 0; i < 26; i++){
                hash[i] = Math.min(hash[i], otherHash[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(hash[i] > 0){
                result.add(String.valueOf((char)(i + 'a')));
                hash[i]--;
            }
        }
        return result;
    }
}
// @lc code=end

