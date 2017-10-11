package sort;

import utility.Utils;

public class MinHeapSort {

    public void heapSort(int[] nums) {
        for (int i = (nums.length/2 - 1); i >= 0 ; i--) {
            heapify(i, nums.length, nums);
        }

        Utils.printArray(nums);

        for (int i = (nums.length-1); i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(0, i, nums);
        }
    }

    public void heapSortDes(int[] nums) {
        for (int i = (nums.length/2 - 1); i >= 0 ; i--) {
            heapify(i, nums.length, nums);
        }

        Utils.printArray(nums);

        for (int i = (nums.length-1); i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(0, i, nums);
        }

    }

    private void heapify(int i, int len, int[] nums) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }

        if (i != largest) {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;

            heapify(largest, len, nums);
        }
    }

    public static void main(String[] args) {
        int arr[] = {14,15,7,6,16,9,5,4,10,17,3,12,2,18,19,1,8,12};

        MinHeapSort ob = new MinHeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        Utils.printArray(arr);
    }


}
