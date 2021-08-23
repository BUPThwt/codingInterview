/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int loop = n >> 1;
        int offset = 1;
        int startx = 0;
        int starty = 0;
        while(loop-- > 0){
            int x = startx;
            int y = starty;
            for(; y < starty + n - offset; y++){
                result[x][y] = count++;
            }
            for(; x < startx + n - offset; x++){
                result[x][y] = count++;
            }
            for(; y > starty; y--){
                result[x][y] = count++;
            }
            for(; x > startx; x--){
                result[x][y] = count++;
            }
            startx++;
            starty++;
            offset += 2;
        }
        if((n & 1) == 1){
            result[n / 2][n / 2] = count;
        }
        return result;
    }
}
// @lc code=end

