package com.qiyu.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qiyu on 2018/4/14
 *         System.out.println(x);
 *         // 异或，按位相同为0 不同为1
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int T = input.nextInt();
//        int[] n = new int[T];
//        int[] m = new int[T];
//        int inputCount = 0;
//        while (inputCount < T){
//            n[inputCount] = input.nextInt();
//            m[inputCount] = input.nextInt();
//            inputCount++;
//        }
        //fm+1(x)=f(fm(x))
        //fm(x)=n 求x
//        int m = 3;
//        while (m > 0) {
//            int x = 123;
//            int fx = x;
//            while (x % 10 > 0) {
//                fx += x%10;
//                x = x/10;
//            }
//        }
        //n<10^18 m<10^5, 求f(x)=n的x 得出x<10^18
        //那么一个个试一下？
        int n = input.nextInt();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < Math.pow(10, 8)) {
            if (outN(i) == n) {
                result.add(i);
            }
            i++;
        }
        System.out.println(result);

    }
    static int outN(int x){
        int n = x;
        int pow=1;
        while(pow < 18){
            n += x % 10;
            x /= 10;
            pow++;
        }
        return n;
    }
}
