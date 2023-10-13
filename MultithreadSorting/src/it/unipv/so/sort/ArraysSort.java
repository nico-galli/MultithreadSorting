package it.unipv.so.sort;
import java.util.Arrays;
import java.util.Map;

public class ArraysSort extends Sort{
	
	// costruttore
	public ArraysSort(int[] arr, Map<String, Long> timeMap) {
		super(arr, timeMap);
	}

	public void run() {
	   
	    long startTime = System.nanoTime();
	    Arrays.sort(arr);
        setResult(arr);
	    long endTime = System.nanoTime();
		setElapsedTime(endTime - startTime);
		timeMap.put("sort", getElapsedTime());
	}

}
