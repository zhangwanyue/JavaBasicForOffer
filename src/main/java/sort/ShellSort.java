package sort;

/**
 * Created by vera on 19-3-18.
 */
public class ShellSort {
    //希尔增量选择为gap = length/2
    public static void main(String[] agrs){
        int[] numbers = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }

    public static void sort(int[] numbers){
        for(int gap=numbers.length/2; gap>0; gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序
            for(int i=gap; i<numbers.length; i++){
                for(int j=i; j-gap>=0; j-=gap){
                    if(numbers[j]<numbers[j-gap]){
                        int temp = numbers[j];
                        numbers[j] = numbers[j-gap];
                        numbers[j-gap] = temp;
                    }else{
                        break;
                    }
                }
            }
        }
    }
}
