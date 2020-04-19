package com.lxd;

import org.springframework.util.Assert;

public class Application {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Application app = new Application();

        int test1 = app.test1(solution);
        Assert.isTrue(test1==2, "test1 验证失败！");

        int test2 = app.test2(solution);
        Assert.isTrue(test2==4, "test2 验证失败！");
    }

    public int test1(Solution solution){
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        int maxRepetitions = solution.getMaxRepetitions(s1, n1, s2, n2);

        System.out.println(maxRepetitions);
        return maxRepetitions;
    }

    public int test2(Solution solution){
        String s1 = "aaa";
        int n1 = 3;
        String s2 = "aa";
        int n2 = 1;
        int maxRepetitions = solution.getMaxRepetitions(s1, n1, s2, n2);

        System.out.println(maxRepetitions);
        return maxRepetitions;
    }
}
