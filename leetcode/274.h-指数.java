import javax.print.CancelablePrintJob;
import javax.sound.midi.MidiChannel;

/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length;
        while(low < high){
            // 因为要不断向右靠近（取x的最大值），所以需要取天花板值
            int mid = low + high + 1 >> 1;
            if(check(citations, mid)){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean check(int[] citations, int num){
        int ans = 0;
        for(int citation : citations){
            if(citation >= num){
                ans++;
            }
        }
        return ans >= num;
    }
}
// @lc code=end

