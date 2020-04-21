package com.lxd;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static Solution getInstance(){
        return new Solution();
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // 数组长度
        int len = nums.length;

        // 找到数组中奇数的索引
        List<Integer> odds = new ArrayList();
        for(int i=0;i<len;i++){
            if(nums[i] % 2 == 0){
                continue;
            }
            odds.add(i);
        }

        // 奇数数组的长度
        int oddsLen = odds.size();

        // 如果奇数的数量不如 k 个的要求的话，永远找不到子数组
        if(oddsLen<k) return 0;

        // 计算每对连续的奇数可能产生的子数组组合
        int maxIndex = (oddsLen - 1);
        int result = 0;
        for(int i=0;(i+k-1)<oddsLen;i++){
            // 左边的奇数的索引
            int leftIndex = i;
            // 右边的奇数的索引
            int rightIndex = i+k-1;

            // 左边的偶数数量
            int leftEvenCount = 0;
            // 右边的偶数数量
            int rightEvenCount = 0;

            if(leftIndex==0){
                leftEvenCount = odds.get(leftIndex);
            }else{
                leftEvenCount = odds.get(leftIndex) - odds.get(leftIndex - 1) - 1;
            }

            if(rightIndex>=maxIndex){
                rightEvenCount = (len - 1) - odds.get(maxIndex);
            }else{
                rightEvenCount = odds.get(rightIndex + 1) - odds.get(rightIndex) - 1;
            }

            result = result + (leftEvenCount + 1) * (rightEvenCount + 1);
        }

        return result;
    }
}
