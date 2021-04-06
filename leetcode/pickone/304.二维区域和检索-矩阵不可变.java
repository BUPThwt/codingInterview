/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    // int[][] matrix;

    // public NumMatrix(int[][] matrix) {
    //     this.matrix = matrix;
    // }
    
    // public int sumRegion(int row1, int col1, int row2, int col2) {
    //     int sum = 0;
    //     for(int i = row1; i <= row2; i++){
    //         for(int j = col1; j <= col2; j++){
    //             sum += matrix[i][j];
    //         }
    //     }
    //     return sum;
    // }


    // 前缀和
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row + 1][col + 1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

