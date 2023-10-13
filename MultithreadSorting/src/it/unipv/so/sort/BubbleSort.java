package it.unipv.so.sort;
import java.util.Map;

public class BubbleSort extends Sort{

	//costruttore
	public BubbleSort(int[] arr, Map<String, Long> timeMap) {
		super(arr, timeMap);
	}

	public void bubbleSort(int[] arr) {
	        int n = arr.length;  
	        int temp = 0;
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(arr[j-1] > arr[j]){  
	                                 //swap 
	                                 temp = arr[j-1];  
	                                 arr[j-1] = arr[j];  
	                                 arr[j] = temp;  
	                         } 
	                 }  
	         }
	         
	       setResult(arr);
	 }
	 
	public void run() {
		long startTime = System.nanoTime();
		bubbleSort(arr);
		long endTime = System.nanoTime();
		setElapsedTime(endTime - startTime);
		timeMap.put("bubble", getElapsedTime());

	}
}
	
