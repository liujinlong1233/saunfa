package com.company.day02;

import jdk.dynalink.linker.LinkerServices;

import java.text.DecimalFormat;
import java.util.*;

public class day3 {
//    求1000之内的所有完数和。
//
//    一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数的和。


    /***
     * 求第K个因子
     * 给你两个正整数n 和k。范围: 1 <= k <= n <= 1000
     * 如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n的因子。
     * 考虑整数 n的所有因子，将它们 升序排列。请你返回第 k个因子。如果 n的因子数少于 k，请你返回 -1。
     * 举例：
     * 输入：n = 4, k = 4
     * 输出：-1
     * 输入：n = 4, k = 3
     * 输出：4
     * 解释：因子列表包括 [1, 2, 4] ，只有 3 个因子，所以我
     */


    public static int s(int n,int k){
        List<Integer> a=new ArrayList<>();
        for(int i=1;i<n;i++){
            if (n%i==0){
                int b=n/i;
                if (!a.contains(i)&&!a.contains(b)){
                    if(b==i){
                        a.add(i);
                    }else {
                        a.add(i);
                        a.add(n);
                    }
                }
            }
        }
        Object[] objects = a.toArray();
        Arrays.sort(objects);
        if (a.size()>=k){
            return (int)objects[k-1];
        }else {
            return -1;
        }

    }


    /**
     * 给定一个整数数组，数组中有一个数出现了一次，其他数出现了两次，请找出只出现了一次的数。
     * 数据范围：数组中元素个数满足 1≤n≤100000  ，数组中的元素大小满足∣val∣≤10^9
     *   示例1 输入：[1]
     * 返回值：1
     *
     * 示例2 输入：[1,2,2]
     * 返回值：1
     *
     * 示例3 输入：[2,3,2,1,1]
     * 返回值：3
     *
     * 示例4 输入：[-1,2,-1]
     * 返回值：2
     */
    public static int getOnlyOne(int[] a){
        int c=0;
        for(int i=0;i<a.length;i++){
            Boolean b=false;
            for(int j=0;j<a.length;j++){
                if (i!=j&&a[i]==a[j]){
                    b=true;
                }
            }
            if (b==false){
                c=a[i];
            }
        }
        return c;
    }

    public static void main(String[] args) {
       String a="sfsfsaf.jpg";
        System.out.println(a.substring(a.length()-4));

    }

}
