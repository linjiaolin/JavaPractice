package com.lxd;

import org.springframework.util.Assert;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        Initialation initialation = new Initialation();

        Integer[] nums = {1, 2, 3, null, 5, null, 4};
        TreeNode root = initialation.init(nums);
        Assert.isTrue(Arrays.equals(Solution.getInstance().rightSideView(root).toArray(), new Integer[]{1,3,4}), "test1 应为 true！");

        System.out.println("work is done.");
    }

}
