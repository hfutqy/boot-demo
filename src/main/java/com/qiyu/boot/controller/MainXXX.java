package com.qiyu.boot.controller;

import java.util.*;

/**
 * 白色相簿问题
 * Created by qiyu on 2018/4/9
 */
public class MainXXX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int inputCount = m;
        int[][] relationList = new int[m][2];
        while (inputCount > 0) {
            relationList[m - inputCount][0] = input.nextInt();
            relationList[m - inputCount][1] = input.nextInt();
            inputCount--;
        }
        //x关系yList yList关系zList 判断zList是否有x 有flag=1无flag=0
        int flag = 0;
        List<Integer> yList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = relationList[i][0];
            int y = relationList[i][1];
            for (int j = i + 1; j < m; j++) {
                if (relationList[j][0] == y) {
                    yList.add(relationList[j][1]);
                }
                if (relationList[j][1] == y) {
                    yList.add(relationList[j][0]);
                }
            }
            List<Integer> zList = new ArrayList<>();
            for (int ii = i + 1; ii < m; ii++) {
                for (int jj = ii; jj < m; jj++) {
                    if (yList.contains(relationList[jj][0])) {
                        zList.add(relationList[jj][1]);
                    }
                    if (yList.contains(relationList[jj][1])) {
                        zList.add(relationList[jj][0]);
                    }
                }
            }
            //zList有x形成闭环
            if (zList.contains(x)) {
                flag = 1;
                break;
            }
        }
        System.out.print(flag);
    }
}
