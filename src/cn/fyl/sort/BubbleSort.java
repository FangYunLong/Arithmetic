package cn.fyl.sort;

import java.util.Arrays;

/**
 * 交换排序：冒泡排序、快速交换排序
 * 冒泡排序
 * Created by Fang on 2018/1/18.
 */
public class BubbleSort {

    public static void bubbleSort(DataWrap[] data){
        System.out.println("开始排序：");
        for (int i = 0; i < data.length - 1; i++){
            boolean flag = false;
            for (int j = 0; j < data.length - 1 - i; j++){
                //如果j索引处的元素大于j+1索引处的元素
                if (data[j].compareTo(data[j+1]) > 0){
                    //交换它们
                    DataWrap tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(data));
            //如果某趟没有发生交换，则表明已处于有序状态
            if (!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(3,""),
                new DataWrap(2,""),
                new DataWrap(1,""),
                new DataWrap(4,""),
                new DataWrap(5,""),
        };

        System.out.println("排序之前：\n"+Arrays.toString(data));
        bubbleSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
