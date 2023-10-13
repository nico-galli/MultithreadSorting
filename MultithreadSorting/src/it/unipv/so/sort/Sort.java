package it.unipv.so.sort;
import java.util.Arrays;
import java.util.Map;

public abstract class Sort implements Runnable{
	
	int[] arr;
	int[] result;
	long elapsedTime;
	Map<String, Long> timeMap;
	
	public Sort(int[] arr, Map<String, Long> timeMap) {
		this.arr= arr;
		this.timeMap=timeMap;
	}

	public void setResult(int[] result) {
		this.result = result;
	}
		
	public String getResult() {
		return Arrays.toString(result);
	}
	   
	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public int[] getArrRes() {
		return result;
	}

}
