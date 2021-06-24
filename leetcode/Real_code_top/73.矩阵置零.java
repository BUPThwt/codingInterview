import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.css.CSS2Properties;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    // 空间  m+n
    public void setZeroes1(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 原地修改
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                col0 = true;
                break;
            }
        }
        for(int j = 0; j < col; j++){
            if(matrix[0][j] == 0){
                row0 = true;
                break;
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(col0){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        if(row0){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }

    }
        
}
// @lc code=end

