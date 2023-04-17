import java.util.*;
import java.lang.*;

class Sort<T extends Comparable<T>>{
    void sort(T arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j].compareTo(arr[i])>0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("the sorted generic array is : " + Arrays.toString(arr));
    }
}

public class GenericsSorting
{
    public static void main(String args[]){
        Sort s = new Sort();
        Integer arr[] = { 76, 34 , 82, 2, 6, 38 , 72 , 97 , 34};
        String arr1[] = { "dad" , "mad" , "lad", "sad" , "bad" , "had" , "pad"};
        Character arr2[] = {'c','b','e','a','d'};
        s.sort(arr);
        s.sort(arr1);
        s.sort(arr2);

    }
}
