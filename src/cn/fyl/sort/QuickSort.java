package cn.fyl.sort;

import java.util.Arrays;

/**
 * 快速排序
 * Created by Fang on 2018/1/18.
 */
public class QuickSort {

    public static void swap(DataWrap[] data,int i,int j){
        DataWrap tmp;
        tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        System.out.println("开始排序："+Arrays.toString(data));
    }

    //对data数组中从start--end索引范围的子序列进行处理
    //对所有满足小于分界值的放在左边，所有大于分界值的放在右边
    private static void subSort(DataWrap[] data,int start,int end){
        if (start < end){
            //将第一个元素作为分界值
            DataWrap base = data[start];
            //从左边开始搜索，搜索大于分界值的索引
            int left = start;
            //从右边开始搜索，搜索小于分界值的索引
            int right = end + 1;    //先自减

            while (true){
                //从左到右找到大于分界值元素的索引，或left已到end处
                while(left < end && data[++left].compareTo(base) <= 0);
                //从右到左找到小于分界值元素的索引，或right已到start
                while (right > start && data[--right].compareTo(base) >= 0);
                //两者还未相遇，交换它们
                if (left < right){
                    swap(data,left,right);
                }
                else {
                    break;
                }
            }
            //将分界值归位
            swap(data,start,right);
            //递归左边
            subSort(data,start,right - 1);
            //递归右边
            subSort(data,right +1 ,end);

        }
    }

    public static void quickSort(DataWrap[] data){
        subSort(data,0,data.length - 1);
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(3,""),
                new DataWrap(4,""),
                new DataWrap(2,""),
                new DataWrap(5,""),
                new DataWrap(1,""),
        };
        System.out.println("排序之前："+Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后："+Arrays.toString(data));
    }
}
