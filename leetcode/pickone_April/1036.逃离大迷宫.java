import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 */

// @lc code=start
class Solution {
    static int[][] dirc = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int limit = (int)1e6;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>(); 
        for(int[] block : blocked){
            blocks.add(block[0] + ":" + block[1]);
        }
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }

    private boolean bfs(int[] source, int[] target, Set<String> blocks){
        Set<String> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        seen.add(source[0] + ":" + source[1]);
        queue.offer(source);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < dirc.length; i++){
                int newX = cur[0] + dirc[i][0];
                int newY = cur[1] + dirc[i][1];
                if(newX < 0 || newX >= limit || newY < 0 || newY >= limit){
                    continue;
                }
                if(blocks.contains(newX + ":" + newY) || seen.contains(newX + ":" + newY)){
                    continue;
                }
                if(newX == target[0] && newY == target[1]){
                    return true;
                }
                queue.add(new int[]{newX, newY});
                seen.add(newX + ":" + newY);
            }
            // 这一步很关键，是判断是否围成了一个封闭区间。围成封闭区间，里面会有19900个点
            if(seen.size() == 20000){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

