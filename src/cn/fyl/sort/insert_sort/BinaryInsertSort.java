package cn.fyl.sort.insert_sort;

import cn.fyl.sort.DataWrap;

import java.util.Arrays;

/**
 * 折半插入排序：
 * Created by Fang on 2018/1/20.
 */
public class BinaryInsertSort {
    public static void binaryInsertSort(DataWrap[] data){
        System.out.print("开始排序：\n");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++){
            //当整体后移时，保证data[i]的值不会丢失
            DataWrap tmp = data[i];
            int low = 0;
            int high = i - 1;
            while (low <= high){
                //找出high、low中间索引
                int mid = (high+low)/2;
                //如果tmp值大于中间元素的值
                if (tmp.compareTo(data[mid]) > 0){
                    //限制在索引大于mid的那一半中搜索
                    low = mid + 1;
                }else{
                    //限制在索引小于mid的那一半中搜索
                    high = mid - 1;
                }
            }
            //将low到i处的所有元素向后整体移一位
            for (int j = i; j > low; j--){
                data[j] = data[j-1];
            }
            data[low] = tmp;
            System.out.println(Arrays.toString(data));
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
        System.out.println("排序之前：\n"+Arrays.toString(data));
        binaryInsertSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
