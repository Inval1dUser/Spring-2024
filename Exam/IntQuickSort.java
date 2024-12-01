/**
 * Practice with many sorting problems.
 * 
 * @author Md Haque
 * @version 03/20/2021
 */
public class IntQuickSort {

    /* This function takes last element as pivot and find the partition point */
    private static int partition(int [] arr, int low, int high)
    {
      int pi = low;
      int pivot = arr[low];  
      do
      
      {
         while ( low <= high && arr[low] <= pivot )
            low++;
         while ( arr[high] > pivot )
            high--;
         if ( low < high )
            swap(arr, low, high);
      } while ( low < high );
      swap(arr, pi, high);
      pi = high;
      return(pi); 
    }

    public static void quickSort(int [] arr, int low, int high)
    {
        if (high-low>=1)
        {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1); //before p
            quickSort(arr, p + 1, high); //after p
        }

        return;
    }

    private static void swap(int [] list, int x, int y) {
        // swap list[x] and list[y]
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }

    public static void printArray(int [] A) 
    {
        for (int i = 0; i < A.length; i++)
            System.out.printf("%d ", A[i]);
        
        System.out.println();
    }

    // Returns the k-th smallest element of the array
    public static int quickSelect(int [] A, int low, int high, int k)
    {
        // call the partition function and store it in a variable, suppose pivotIndex - done
        int pivotIndex = partition(A, low, high);

        // IF the pivotIndex equals to k-1, that means pivotIndex holds the kth smalles value - done
        if (pivotIndex == (k - 1)) {
            return A[pivotIndex];
        }
        // In that case simply return the array element in that index - done
        // for example pivotIndex is 3 and you are looking the 4th smallest value (k=4)
        // then A[3] is basically the 4th smallest value (since array index starts from 0)
        if (pivotIndex > k - 1) {
            return quickSelect(A, low, pivotIndex - 1, k); //pivotIndex - 1 is the left half of the list
        } else { //[A, B, C, D = (pivotIndex - 1), E, F = (pivotIndex), G, H, I, J]
            return quickSelect(A, pivotIndex + 1, high, k); //pivotIndex + 1 is the right half of the list
        }

        // if k is less than the pivot index that means the kth smallest value is located
        // on the left half of the pivotIndex. So call the quickSelect function on left half - done 
        

        // else call the function on right half
      
    }

    public static void main(String[] args) {
        int []quickArr = {2, 4, 9, 10, 2, 6, 7, 1, 23};
        int k = 1;
        System.out.printf("k'th smallest element is %d", quickSelect(quickArr, 0, quickArr.length - 1, k));
        System.out.println();
        System.out.println("Quick Sort: " );
        quickSort(quickArr, 0, quickArr.length - 1);
        printArray(quickArr);
    }
}
