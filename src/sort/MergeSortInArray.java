package sort;

import java.util.Arrays;

/**
 * @author bertking
 * @Package sort
 * @Description: ReviewLeeCode
 * @date 2021/4/1-8:11 下午
 * @problem
 * @level
 *
 * 递归方式
 */
public class MergeSortInArray {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        mergeSort(arr,0,arr.length-1);

        System.out.println("排序后的："+ Arrays.toString(arr));
    }

    /**
     * 归并算法的核心是: 分而治之
     * 即：先分，再合
     */

    private static void  mergeSort(int[] arr, int left,int right){
            if(arr == null || left <= right){
                return;
            }

            int mid = left + (right-left)/2;

            mergeSort(arr,left,mid); // 左边归并排序，使得左子序列有序

            mergeSort(arr,mid+1,right); //右边归并排序，使得右子序列有序

            // 将两个有序子数组进行合并操作
            merge(arr,mid,left,right);

    }

    private static void merge(int[] arr, int mid, int left, int right){
        // 临时数组
        int[] tmp = new int[arr.length];

        int start = left; // 左序列
        int start2 = mid+1; // 右序列

        // 临时数组的指针
        int i = 0;

        while(start <= mid && start2 <= right){
            if(arr[start] <= arr[start2]){
                tmp[i++] = arr[start++];
            }else {
                tmp[i++] = arr[start2++];
            }
        }

        // 将左边的剩余元素填充进tmp中
        while(start <= mid){
            tmp[i++] = arr[start++];
        }

        while(start2 <= right){
            tmp[i++] = arr[start2++];
        }

        // 重置i
        i = 0;
        // 将临时数组tmp中的元素全部拷贝至原数组arr中
        while (left <= right){
            arr[left++] = tmp[i++];
        }
    }


}
