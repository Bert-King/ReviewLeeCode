package sort;

/**
 * @author bertking
 * @Package sort
 * @Description: ReviewLeeCode
 * @date 2021/4/1-8:11 下午
 * @problem
 * @level
 */
public class MergeSortInArray {



    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};

        // 临时数组
        int[] tmp = new int[array.length];

    }

    /**
     * 归并算法的核心是: 分而治之
     * 即：先分，再合
     */

    private static void  sort(int[] arr, int[] tmp, int left,int right){
        if(left < right){
            int mid = left + (right-left)/2;

            sort(arr,tmp,left,mid); // 左边归并排序，使得左子序列有序

            sort(arr,tmp,mid+1,right); //右边归并排序，使得右子序列有序


        }
    }


    private static void merge(int[] arr, int[] tmp, int left, int mid, int right){

    }

}
