package cn.fyl.sort.insert_sort;

import cn.fyl.sort.DataWrap;

import java.util.Arrays;

/**
 * Shell排序
 * Created by Fang on 2018/1/20.
 */
public class ShellSort {
    public static void shellSort(DataWrap[] data){
        System.out.print("开始排序：\n");
        int arrayLength = data.length;
        //h变量保存可变增量
        int h = 1;
        while (h <= arrayLength/3){
            h = h*3+1;
        }
        while (h > 0){
            System.out.println("==h的值："+h+"==");
            for (int i = h; i < arrayLength; i++){
                //当整体后移时，保证data[i]的值不会丢失
                DataWrap tmp = data[i];
                if (data[i].compareTo(data[i - h]) < 0){
                    int j = i - h;
                    //整体后移h格
                    for (; j >= 0 && data[j].compareTo(tmp) > 0; j-=h){
                        data[j+h] = data[j];
                    }
                    //将tmp值插入合适的位置
                    data[j+h] =tmp;
                }
                System.out.println(Arrays.toString(data));
            }
            h = (h-1)/3;
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(9,""),
                new DataWrap(1,""),
                new DataWrap(2,""),
                new DataWrap(5,""),
                new DataWrap(7,""),
                new DataWrap(4,""),
                new DataWrap(8,""),
                new DataWrap(6,""),
                new DataWrap(3,""),
                new DataWrap(5,""),
        };
        System.out.println("排序之前：\n"+Arrays.toString(data));
        shellSort(data);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
