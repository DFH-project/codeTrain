package dfh.train.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class array {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。
     * 然后返回 nums 中与 val 不同的元素的数量。
     *
     * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
     *
     * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
     * 返回 k。
     */
    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=val){
                nums[k]=nums[i];
                k++;
            }
        }

        return k;
    }


    /**
     * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
     * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
     *
     * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
     * 返回 k 。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int m  = 1 ;
        int n = 1 ;
        while (m<nums.length){
            if (nums[m] != nums[m-1]){
                nums[n]= nums[m];
              n++;
            }
            m++;
        }
        return n;
    }

    public int removeDuplicates2(int[] nums) {
        // [1,1,1,2,2,3]
        int m = 1;
        int n = 1;
        while (m<nums.length){
            if (m<2 ||nums[m] != nums[m-2] ){
                nums[n] = nums[m];
                n++;
            }
            m++;
        }
        return n;
    }

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    public int majorityElement(int[] nums) {
        int m=nums.length;
        float n = m/2;
        int[] re = {0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int number:nums){
            map.put(number,map.getOrDefault(number,0)+1);
            if(map.get(number) > n){
                return number;
            }
        }
        return 0;
    }
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int getMost(int[] nums, int i){
        int most=nums[i];
        int count =1;
        i++;
        while (i < nums.length){
            if (nums[i] == most){
                count++;
            }else if (count >0){
                count--;
            }else {
                getMost(nums,i);
            }
            i++;
        }
        return most;
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n =nums.length;
        int[] roates = new int[n];

        for (int i = 0; i < n; i++) {
//            if (n >k){ // 自己的麻烦写法
//                if (i+k <= n-1){
//                    roates[i+k] = nums[i];
//                }else{
//                    roates[i+(k-n)] = nums[i];
//                }
//            }else{
//                int m =k%n;
//                if (i+m <= n-1){
//                    roates[i+m] = nums[i];
//                }else{
//                    roates[i+(m-n)] = nums[i];
//                }
//            }
            roates[(i+k)%n] = nums[i];
        }
        System.arraycopy(roates,0,nums,0,nums.length);
    }


    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     * 示例 1：
     *
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
     * 最大总利润为 4 + 3 = 7 。
     * @param args
     */
    public int maxProfit2(int[] prices) {  // 7 1 5 3 6 4
        int count=0;
        int max=0;
        int min=Integer.MAX_VALUE; //7
        for (int i =0;i<prices.length;i++) {
            int price = prices[i];
            min = Math.min(price,min);
            int m =price-min;
            if (m >=max){
                max = m;
                if (i == prices.length-1){
                    count+=max;
                }
            }else{
                count+=max;
                min = price;
                max = 0;
            }
        }
        return count;
    }


    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * 示例 1
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {  // 贪心法
        if(nums.length==1) return true;
        int m = 0;
        for (int i = 0; i <nums.length; i++) {
            if (i <= m){
                m = Math.max(m,i+nums[i]);
                if (m > nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 正向查找可到达的最大位置
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

     * 示例 1:
     *
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */

    public int jump(int[] nums) { //22014
        int n = nums.length;
        if (n == 1) return 0;
        int now = 0 ; int next = 0; int count = 0;
        for (int i = 0; i < n; i++) {
            next= Math.max(next , nums[i]+i);
            if (i == now){
                now = next;
                count++;
            }
        }
        return count;
    }
    // 反向查找
    public int jump2(int[] nums) {
        int n = nums.length-1;
        if (n == 1) return 0;
        int count = 0;
        while(n >0){
            for (int i = 0; i < n; i++) {
                if (i+nums[i] >= n ){
                    n=i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }



    public int hIndex(int[] citations) {

        return 0;
    }









    public static void main(String[] args) {

    }

}
