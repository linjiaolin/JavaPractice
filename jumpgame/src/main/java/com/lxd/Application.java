package com.lxd;

import org.springframework.util.Assert;

public class Application {

    public static void main(String[] args) {

        int[] nums1 = new int[]{0};
        Assert.isTrue(Solution.getInstance().canJump(nums1)==true, "test1 应为 true.");

        int[] nums2 = new int[]{2,0};
        Assert.isTrue(Solution.getInstance().canJump(nums2)==true, "test1 应为 true.");

        int[] nums3 = new int[]{3,2,1,0,4};
        Assert.isTrue(Solution.getInstance().canJump(nums3)==false, "test1 应为 false.");

        int[] nums4 = new int[]{2,3,1,1,4};
        Assert.isTrue(Solution.getInstance().canJump(nums4)==true, "test1 应为 true.");

        System.out.println("work is done.");
    }

}
