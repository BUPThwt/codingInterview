import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

import javax.xml.catalog.CatalogFeatures.Feature;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        int[] frequency = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars){
            frequency[c]++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character o1, Character o2){
                return frequency[o2] - frequency[o1];
            }
        });
        for(int j = 0; j < 128; j++){
            if(frequency[j] != 0){
                queue.offer((char)j);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char ch = queue.poll();
            while(frequency[ch] > 0){
                sb.append(ch);
                frequency[ch]--;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

