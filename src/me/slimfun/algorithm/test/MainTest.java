package me.slimfun.algorithm.test;

import me.slimfun.algorithm.sort.SortTest;

/**
 * Created by yh on 2016/3/14.
 */
public class MainTest {
    private static int[] nums = {5,2,4,6,1,3};

    private static void printNums(){
        for(int n : nums)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String args[]) {
//        SortTest.insertSort(nums);
//        printNums();
//        SortTest.mergeSort(nums,0,nums.length-1);
//        printNums();
        SortTest.randomQuickSort(nums, 0, nums.length - 1);
        printNums();
    }
}
