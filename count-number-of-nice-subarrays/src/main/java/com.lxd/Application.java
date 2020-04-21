package com.lxd;

import org.springframework.util.Assert;

public class Application {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,1,2,1,1};
        int k1 = 3;
        Assert.isTrue(Solution.getInstance().numberOfSubarrays(nums1, k1)==2, "test1 应为 true.");

        int[] nums2 = new int[]{2,2,1,2,2,1,2,1,2,2,2,1,2};
        int k2 = 2;
        Assert.isTrue(Solution.getInstance().numberOfSubarrays(nums2, k2)==22, "test2 应为 true.");

        System.out.println("work is done.");
    }

}
