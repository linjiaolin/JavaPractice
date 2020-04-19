package com.lxd;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0) return 0;
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int counts1=0;//经历多少s1
        int counts2=0;//经历多少s2
        int curIndexS2=0;//当前在s2的位置

        while(counts1<n1){// 循环每个 s2
            for(int i=0;i<len1;i++){// 将 s2 与 s1 的字符数组，从第一个开始依次对比是否相同
                char c1 = charArray1[i];
                char c2 = charArray2[curIndexS2];
                boolean isEq = c1==c2;
                if(isEq){
                    curIndexS2++;
                }
                if(curIndexS2==len2){
                    curIndexS2 = 0;
                    counts2++;
                }
            }
            // 当前这个 s1 对比后计数器要 +1
            counts1++;
        }

        return counts2/n2;
    }
}