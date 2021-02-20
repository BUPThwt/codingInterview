/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                money[0]++;
            }else if(bills[i] == 10){
                if(money[0] == 0){
                    return false;
                }else{
                    money[0]--;
                    money[1]++;
                }
            }else if(bills[i] == 20){
                if(money[1] >= 1 && money[0] >= 1){
                    money[0]--;
                    money[1]--;
                    money[2]++;
                }else if(money[0] >= 3){
                    money[0] -= 3;
                    money[2]++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

