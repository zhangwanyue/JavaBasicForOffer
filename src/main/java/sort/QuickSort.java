package sort;

/**
 * Created by vera on 19-3-18.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] numbers = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        qsort(numbers, 0, numbers.length-1);
        for(int i : numbers){
            System.out.println(i);
        }
    }

    public static void qsort(int[] numbers, int start, int end){
        if(start<end){
            int pivot = partition(numbers, start, end);
            qsort(numbers, start, pivot-1);
            qsort(numbers, pivot+1, end);
        }

    }

    public static int partition(int[] numbers, int start, int end){
        int pivot = numbers[start];
        while(start<end){
            while(start<end && numbers[end]>=pivot) {
                --end;
            }
            numbers[start] = numbers[end];
            while(start<end && numbers[start]<=pivot){
                ++start;
            }
            numbers[end] = numbers[start];
        }
        numbers[start] = pivot;
        return start;
    }
}
