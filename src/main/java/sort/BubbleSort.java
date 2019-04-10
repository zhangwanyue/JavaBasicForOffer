package sort;

/**
 * Created by vera on 19-3-18.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] numbers = {4, 3, 2, 1};
        sort1(numbers);
//        sort2(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }

    public static void sort1(int[] numbers){
        for(int i=0; i<numbers.length-1; i++){
            boolean flag = true;
            for(int j=0; j<numbers.length-1-i; j++){ //每次将最大的元素放到最后（从前向后）
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public static void sort2(int[] numbers){
        for(int i=0; i<numbers.length-1; i++){
            boolean flag = true;
            for(int j=numbers.length-1; j>i; j--){ //每次将最小的元素放到最前（从后向前）
                if(numbers[j] < numbers[j-1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
