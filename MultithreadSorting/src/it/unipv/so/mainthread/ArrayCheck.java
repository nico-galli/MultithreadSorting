package it.unipv.so.mainthread;

import java.util.Arrays;

public class ArrayCheck implements Runnable {
	
	private int[] bubbleArray;
	private int[] selectionArray;
	private int[] insertionArray;
	private int[] sortArray;
	private boolean check = false;
	
	public ArrayCheck(int[] bubbleArray, int[] selectionArray, int[] insertionArray, int[] sortArray) {
		super();
		this.bubbleArray = bubbleArray;
		this.selectionArray = selectionArray;
		this.insertionArray = insertionArray;
		this.sortArray = sortArray;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}


	@Override
	public void run(){
		
		boolean c1 = Arrays.equals(bubbleArray, selectionArray);
		boolean c2 = Arrays.equals(bubbleArray, insertionArray);
		boolean c3 = Arrays.equals(bubbleArray, sortArray);
		
		if(c1 && c2 && c3) {
			setCheck(true);
		}
		else {
			throw new RuntimeException("sorted arrays are not equals");
		}
		
	}

}
