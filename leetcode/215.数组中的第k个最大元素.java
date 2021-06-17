import java.util.Arrays;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> queue = new PriorityQueue<>();
    //     for(int i = 0; i < nums.length; i++){
    //         if(queue.size() < k){
    //             queue.offer(nums[i]);
    //         }
    //         else{
    //             queue.offer(nums[i]);
    //             queue.poll();
    //         }
    //     }
    //     return queue.peek();
    // }

    public int findKthLargest(int[] nums, int k){
        quickSort(nums);
        return nums[nums.length - k];
    }

    private int[] quickSort(int[] nums){
        if(nums.length < 2){
            return nums;
        }
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSortHelper(int[] nums, int low, int high){
        if(low < high){
            int position = partition(nums, low, high);
            quickSortHelper(nums, low, position - 1);
            quickSortHelper(nums, position + 1, high);
        }
    }


    private int partition(int[] nums, int low, int high){
        int num = nums[low];
        while(low < high){
            while(low < high && nums[high] >= num){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= num){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = num;
        return low;
    }
}


// @lc code=end

