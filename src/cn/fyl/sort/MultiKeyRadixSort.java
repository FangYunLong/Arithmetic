package cn.fyl.sort;

import java.util.Arrays;

/**
 * 基数排序:以桶式排序为基础来实现多关键字的基数排序
 * Created by Fang on 2018/1/31.
 */
public class MultiKeyRadixSort {
    /**
     * @param data 待排序数组
     * @param radix 指定关键字拆分的进制，如radix=10，表明按10进制拆分
     * @param d 指定关键字拆分成几个关键字
     */
    public static void radixSort(int[] data,int radix,int d){
        System.out.println("开始排序：");
        int arrayLength = data.length;
        int[] tmp = new int[arrayLength];
        //buckets数组是桶式排序
        int[] buckets = new int[radix];
        //依次从最高位的子关键字对待排序数据进行排序
        //rate用于保存当前计算的位
        for (int i = 0 , rate = 1; i < d; i++)
        {
            //重置count数组，开始记录统计第二个关键字
            Arrays.fill(buckets,0);
            System.arraycopy(data,0,tmp,0,arrayLength);
            //计算每个待排序数据的子关键字
            for (int j = 0; j < arrayLength; j++)
            {
                //计算数据指定位上的子关键字
                int subKey = (tmp[j]/rate)%radix;
                buckets[subKey]++;
            }
            for (int j = 1; j < radix; j++)
            {
                buckets[j] = buckets[j] + buckets[j-1];
            }
            //按子关键字对指定数据进行排序
            for (int m = arrayLength - 1;m >= 0;m--)
            {
                int subKey = (tmp[m]/rate)%radix;
                data[--buckets[subKey]] = tmp[m];
            }
            System.out.println("对"+rate+"位上子关键字排序："+Arrays.toString(data));
            rate *= radix;
        }
    }

    public static void main(String[] args) {
        int[] data = {110,11,1100,1};
        System.out.println("排序之前：\n"+Arrays.toString(data));
        radixSort(data,10,4);
        System.out.println("排序之后：\n"+Arrays.toString(data));
    }
}
