package me.slimfun.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yh on 2016/3/14.
 */
public class SortTest {
    public static void insertSort(int[] nums){
        for(int i=1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    private  static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= high) {
            temp[k++] = nums[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            nums[low + p] = temp[p];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static int partition(int[] nums, int low, int high){
        int x = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < x) {
                exchange(nums,++i,j);
            }
        }
        exchange(nums, ++i, high);
        return i;
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int q = partition(nums,low,high);
            quickSort(nums, low, q-1);
            quickSort(nums, q + 1, high);
        }
    }

    private static void exchange(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    private static int ramdomPartition(int[] nums, int low, int high) {
        int i = new Random().nextInt(high - low) + low;
        exchange(nums, i, high);
        return partition(nums, low, high);
    }

    public static void randomQuickSort(int[] nums, int low, int high) {
        if (low < high) {
            int q = ramdomPartition(nums,low,high);
            randomQuickSort(nums, low, q-1);
            randomQuickSort(nums, q + 1, high);
        }
    }

    private static void maxHeapify(int[] nums,int i,int heapSize) {
        int l = i * 2 + 1;
        int r = (i + 1) * 2;
        int largest = i;
        if (l <= heapSize && nums[l] > nums[i]) {
            largest = l;
        }
        if (r <= heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(nums, i, largest);
            maxHeapify(nums, largest,heapSize);
        }
    }

    public static void buildMaxHeap(int[] nums,int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i,heapSize);
        }
    }

    public static void heapSort(int[] nums) {
        int heapSize = nums.length-1;
        buildMaxHeap(nums, heapSize);
        while (heapSize >= 1) {
            exchange(nums, 0, heapSize--);
            maxHeapify(nums, 0, heapSize);
        }
    }

    public static int heapMaximum(int[] nums){
        return nums[0];
    }

    public static int heapExtractMax(int[] nums, int heapSize) {
        int max = nums[0];
        exchange(nums, 0, heapSize--);
        maxHeapify(nums, 0, heapSize);
        return max;
    }

    public static void heapIncreaseKey(int[] nums, int i, int k) {
        if (k <= nums[i]) {
            return;
        }
        nums[i] = k;
        while (i >= 1 && nums[parent(i)] < nums[i]) {
            exchange(nums, i, parent(i));
            i = parent(i);
        }
    }

    public static void maxHeapInsert(int[] nums, int key) {
        heapIncreaseKey(nums, nums.length - 1, key);
    }

    private static int parent(int i) {
        int parent = i / 2;
        if (i % 2 == 0) {
            //偶数结点的父节点是i/2-1
            parent = parent - 1;
        }
        return parent;
    }


}
