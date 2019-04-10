package sort;

/**
 * Created by vera on 19-3-18.
 */
public class InsertSort {
    public static void main(String[] args){
        int[] numbers = {4, 3, 2, 1};
//        sort1(numbers);
        sort2(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }

    public static void sort1(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            for(int j=i; j>0; j--){
                if(numbers[j]<numbers[j-1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void sort2(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            int j=i;
            while(j>0 && numbers[j]<numbers[j-1]){//每次将最小的放在最前，从后向前排序
                int temp = numbers[j];
                numbers[j] = numbers[j-1];
                numbers[j-1] = temp;
                j--;
            }
        }
    }
}
