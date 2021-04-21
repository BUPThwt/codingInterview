import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.graalvm.compiler.api.replacements.Fold;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=1418 lang=java
 *
 * [1418] 点菜展示表
 */

// @lc code=start
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Map<String, Integer>> tableMap = new HashMap<>();
        Set<String> foodItemSet = new HashSet<>();
        for(List<String> order : orders){
            String tableId = order.get(1);
            Map<String, Integer> tableFood = tableMap.computeIfAbsent(tableId, key -> new HashMap<String, Integer>());
            tableFood.put(order.get(2), tableFood.getOrDefault(order.get(2), 0) + 1);
            foodItemSet.add(order.get(2));
        }
        List<String> foodList = new ArrayList<>();
        for(String food : foodItemSet){
            foodList.add(food);
        }
        Collections.sort(foodList);
        List<String> firstLine = new ArrayList<>();
        firstLine.add("Table");
        for(String food : foodList){
            firstLine.add(food);
        }
        result.add(firstLine);
        List<Integer> tableList = new ArrayList<>();
        for(String tableId : tableMap.keySet()){
            tableList.add(Integer.valueOf(tableId));
        }
        Collections.sort(tableList);
        for(Integer tableId : tableList){
            List<String> line = new ArrayList<>();
            Map<String, Integer> foodMap = tableMap.get(String.valueOf(tableId));
            line.add(String.valueOf(tableId));
            for(int i = 0; i < foodList.size(); i++){

                line.add(foodMap.getOrDefault(foodList.get(i), 0).toString());
            }
            result.add(line);
        }
        return result;
    }
}
// @lc code=end

