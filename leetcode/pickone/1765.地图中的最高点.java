import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1765 lang=java
 *
 * [1765] 地图中的最高点
 */

// @lc code=start
class Solution {
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int a = position[0];
            int b = position[1];
            for(int i = 0; i < 4; i++){
                int x = a + direction[i][0];
                int y = b + direction[i][1];
                if(x >= 0 && x < m && y >= 0 && y < n && result[x][y] == 0 && isWater[x][y] == 0){
                    result[x][y] = result[a][b] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return result;

    }
}
// @lc code=end

