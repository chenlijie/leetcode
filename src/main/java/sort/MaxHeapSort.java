package sort;

public class MaxHeapSort {

    public void heapSort(int[] nums) {
        for (int i = (nums.length/2 - 1); i >= 0 ; i--) {
            heapify(i, nums.length, nums);
        }

        printArray(nums);

        for (int i = (nums.length-1); i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(0, i, nums);
        }

    }

    private void heapify(int i, int len, int[] nums) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left < len && nums[left] < nums[smallest]) {
            smallest = left;
        }

        if (right < len && nums[right] < nums[smallest]) {
            smallest = right;
        }

        if (i != smallest) {
            int temp = nums[smallest];
            nums[smallest] = nums[i];
            nums[i] = temp;

            heapify(smallest, len, nums);
        }
    }

    public static void main(String[] args) {
//        sort(new int[]{14,15,7,6,16,9,5,4,10,17,3,12,2,18,19,1,8,12});
        int arr[] = {7,6,5,4,8,3,2,1};
        int n = arr.length;

        MaxHeapSort ob = new MaxHeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
    

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }



}
