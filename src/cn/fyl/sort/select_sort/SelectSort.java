package cn.fyl.sort.select_sort;

import cn.fyl.sort.DataWrap;

/**
 * 选择排序法：直接选择排序、堆排序
 * 直接选择排序
 * Created by Fang on 2017/10/31.
 */
public class SelectSort {
    public static void selectSort(DataWrap[] data){
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++){
            //保留本趟最小值的索引
            int minIndex = i;
            //找到本趟最小值的索引
            for (int j = i + 1; j < arrayLength; j++){
                if (data[minIndex].compareTo(data[j]) > 0){
                    minIndex = j;
                }
            }

            if (minIndex != i){
                DataWrap temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    public static void main(String[] args){
        DataWrap[] data = {
                new DataWrap(7,""),
                new DataWrap(2,""),
                new DataWrap(4,""),
                new DataWrap(3,""),
                new DataWrap(2,"*"),
                new DataWrap(11,""),
        };
        System.out.println("排序之前:\n"+java.util.Arrays.toString(data));
        selectSort(data);
        System.out.println("排序之后:\n"+java.util.Arrays.toString(data));
    }

}

