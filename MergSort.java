import java.util.ArrayList;
import java.util.List;

public class MergSort {
    private static void merge(List<Integer>list,int low,int mid,int high){
        List<Integer>leftList = new ArrayList<>(list.subList(low, mid + 1));
        List<Integer>rightList = new ArrayList<>(list.subList(mid+1, high + 1));

        int i=0,j=0,k=low;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        while(i<leftList.size()){
                list.set(k, leftList.get(i));
                i++;
                k++;
            }
        while(j<rightList.size()){
                list.set(k, rightList.get(j));
                j++;
                k++;
            }
    }

    private static void mergeSort(List<Integer>list,int low,int high){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(list,low,mid);
            mergeSort(list,mid+1,high);
            merge(list,low,mid,high);
        }
         

    }
    public static void main(String[] args) {
        List<Integer>arr = new ArrayList<>();
        for(int i=0;i<5000;i++){
            int x = (int) Math.ceil(Math.random()*1000);
            arr.add(x);
        }
        for(int i:arr) System.out.print(i+" ");
        mergeSort(arr,0,arr.size()-1);
        for(int i:arr) System.out.print(i+" ");
    }
}
