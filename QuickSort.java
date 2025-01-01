import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    private static int partition(List<Integer>arr,int low,int high){
        int i=low,j=high;
        int pivot = arr.get(low);
        while(i<j){
            while(arr.get(i)<=pivot && i<=high-1) i++;
            while(arr.get(j)>pivot && j>=low+1) j--;
            if(i<j){
                int temp=arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);

            }
        }
            int temp = arr.get(low);
            arr.set(low,arr.get(j));
            arr.set(j,temp);
        return j;
    }
    private static void qs(List<Integer>arr,int low,int high){
        if(low<high){
           int partitionIndex = partition(arr,low,high);
           qs(arr,low,partitionIndex-1);
           qs(arr,partitionIndex+1,high);
        }
    }
    public static void main(String[] args) {
        List<Integer>arr = new ArrayList<>();
        for(int i=0;i<5000;i++){
            int x = (int) Math.ceil(Math.random()*1000);
            arr.add(x);
        }
        for(int i:arr) System.out.print(i+" ");
        qs(arr,0,arr.size()-1);
        System.out.println();
        for(int i:arr) System.out.print(i+" ");
    }
}