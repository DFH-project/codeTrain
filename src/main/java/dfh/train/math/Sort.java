package dfh.train.math;

import java.util.Arrays;



public class Sort {

    static  int[] nums = new int[]{4,2,8,5,9,1,7,0};

    //冒泡排序
    void sort1(){
        for (int i = 0; i < nums.length; i++) {
            for (int j= i +1 ; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    int term = nums[i];
                    nums[i] = nums[j];
                    nums[j] = term;
                }
            }
        }
    }

    //选择排序
    void sort2(){
        for (int i = 0; i < nums.length; i++) {
            int min = i ;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            if (i != min ){
                int term = nums[i];
                nums[i] = nums[min];
                nums[min] = term;
            }
        }
    }

    //插入排序的
    void sort3(){
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];  // key 是要插入的元素
            int j = i-1 ;
            for (;j>=0 && nums[j]>key;j--){
                nums[j+1]=nums[j];
            }
            nums[j+1] = key ;
        }
    }

    //归并排序
    void sort4(){
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid + 1, right);
            merge(nums, temp, left, mid, right);
        }
    }

    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = 0 ;
        while(i <= mid && j <= right){
            if (nums[i] < nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid ){
            temp[t++] = nums[i++];
        }

        while (j <= right){
            temp[t++] = nums[j++];
        }

        t = 0;
        while (left <=right){
            nums[left++] = temp[t++];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.sort5();
        System.out.println(Arrays.toString(nums));
    }

    // 快速排序
    void sort5(){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = quickMerge(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }
    private  int  quickMerge(int[] arr, int low, int high) {
        int pivot = arr[high]; // 设定基准值为子数组的最后一个元素
        int i = (low - 1); // 小于基准值的元素的索引

        for (int j = low; j <= high - 1; j++) {
            // 如果当前元素小于或等于基准值
            if (arr[j] <= pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和基准值 pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
