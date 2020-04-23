package com.lxd;

import java.util.*;

/**
 * @description //TODO 深度优先算法
 * @author 刘旭东
 * @date 2020/4/23 22:52
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static Solution getInstance(){
        return new Solution();
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightsAtDeep = new HashMap<Integer, Integer>();

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> deepStack = new Stack<Integer>();

        nodeStack.push(root);
        deepStack.push(0);

        int maxDeep = -1;
        while(!nodeStack.isEmpty()){
            // 从栈中（也就是从最右边）拿出一个 节点 和 代表节点的深度
            TreeNode node = nodeStack.pop();
            int deep = deepStack.pop();

            // 如果这个节点不为空，那这一层的最右边的就是它了
            // 如果这个节点为空，就继续在下一次循环里拿出比较靠右的节点
            if(node!=null){
                // 创建下一层节点们，先放 左节点，再放 右节点，以保证可以从右往左查看这一层的每个节点
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                deepStack.push(deep+1);
                deepStack.push(deep+1);

                // 得到当前深度
                maxDeep = Math.max(maxDeep, deep);

                // 如果当前深度已经有了值了，跳过
                if(!rightsAtDeep.containsKey(deep)){
                    rightsAtDeep.put(deep, node.val);
                }
            }
        }

        List<Integer> rights = new ArrayList<Integer>();
        for(int i=0;i<=maxDeep;i++){
            rights.add(rightsAtDeep.get(i));
        }

        return rights;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

