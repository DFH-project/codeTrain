package dfh.train.LeetCode;

import java.util.Arrays;

public class sort {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        for(int i=m;i<len;i++){
            nums1[i]=nums2[len-(i+1)];
        }
//        冒泡排序
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j <len ; j++) {
//                if (nums1[i] > nums1[j]){
//                    int temp =nums1[i];
//                    nums1[i] = nums1[j];
//                    nums1[j] = temp;
//                }
//            }
//        }
//        直接调用
//        Arrays.sort(nums1);
        // 使用双向指针
        int p1=0; int p2 =0;
        int[] sort=new int[len];
        while (p1<m || p2 <m){
            if (p1 ==m){
                sort[p1+p2]=nums2[p2];
                p2++;
            }else if (p2 ==m){
                sort[p1+p2]=nums1[p1];
                p1++;
            }else if (nums1[p1]<nums2[p2]){
                sort[p1+p2]=nums1[p1];
                p1++;
            }else {
                sort[p1+p2]=nums2[p2];
            }
        }
    }
}
