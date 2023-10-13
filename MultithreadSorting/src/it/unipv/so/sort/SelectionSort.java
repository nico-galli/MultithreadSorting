package it.unipv.so.sort;
import java.util.Map;

public class SelectionSort extends Sort{
	
	//costruttore
	public SelectionSort(int[] arr, Map<String, Long> timeMap) {
		super(arr, timeMap);
	}

	public void selectionSort(int[] arr){  
		   int n = arr.length; 
	        for (int i = 0; i < n - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < n; j++){  
	                if (arr[j] < arr[index]){  
	                    index = j; //ricerca del valore minore 
	                }  
	            }  
	            int smallerNumber = arr[index];   
	            arr[index] = arr[i];  
	            arr[i] = smallerNumber;  
	        }  
	        
	        setResult(arr); 
	   }
	   
	   public void run() {
		   
		    long startTime = System.nanoTime();
		    selectionSort(arr);
			long endTime = System.nanoTime();
			setElapsedTime(endTime - startTime);
			timeMap.put("selection", getElapsedTime());
		   
	   }
}
