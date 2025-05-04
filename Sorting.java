
import java.util.Arrays;

public class Sorting  {
   

    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { 
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }    

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);  
            mergeSort(arr, mid + 1, right); 
            merge(arr, left, mid, right);  
        }
    }
    
    public void merge(int[] arr, int left, int mid, int right) {
        
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];  
    
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
    
      
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
    
       
        while (j <= right) {
            temp[k++] = arr[j++];
        }
    
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

  


    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


public void countingSort(int[] arr) {
    if (arr.length == 0)
        return;

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max)
            max = arr[i];
    }

    int[] count = new int[max + 1];

    for (int i = 0; i < arr.length; i++) {
        count[arr[i]]++;
    }

    int index = 0;
    for (int i = 0; i < count.length; i++) {
        while (count[i] > 0) {
            arr[index++] = i;
            count[i]--;
        }
    }
}
public void reverseSort(int[] arr) {
    Arrays.sort(arr); 
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
}



    
    public static void main(String[] args) {
        
        Sorting sorting = new Sorting();
       
        
        int[] arr = {64, 25, 12, 22, 11};
        sorting.selectionSort(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        
   
        arr = new int[]{64, 25, 12, 22, 11};
        sorting.insertionSort(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));

     
        arr = new int[]{64, 25, 12, 22, 11};
        sorting.bubbleSort(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));

       
        arr = new int[]{64, 25, 12, 22, 11};
        sorting.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(arr));

        arr = new int[]{64, 25, 12, 22, 11};
        sorting.quickSort(arr, 0, arr.length - 1); 
        System.out.println("Quick Sort: " + Arrays.toString(arr));

        arr = new int[]{4, 2, 2, 8, 3, 3, 1};
sorting.countingSort(arr);
System.out.println("Counting Sort: " + Arrays.toString(arr));

arr = new int[]{64, 25, 12, 22, 11};
sorting.reverseSort(arr);
System.out.println("Reverse Sort: " + Arrays.toString(arr));


    }
}
   



