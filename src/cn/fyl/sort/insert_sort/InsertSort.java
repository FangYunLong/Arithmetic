package cn.fyl.sort.insert_sort;

import cn.fyl.sort.DataWrap;

import java.util.Arrays;

/**
 * 插入排序：直接插入排序、shell排序和折半插入排序等
 * 直接插入排序
 * Created by Fang on 2018/1/20.
 */
public class InsertSort {
    public static void insterSort(DataWrap[] data){
        System.out.print("开始排序：\n");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++){
            //当整体后移时，保证data[i]的值不会丢失
            DataWrap tmp = data[i];
            //i索引处的值已经比前面所有值都大，表明已经有序，无需插入
            //i-1索引之前的数据已经有序，i-1索引处元素的值就是最大值
            if (data[i].compareTo(data[i-1]) < 0){
                int j = i -1;
                //整体后移一格
                for (; j >= 0 && data[j].compareTo(tmp) > 0; j--){
                    data[j+1] = data[j];
                }
                //将tmp值插入合适的位置
                data[j+1] = tmp;
            }
            System.out.println(Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(3,""),
                new DataWrap(2,""),
                new DataWrap(5,""),
                new DataWrap(1,""),
                new DataWrap(4,""),
        };
        System.out.println("排序之前：\n"+Arrays.toString(data));
        insterSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
