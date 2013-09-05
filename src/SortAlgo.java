import java.awt.List;


public class SortAlgo {
	public static void sort(int[] array){
		qsort(array);
	}
	public static void qsort(int[] array){
		qsort( array,0,array.length-1);
	}
	
	private static void qsort(int[] array,int first, int last){
		if(first < last){
			int pivotIndex = partition(array, first, last);
			qsort(array,first,pivotIndex-1);
			qsort(array,pivotIndex+1,last);
		}
	}
	
	private static int partition(int[] array, int first, int last){
		int low = first + 1;
		int high = last;
		int index = first;
		
		while(high > low){
			while(low <= high && array[low] < array[index] ){
				low++;
			}
			while(high >= low && array[high] > array[index]){
				high--;
			}
			if(high > low){
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		if(high>first && array[high] >= array[index]){
			high--;
		}
		if(array[index] > array[high]){
			int temp = array[index];
			array[index] = array[high];
			array[high] = temp;
			return high;
		}
		else{
			return first;
		}
	}
	
	/** 以下方法为merge sort，时间复杂度O(nlog n) */
	public static void mergeSort(int[] array){
		if (array.length > 1){
			int[] firstHalf = new int[array.length/2];
			System.arraycopy(array, 0, firstHalf, 0, array.length/2);
			mergeSort(firstHalf);
			
			int[] secondHalf = new int[array.length-array.length/2];
			System.arraycopy(array, array.length/2, secondHalf, 0, array.length-array.length/2);
			mergeSort(secondHalf);
			
			int[] temp = merge (firstHalf,secondHalf);
			System.arraycopy(temp, 0, array, 0, temp.length);
		}
	}
	public static int[] merge(int[] array1, int[] array2){
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		int[] result = new int[array1.length+array2.length];

		while (current1 < array1.length && current2 < array2.length){
			if (array1[current1] <= array2[current2]){
				result[current3++] = array1[current1++];
			}
			else{
				result[current3++] = array2[current2++];
			}
		}
		if(current1 == array1.length){
			while(current2 < array2.length)
			{
				result[current3++] = array2[current2++];
			}
		}
		if(current2 == array2.length){
			while(current1 < array1.length)
			{
				result[current3++] = array1[current1++];
			}
		}
		return result;
	}

	//  printArray method is written for test	
	public static void printArray(int[] a){
		System.out.println("test:");
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String[] args){
		int[] a = {1,3,4,2,5,7,8,3,6};
		SortAlgo.sort(a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
}
