package sort;


/**
 * Created by vera on 19-3-18.
 */
public class SelectSort {
    public static void main(String[] args){
        int[] numbers = {4, 3, 2, 1};
        sort(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }
    public static void sort(int[] numbers){
        for(int i=0; i<numbers.length-1; i++){
            int min = i;
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[j]<numbers[min]){
                    min = j;
                }
            }
            if(min!=i){
                int temp = numbers[i];
                numbers[i] = numbers[min];
                numbers[min] = temp;
            }
        }
    }
}
