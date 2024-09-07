final public class sortingAlgorithms{
    public interface SortCallback{
        void onIteration(int[] array);
    }
    public static int[] bubbleSort(int a[], boolean asc, SortCallback callback){//worst case complexity : O(n^2)
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0; j < a.length - i - 1; j++){
                paintCompOverride.currElemIndex = j;
                paintCompOverride.compareElemIndex = j + 1;
                if(asc){
                    if(a[j] > a[j + 1]){
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        paintCompOverride.compCount++;
                        paintCompOverride.swapCount++;
                        
                    }
                }
                else{
                    if(a[j] < a[j + 1]){
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        paintCompOverride.compCount++;
                        paintCompOverride.swapCount++;
                    }
                }
                callback.onIteration(a);
            }
        }
        return a;
    }
    public static int[] selectionSort(int a[], boolean asc, SortCallback callback){//worst case complexity : O(n^2)
        for(int i = 0; i < a.length - 1; i++){
            int chosen = i;
            for(int j = i + 1; j < a.length ; j++){
                if(asc){
                    if(a[j] < a[chosen]){
                        chosen = j;
                        paintCompOverride.compCount++;
                    }
                }
                else{
                    if(a[j] > a[chosen]){
                        chosen = j;
                        paintCompOverride.compCount++;
                    }
                }
            }
            if(a[i] != a[chosen]){
                int temp = a[chosen];
                a[chosen] = a[i];
                a[i] = temp;
                paintCompOverride.swapCount++;
            }
            paintCompOverride.currElemIndex = chosen;
            paintCompOverride.compareElemIndex = i;
            callback.onIteration(a);
        }
        return a;
    }
    public static int[] insertionSort(int a[], boolean asc, SortCallback callback){//best out of the three simple sorting algos bcos of better best case time comp
        //worst case time complexity : O(n^2)
        for(int i = 1; i < a.length; i++){
            int chosen = a[i];
            int j = i - 1;

            if(asc){
                while(j >= 0 && a[j] > chosen){
                    paintCompOverride.currElemIndex = i;
                    paintCompOverride.compareElemIndex = j;
                    a[j + 1] = a[j];
                    j -= 1;
                    callback.onIteration(a);
                    paintCompOverride.shiftCount++;
                }
            }
            else{
                while(j >= 0 && a[j] < chosen){
                    paintCompOverride.currElemIndex = a[i];
                    paintCompOverride.compareElemIndex = a[j];
                    a[j + 1] = a[j];
                    j -= 1;
                    callback.onIteration(a);
                    paintCompOverride.shiftCount++;
                }
            }
            a[j + 1] = chosen;
            paintCompOverride.shiftCount++;
            callback.onIteration(a);
        }
        return a;
    }
    private static int partition(int[] arr, int low, int high, boolean asc, SortCallback callback){//partition alg for quick sort
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(asc){
                if(arr[j] < pivot){
                    paintCompOverride.currElemIndex = high;
                    paintCompOverride.compareElemIndex = j;
                    i += 1;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    paintCompOverride.swapCount++;
                    paintCompOverride.compCount++;
                    callback.onIteration(arr);
                }
            }
            else{
                if(arr[j] > pivot){
                    i += 1;
                    paintCompOverride.currElemIndex = high;
                    paintCompOverride.compareElemIndex = j;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    paintCompOverride.swapCount++;
                    paintCompOverride.compCount++;
                    callback.onIteration(arr);
                }
            }
        }
        int temp = arr[high];
        arr[high] =  arr[i + 1];
        arr[i + 1] =  temp;
        paintCompOverride.swapCount++;
        callback.onIteration(arr);

        return i + 1;
    }
    public static int[] quickSort(int arr[], int low, int high, boolean asc, SortCallback callback){// worst case time complexity : o(n^2), avg theta(nlogn)
        if(low < high){
            int piv = partition(arr, low, high, asc, callback);
            quickSort(arr, low, piv - 1, asc, callback);
            quickSort(arr, piv + 1, high, asc, callback);
        }
        callback.onIteration(arr);
        return arr;
    }
/*    
    private static void traverse(int a[]){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
*/
    private static int[] merge(int a[], int low, int mid, int high, boolean asc, SortCallback callback){//merge alg for mergesort
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int l[] = new int[n1];
        int h[] = new int[n2];

        paintCompOverride.currElemIndex = low;
        paintCompOverride.compareElemIndex = high;

        for(int i = 0; i < n1; i++){
            l[i] = a[low + i];
        }
        for(int i = 0; i < n2; i++){
            h[i] = a[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = low;

        while(i < n1 && j < n2){
            if(asc){
                if(l[i] < h[j]){
                    paintCompOverride.compCount++;
                    a[k] = l[i];
                    i++;
                    k++;
                    callback.onIteration(a);
                }
                else{
                    paintCompOverride.compCount++;
                    a[k] = h[j];
                    j++;
                    k++;
                    callback.onIteration(a);
                }
            }
            else{
                if(l[i] > h[j]){
                    paintCompOverride.compCount++;
                    a[k] = l[i];
                    i++;
                    k++;
                    callback.onIteration(a);
                }
                else{
                    paintCompOverride.compCount++;
                    a[k] = h[j];
                    j++;
                    k++;
                    callback.onIteration(a);
                }
            }
        }

        while(i < n1){
            a[k] = l[i];
            i++;
            k++;
            callback.onIteration(a);
        }

        while(j < n2){
            a[k] = h[j];
            j++;
            k++;
            callback.onIteration(a);
        }

        return a;
    }
    public static int[] mergeSort(int a[], int low, int high, boolean asc, SortCallback callback){//worst case complexity O(nlogn)
        if(low < high){
            int mid = (low + high - 1)/2;

            mergeSort(a, low, mid, asc, callback);
            mergeSort(a, mid + 1, high, asc, callback);

            a = merge(a, low, mid, high, asc, callback);
        }
        return a;
    }
    public static int[] heapSort(int arr[], SortCallback callback) {
      int n = arr.length;
      for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i, callback);
      }
      for (int i = n - 1; i >= 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(arr, i, 0, callback);
      }
      callback.onIteration(arr);
      return arr;
    }
  
    private static void heapify(int arr[], int n, int i, SortCallback callback) {

      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
  
      if (l < n && arr[l] > arr[largest]){
        paintCompOverride.compCount++;
        largest = l;
        paintCompOverride.compareElemIndex = largest;
      }
  
      if (r < n && arr[r] > arr[largest]){
        largest = r;
        paintCompOverride.compareElemIndex = largest;
        paintCompOverride.compCount++;
      }

      if (largest != i) {
        paintCompOverride.currElemIndex = i;
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;
        paintCompOverride.swapCount++;
        callback.onIteration(arr);
        heapify(arr, n, largest, callback);
      }
    }
/*
    private static void test(){
        int arr[] = {2, 7, 3, 8, 4, 9, 5, 1, 2000, 32, 21, 2023, -1};
        boolean ascending  = false;
        SortCallback callback;
        arr = mergeSort(arr, 0, arr.length - 1, ascending, callback);
        traverse(arr);
    }
*/
}