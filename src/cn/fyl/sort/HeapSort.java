package cn.fyl.sort;

import java.util.Arrays;

/**
 * 堆排序
 * Created by Fang on 2017/11/15.
 */
public class HeapSort {
    public static void heapSort(DataWrap[] data){
        System.out.println("开始排序");
        int arrayLength = data.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++){
            //建堆，找出最大节点
            buildMaxHeap(data,arrayLength -1 - i);
            //交换堆顶和最后一个元素
            swap(data,0,arrayLength - 1 - i);
            System.out.println(Arrays.toString(data));
        }
    }

    //对data数组从0到lastIndex建大顶推
    public static void buildMaxHeap(DataWrap[] data, int lastIndex){
        //从lastIndex处的父节点开始
        for (int i = (lastIndex - 1)/2; i >= 0; i--){
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2+1 <= lastIndex){
                //biggerIndex保存较大的子节点
                int biggerIndex = k * 2 + 1;    //左子节点
                //如果k节点的右子节点存在
                if (biggerIndex < lastIndex){
                    //如果左子节点小于右子节点
                    if (data[biggerIndex].compareTo(data[biggerIndex+1]) < 0){
                        //保存较大的子节点
                        biggerIndex++;
                    }
                }
                //如果k节点小于较大的子节点的值
                if (data[k].compareTo(data[biggerIndex]) < 0){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋给看k，开始下次循环
                    k = biggerIndex;
                }
                else{
                    break;
                }
            }
        }

    }


    public static void swap(DataWrap[] data, int i ,int j){
        DataWrap temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        DataWrap[] data = {new DataWrap(1,""),
                         new DataWrap(5,""),
                         new DataWrap(4,""),
                         new DataWrap(2,""),
                         new DataWrap(3,"")};
        System.out.println("排序之前：\n"+java.util.Arrays.toString(data));
        heapSort(data);
        System.out.println("排序之后：\n"+java.util.Arrays.toString(data));
    }
}
