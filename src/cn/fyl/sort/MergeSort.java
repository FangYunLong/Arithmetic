package cn.fyl.sort;

import java.util.Arrays;

/**
 *归并排序
 * Created by Fang on 2018/1/20.
 */
public class MergeSort {

    public static void mergeSort(DataWrap[] data){
        sort(data,0,data.length-1);
    }

    /**
     * 将索引从left到right范围的数组元素进行归并排序
     * @param data 待排序的数组
     * @param left 待排序的数组的第一个元素索引
     * @param right 待排序的数组的最后一个元素索引
     */
    private static void sort(DataWrap[] data, int left, int right){
        if (left < right){
            //中间索引
            int mid = (right+left)/2;
            //对左边数组进行递归
            sort(data,left,mid);
            //对右边数组进行递归
            sort(data,mid+1,right);
            //合并
            merge(data,left,mid,right);
        }
    }

    /**
     * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
     * @param data 待归并的数组
     * @param left 左数组的第一个元素的索引
     * @param mid 左数组的最后一个元素的索引，mid+1是右数组第一个元素的索引
     * @param right 右数组的最后一个元素的索引
     */
    private static void merge(DataWrap[] data,int left, int mid, int right){
        DataWrap[] tmpArr = new DataWrap[data.length];
        //mid+1是右数组第一个元素的索引
        int center = mid+1;
        //third记录中间数组的索引
        int third = left;
        //左数组的第一个元素的索引
        int tmp = left;
        while (left <= mid && center <= right)
        {
            //从两个数组中取出小的放入中间数组
            if (data[left].compareTo(data[center]) <= 0)
            {
                tmpArr[third++] = data[left++];
            }
            else
            {
                tmpArr[third++] = data[center++];
            }
        }
        //剩余部分依次放入中间数组
        while (center <= right)
        {
             tmpArr[third++] = data[center++];
    }
        while (left <= mid)
        {
            tmpArr[third++] = data[left++];
        }
        //将中间数组中的内容（原left--right范围的内容）复制到原数组
        while (tmp <= right)
        {
            data[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(3,""),
                new DataWrap(2,""),
                new DataWrap(5,""),
                new DataWrap(4,""),
                new DataWrap(1,""),
                new DataWrap(8,""),
                new DataWrap(6,""),
                new DataWrap(7,""),
        };
        System.out.println("排序之前：\n"+ Arrays.toString(data));
        mergeSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
