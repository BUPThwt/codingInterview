import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                chess[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList();
        backTracing(chess, 0, result);
        return result.size();
    }


    private void backTracing(char[][] chess, int row, List<List<String>> result){
        if(row == chess.length){
            result.add(construct(chess));
            return;
        }
        for(int i = 0; i < chess[row].length; i++){
            if(valid(row, i, chess)){
                chess[row][i] = 'Q';
                backTracing(chess, row + 1, result);
                chess[row][i] = '.';
            }
        }
    }

    private boolean valid(int row, int col, char[][] chess){
        for(int i = row; i >= 0; i--){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row, j = col; i >=0 && j>=0; i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row, j = col; i >=0 && j < chess[row].length; i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < chess.length; i++){
            res.add(new String(chess[i]));
        }
        return res;
    }
}
// @lc code=end

