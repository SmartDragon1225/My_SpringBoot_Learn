package com.tian.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {0,-3,-2,6,-7,4,8,7,2};
        System.out.println("堆排序前"+ Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后"+Arrays.toString(arr));
    }

    public static void adjust(int arr[],int i,int length){
        int temp = arr[i];//当前节点
        for (int j = 2*i+1; j < length; j=2*i+1) {
            if(arr[j+1]>arr[j] && j+1<length){
                j++; //右子节点大于左子节点
            }
            if(arr[j]>temp){//子节点大于父节点
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
        }
        arr[i] = temp;//继续交换
    }

    /**
     * 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
     * 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
     * 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
     *                  */
    public static void heapSort(int arr[]){
        for (int i = arr.length/2; i >= 0; i--) {
            adjust(arr,i,arr.length);
        }
        //构建大顶堆
        for (int i = arr.length-1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            adjust(arr,0,i);
        }
    }
}
