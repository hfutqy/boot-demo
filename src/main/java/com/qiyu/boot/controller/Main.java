package com.qiyu.boot.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by qiyu on 2018/4/14
 */

/*
给定一个 nn 个点 mm 条边的连通无向图，其中点从 11 到 nn 标号，而每条边有一个危险值。
对于任意一条路径，定义路径上危险值的最大值为这条路径的危险值。
对于任意不同的两点 uu 和 vv，定义 d(u, v)d(u,v) 为所有从 uu 到 vv 的路径的危险值最小值。
对于每个点 uu，定义 f_u = \sum\limits_{1 \leq v \leq n, u \neq v}{d(u, v)}f
u =1≤v≤n,u≠v
∑ d(u,v)，表示点 uu 的危险程度。
你的任务就是计算每个点的危险程度。
为了便于输出，你只需要给出 \mathop{\oplus}\limits_{i = 1}^{n}{\left(i \cdot f(i)\right)}
i=1⊕n(i⋅f(i)) 的值即可，其中 \oplus⊕ 代表按位异或。

输入格式
第一行包含一个正整数 TT，表示有 TT 组测试数据。
接下来依次描述 TT 组测试数据。对于每组测试数据：
第一行包含两个正整数 nn 和 mm。
接下来 mm 行，每行描述一条无向边，包含三个正整数 uu, vv 和 ww，表示有一条连接点 uu 与点 vv 的无向边，其危险值是 ww。
注意，任意两点可能直接连有多条边，而且边的两个端点可能相同。
保证 1 \leq T \leq 2001≤T≤200, 1 \leq n \leq 10^51≤n≤10
5 , n - 1 \leq m \leq 3 \times 10^5n−1≤m≤3×10
5 , 1 \leq u, v \leq n1≤u,v≤n, 0 \leq w \leq 10^90≤w≤10
9 。
保证所有测试数据的 nn 之和不超过 10^610
6 ，mm 之和不超过 2 \times 10^62×10
6 。
输出格式
对于每组测试数据，输出一行信息"Case #x: y"（不含引号），其中x表示这是第x组测试数据，y表示这组测试数据需要给出的值。
提示
对于第一组样例，有 f(1) = f(2) = 16f(1)=f(2)=16, f(3) = f(4) = 15f(3)=f(4)=15, f(5) = 20f(5)=20。
样例输入
1
5 10
1 5 10
1 4 6
1 3 4
5 5 0
1 1 1
2 1 3
4 3 2
5 1 5
5 2 9
3 5 7
样例输出
Case #1: 69
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] nList = new int[T];
        int[] mList = new int[T];
        List<List<BeanUVW>> beanUVWList = new ArrayList<>();
        for(int i = 0; i<T; i++) {
            nList[i] = input.nextInt();
            mList[i] = input.nextInt();
            for(int j=0; j<mList[i]; j++) {
                List<BeanUVW> tList = new ArrayList<>();
                BeanUVW uvw = new Main().new BeanUVW();
                uvw.setU(input.nextInt());
                uvw.setU(input.nextInt());
                uvw.setU(input.nextInt());
                tList.add(uvw);
                beanUVWList.add(tList);
            }
        }
        System.out.println("输入完毕");
        for(int i=0; i<T; i++){
            //处理输入，获取最小危险值d(u,v)，在获取危险程度f(u)=∑d(u,v)
            List<BeanUVW> tList = beanUVWList.get(i);
            int n = nList[i];
            int m = mList[i];
            for (int x = 0; x < mList[i]; x++) {
                //整理tList
                BeanUVW uvwX = tList.get(x);
                for (int y = x+1; x < mList[i]-1; y++) {
                    BeanUVW uvwY = tList.get(y);
                    if ((uvwX.getU() == uvwY.getU() && uvwX.getV() == uvwY.getV())
                            || (uvwX.getV() == uvwY.getU() && uvwX.getU() == uvwY.getV())) {
                        if (uvwX.getW() > uvwY.getW()) {
                            tList.get(x).setW(uvwY.getW());
                        }
                    }
                }
            }
            //现在的tList 里面的w都是最小的;再获取fu
            int[] fu = new int[n];
            for(int j=0; j<n; j++){
                for(int h=0; h<n; h++){
                    if(tList.get(j).getU() == j){
                        fu[j] += tList.get(j).getW();
                    }
                }
            }


        }




    }
    class BeanUVW {
        private int u;
        private int v;
        private int w;
        public int getU() {
            return u;
        }
        public void setU(int u) {
            this.u = u;
        }
        public int getV() {
            return v;
        }
        public void setV(int v) {
            this.v = v;
        }
        public int getW() {
            return w;
        }
        public void setW(int w) {
            this.w = w;
        }
    }
}


