package Easy.ArrayTest;


/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/

/**
 * @author 马世臣
 * @// TODO: 2020/1/27 53. 最大子序和 */

public class maxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int best=Integer.MIN_VALUE;
        int curRes=0;
        for (int i:nums){
            if(curRes+i>i){
                curRes+=i;
            }else {
                curRes=i;
            }
            if(curRes>best){
                best=curRes;
            }
        }
        return best;
    }


    //分治算法
    public int maxSubArray2(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {

    }
}
