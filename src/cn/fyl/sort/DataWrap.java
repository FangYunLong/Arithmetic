package cn.fyl.sort;

/**
 * 数据包装类
 * Created by Fang on 2017/11/15.
 */
class DataWrap implements Comparable<DataWrap>{
    int data;
    String flag;

    public DataWrap(int data,String flag){
        this.data = data;
        this.flag = flag;
    }

    public String toString(){
        return data + flag;
    }

    @Override
    public int compareTo(DataWrap o) {
        return this.data > o.data ? 1 : (this.data == o.data ? 0 : -1);
    }
}
