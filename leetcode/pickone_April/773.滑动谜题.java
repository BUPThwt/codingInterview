import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
class Solution {
    static int[][] exchangeArray = new int[][]{
        {1, 3},
        {0, 2, 4},
        {1, 5},
        {0, 4},
        {1, 3, 5},
        {2, 4}
    };

    private String exchangeChar(String s, int start, int end){
        char[] chars = s.toCharArray();
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        return String.valueOf(chars);
    }
    public int slidingPuzzle(int[][] board) {
        char[] chars = new char[6];
        int index = 0;
        for(int[] row : board){
            for(int ch : row){
                chars[index++] = (char)(ch +'0');
            }
        }
        String source = new String(chars);
        String target = "123450";
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        int step = 0;
        Set<String> seen = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                if(str.equals(target)){
                    return step;
                }
                int position = str.indexOf('0');
                int[] neighbors = exchangeArray[position];
                for(int neighbor : neighbors){
                    String change = exchangeChar(str, position, neighbor);
                    if(!seen.contains(change)){
                        queue.offer(change);
                        seen.add(change);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

