import java.lang.invoke.ClassSpecializer.Factory;
import java.util.concurrent.ForkJoinTask;

import org.graalvm.compiler.nodes.spi.CoreProviders;

/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];
        int x0 = point2[0] - point1[0];
        int y0 = point2[1] - point1[1];
        for(int i = 2; i < coordinates.length; i++){
            int x = coordinates[i][0] - point1[0];
            int y = coordinates[i][1] - point1[1];
            if((x0 * y - y0 * x) != 0){
                return false;
            }
        }
        return true;
        
    }
}
// @lc code=end

