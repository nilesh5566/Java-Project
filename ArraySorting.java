import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of element : ");
        int n= sc.nextInt();;
        System.out.println("Eneter the element : ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("Choose teh sorting algorithm : ");
        System.out.println("1-> Bubble sort .");
        System.out.println("2-> Selection sort .");
        System.out.println("3-> Merge sort.");
        System.out.println("4-> Quick sort.");
        int choice= sc.nextInt();
        System.out.println("Sorting order 1-> Ascending Order 2-> Descending Order");
        boolean ascending=sc.nextInt()==1;
        switch (choice){
            case 1:
                BubbleSort(arr,ascending);
                break;
            case 2:
                SelectionSort(arr,ascending);
                break;
            case 3:
                MergeSort(arr,0,n-1,ascending);
                break;
            case 4:
                QuickSort(arr,0,n-1,ascending);
                break;
            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }
        System.out.println("Sorted Array is : "+ Arrays.toString(arr));
        sc.close();
    }

   private  static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
   }
    private static void QuickSort(int[] arr, int lo, int hi, boolean ascending) {
        if(lo<hi){
            int pi=partition(arr,lo,hi,ascending);
            QuickSort(arr,lo,pi-1,ascending);
            QuickSort(arr,pi+1,hi,ascending);
        }
    }

    private static int partition(int[] arr, int lo, int hi, boolean ascending) {
        int pivot=arr[hi];
        int i=lo-1;
        for(int j=lo;j<hi;j++){
            if((ascending && arr[j]<pivot)||(!ascending && arr[j]>pivot)){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,hi);
        return i+1;
    }

    private static void MergeSort(int[] arr, int lo, int hi, boolean ascending) {
        if(lo<hi){
            int mid=lo+(hi-lo)/2;
            MergeSort(arr,lo,mid,ascending);
            MergeSort(arr,mid+1,hi,ascending);
            merge(arr,lo,mid,hi,ascending);
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi, boolean ascending) {
        int n1=mid-lo+1;
        int n2=hi-mid;
        int[] lftArr=new int[n1];
        int[] rgtArr=new int[n2];
        System.arraycopy(arr, lo, lftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rgtArr, 0, n2);
        int i=0,j=0,k=lo;
        while (i<n1&&j<n2){
            if((ascending && lftArr[i]<=rgtArr[j])||(!ascending && lftArr[i]>rgtArr[j])){
                arr[k++]=lftArr[i++];
            }else{
                arr[k++]=rgtArr[j++];
            }

        }
        while (i < n1) arr[k++] = lftArr[i++];
        while (j < n2) arr[k++] = rgtArr[j++];

    }

    private static void SelectionSort(int[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if ((ascending && arr[j] < arr[idx]) || (!ascending && arr[j] > arr[idx])) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }
    }

    private static void BubbleSort(int[] arr, boolean ascending) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if((ascending&&arr[j]>arr[j+1])||(!ascending&&arr[j]<arr[j+1])){
                    swap(arr,j,j+1);
                }
            }
        }

    }
}
