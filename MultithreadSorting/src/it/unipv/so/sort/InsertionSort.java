package it.unipv.so.sort;
import java.util.Map;

public class InsertionSort extends Sort{
		
		// costruttore
	   public InsertionSort(int[] arr, Map<String, Long> timeMap) {
		   super(arr, timeMap);
	}

	public void insertionSort(int[] arr){  
		        int n = arr.length;  
		        for (int j = 1; j < n; j++) {  
		            int key = arr[j];  
		            int i = j-1;  
		            while ( (i > -1) && ( arr[i] > key ) ) {  
		                arr[i+1] = arr[i];  
		                i--;  
		            }  
		            arr[i+1] = key;  
		        }  
		        
		        setResult(arr); 
		    } 
	   
	public void run() {
	   
	    long startTime = System.nanoTime();
	    insertionSort(arr);
	    long endTime = System.nanoTime();
	    setElapsedTime(endTime - startTime);
	    timeMap.put("insertion", getElapsedTime());
	}
}
