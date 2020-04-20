package com.lxd;

class Solution {
    public static Solution getInstance(){
        return new Solution();
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len==1){
            return true;
        }

        for(int i=0;i<len;i++){
            int element = nums[i];
            if(element==0 && !this.isOverZero(len, nums, i)){
                return false;
            }
        }

        return true;
    }

    private boolean isOverZero(int len, int[] nums, int index){
        boolean hasOverZeroPosition = false;

        for(int i=index-1;i>=0;i--){
            int lengthFromCurToEnd = i + nums[i];
            if(len-1==index && lengthFromCurToEnd == index){
                hasOverZeroPosition = true;
            }else if(lengthFromCurToEnd > index){
                hasOverZeroPosition = true;
            }
        }

        return hasOverZeroPosition;
    }
}
