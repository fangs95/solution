package com.fangs.sort;

/**
 * 归并排序
 *
 * @author fangs
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] p = {123, 23, 632, 1, 12, 345, 3, 7, 4, 1, 67, 15, 43};
        int[] res = sort(p);
        for (int re : res) {
            System.out.printf(re + " ");
        }
    }

    public static int[] sort(int[] p) {
        if (p.length == 1) {
            return p;
        }
        int mid = p.length / 2;
        int[] a = new int[mid];
        System.arraycopy(p, 0, a, 0, a.length);
        int remain = p.length - mid;
        int[] b = new int[remain];
        System.arraycopy(p, mid, b, 0, b.length);
        return merge(sort(a), sort(b));
    }

    public static int[] merge(int[] a, int[] b) {
        int l = a.length + b.length;
        int[] res = new int[l];
        int i = 0, j = 0;
        for (int k = 0; k < l; k++) {
            if (i >= a.length) {
                res[k] = b[j++];
            } else if (j >= b.length) {
                res[k] = a[i++];
            } else if (a[i] > b[j]) {
                res[k] = b[j++];
            } else {
                res[k] = a[i++];
            }
        }
        return res;
    }

}
