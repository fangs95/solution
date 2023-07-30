package com.fangs.sort;

/**
 * 快速排序
 * 思路为选择一个基准值  以基准值为界将数据分为2部分  一直递归到数组完成排序
 * @author fangs
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        QuickSort.sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
    }

    public static void sort(int[] p,int b,int e){
        if(b >= e){
            return;
        }
        //获取基准值
        int z = p[b];
        //使用双指针从左右分别相向寻找  左边的指针寻找比基准值大的元素  右指针寻找比基准值小的元素  找到后互换位置
        int l=b+1,r=e;
        for (;;){
            while (l<=r && p[l]<=z){
                l++;
            }
            while(l<=r && p[r]>z){
                r--;
            }
            if(l>=r){
                break;
            }
            swap(l,r,p);
        }
        //将基准值交换到正确位置 123
        swap(b,r,p);

        sort(p,b,r-1);
        sort(p,r+1,e);
    }

    public static void swap(int l,int r,int[] arr){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

}
