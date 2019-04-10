package sort;

/**
 * Created by vera on 19-3-18.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] numbers = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }
    public static void sort(int[] numbers){
        int[] temp = new int[numbers.length];//在排序前先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(numbers, 0, numbers.length-1, temp);
    }
    private static void sort(int[] numbers, int left, int right, int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(numbers, left, mid, temp); //左边归并
            sort(numbers, mid+1, right, temp); //右边归并
            merge(numbers, left, mid, right, temp);
        }
    }
    private static void merge(int[] numbers, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid && j<=right){
            if(numbers[i]<=numbers[j]){
                temp[t] = numbers[i];
                t++;i++;
            }else{
                temp[t] = numbers[j];
                t++;j++;
            }
        }
        while(i<=mid){
            temp[t]=numbers[i];
            t++;i++;
        }
        while(j<=right){
            temp[t]=numbers[j];
            t++;j++;
        }
        for(t=0;left<=right;t++,left++){//将temp中的元素全部copy到原数组中
            numbers[left]=temp[t];
        }
    }
}
