package ebay;

import utility.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeMultipleSortedArray {

    static int[] merge(int[] arr1, int[] arr2, int[] arr3) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;

        int[] ans = new int[len1 + len2 + len3];
        int i = 0;

        while (idx1 < len1 && idx2 < len2 && idx3 < len3) {
            int smallest = 1;
            int val = arr1[idx1];

            if (val > arr2[idx2]) {
                smallest = 2;
                val = arr2[idx2];
            }

            if (val > arr3[idx3]) {
                smallest = 3;
                val = arr3[idx3];
            }

            if (smallest == 1) {
                ans[i++] = arr1[idx1++];
            } else if (smallest == 2) {
                ans[i++] = arr2[idx2++];
            } else {
                ans[i++] = arr3[idx3++];
            }
        }

        while (idx1 < len1) {
            ans[i++] = arr1[idx1++];
        }
        while (idx2 < len2) {
            ans[i++] = arr2[idx2++];
        }
        while (idx3 < len3) {
            ans[i++] = arr3[idx3++];
        }

        for (int n : ans) {
            System.out.print(n + ", ");
        }

        return ans;
    }

    static class Data {
        int idx;
        int[] arr;

        public Data(int[] arr) {
            Arrays.sort(arr);
            this.arr = arr;
        }

        int getVal() {
            return arr[idx++];
        }

        boolean isEnd() {
            return idx == arr.length;
        }
    }

    static int[] merge(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        Data[] data = new Data[m];
        for (int i = 0; i < m; i++) {
            data[i] = new Data(arr[i]);
        }

        PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparingInt(d -> d.arr[d.idx]));
        for (Data d : data) {
            q.offer(d);
        }

        int i = 0;
        int[] ans = new int[n * m];

        while (i < n * m) {
            Data d = q.poll();
            ans[i++] = d.getVal();

            if (!d.isEnd()) {
                q.offer(d);
            }
        }

        Utils.printArray(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[0];// {4, 11, 77,23, 3};
        int[] arr2 = new int[] {99, 14, 7,123};
        int[] arr3 = new int[] {9, 2, 1, 61, 38, 12};

//        merge(arr1, arr2, arr3);

        int[][] arr = new int[][] {
                {4,  11, 77,  23, 3},
                {99, 14,  7, 123, 10},
                {9,   2,  1,  61, 38}
        };

        merge(arr);

    }
}
