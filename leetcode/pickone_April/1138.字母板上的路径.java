import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < alphabet.length(); i++){
            map.put(alphabet.charAt(i), new int[]{i/5, i % 5});
        }
        StringBuilder sb = new StringBuilder();
        int[] last = new int[]{0, 0};
        for(int i = 0; i < target.length(); i++){
            int[] position = map.get(target.charAt(i));
            int x = position[0];
            int y = position[1];
            while(x < last[0]){
                sb.append('U');
                last[0]--;
            }
            while(y < last[1]){
                sb.append('L');
                last[1]--;
            }
            while(x > last[0]){
                sb.append('D');
                last[0]++;
            }
            while(y > last[1]){
                sb.append( 'R');
                last[1]++;
            }
            sb.append("!");
        }
        return sb.toString();
    }
}
// @lc code=end

