package com.lxd;

import sun.misc.Queue;

import java.util.*;

import static java.util.Arrays.asList;

public class Initialation {
    public Initialation() {
    }

    public TreeNode init(Integer[] nums){
        return this.createBinaryTree(nums, 0);
    }

    private TreeNode createBinaryTree(Integer[] nums, int index){
        TreeNode node = null;

        if(index<nums.length){
            Integer num = nums[index];
            if(num==null){
                return null;
            }

            node = new TreeNode(num);
            node.left = this.createBinaryTree(nums, 2*index+1); // create left node
            node.right = this.createBinaryTree(nums, 2*index+2); // create right node
        }

        return node;
    }
}
