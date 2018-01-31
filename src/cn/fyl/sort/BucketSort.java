package cn.fyl.sort;

import java.util.Arrays;

/**
 * 桶排序
 * Created by Fang on 2018/1/29.
 */
public class BucketSort {
    public static void bucketSort(DataWrap[] data, int min, int size){
        System.out.println("开始排序：");
        int arrayLength = data.length;
        DataWrap[] tmp = new DataWrap[arrayLength];
        //buckets数组记录待排序元素的信息
        int[] buckets = new int[size-min];
        //计算每个元素在序列出现的次数
        for (int i = 0; i < arrayLength; i++)
        {
            //buckets数组记录了DataWrap出现的次数
            buckets[data[i].data - min]++;
        }
        System.out.println(Arrays.toString(buckets));
        //计算“落入”各桶内的元素在有序序列的位置，“落入”当前bucket中元素的总数
        for (int i = 1; i < size - min; i++)
        {
            //新的bucket值=当前bucket值+前一个bucket值
            buckets[i] = buckets[i] + buckets[i-1];
        }
        //buckets数组元素的值代表了“落入”当前桶的元素在有序序列中的位置
        System.out.println(Arrays.toString(buckets));
        System.arraycopy(data,0,tmp,0,arrayLength);
        //根据buckets数组中的信息将待排序序列的各元素放入相应的位置
        for (int j = arrayLength - 1; j >= 0; j--)
        {
            data[--buckets[tmp[j].data - min]] = tmp[j];
        }
    }

    public static void main(String[] args) {
        DataWrap[] data = {
                new DataWrap(1,""),
                new DataWrap(4,""),
                new DataWrap(2,""),
                new DataWrap(3,""),
                new DataWrap(-1,""),
        };
        System.out.println("排序之前：\n"+Arrays.toString(data));
        bucketSort(data,-1,5);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
