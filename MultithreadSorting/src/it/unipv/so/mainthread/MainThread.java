package it.unipv.so.mainthread;
/* MULTITHREAD SORTING
 * 
 * Bernazzani Marco
 * Galli Nicolò
 * 
 * July 2023
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import it.unipv.so.sort.ArraysSort;
import it.unipv.so.sort.BubbleSort;
import it.unipv.so.sort.InsertionSort;
import it.unipv.so.sort.SelectionSort;

import java.util.Map.Entry;

// thread principale
public class MainThread{
	
	private int min;
	private int max;
	private int n;
	private int[] arr = new int[n];
	private Map<String, Long> timeMap;
	
	// costruttore
	public MainThread(int min, int max, int n, int[] arr) {
		this.min = min;
		this.max = max;
		this.n = n;
		this.arr = arr;
		this.timeMap = new ConcurrentHashMap<>();
	}
	
	public int[] randomArray() {
		
		for(int i = 0; i < n; i++) {
			
				arr[i] = (int)(Math.random()*(getMax() - getMin() + 1) + getMin());  
		}
		
		return arr;
	}

	public int getMin() {
		return min;
	}


	public int getMax() {
		return max;
	}


	public int getN() {
		return n;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public void setN(int n) {
		this.n = n;
	}
	

	public int[] getArr() {
		return arr;
	}


	public void setArr(int[] arr) {
		this.arr = arr;
	}

	// main
	public static void main(String args[]) {
		
		// inserimento lunghezza vettore
		System.out.print("Enter an integer: ");
		int n = 0;	
		while (n<=0) {
				n = new Scanner(System.in).nextInt();
				if (n<= 0) {
					System.out.print("Invalid value, enter another integer: ");
				}
			} 

		System.out.print("\n");
		
		int[] arr = new int[n];
		
		// istanza thread principale
		MainThread mainThread = new MainThread(0, 100, n, arr);
		long startTime = System.nanoTime();
		
		mainThread.setArr(mainThread.randomArray());
	
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.print("\n");
        
        BubbleSort bubbleThreaded = new BubbleSort(arr, mainThread.timeMap);
        SelectionSort selectionThreaded = new SelectionSort(arr, mainThread.timeMap);
        InsertionSort insertionThreaded = new InsertionSort(arr, mainThread.timeMap);
        ArraysSort arraysThreaded = new ArraysSort(arr, mainThread.timeMap);
        

        // istanza thread degli algoritmi di ordinamento
        Thread t1 = new Thread(bubbleThreaded);
        Thread t2 = new Thread(selectionThreaded);
        Thread t3 = new Thread(insertionThreaded);
        Thread t4 = new Thread(arraysThreaded);

        t1.start();   
        t2.start();
        t3.start();
        t4.start();
        
        // attendo che tutti i thread terminino la loro esecuzione prima di concludere il main
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // thread per controllare che tutti gli array sono uguali
        ArrayCheck checkThreaded = new ArrayCheck(bubbleThreaded.getArrRes(), selectionThreaded.getArrRes(), insertionThreaded.getArrRes(), arraysThreaded.getArrRes());
        Thread t5 = new Thread(checkThreaded);
        
        t5.start();
        
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(checkThreaded.isCheck()) {
        	System.out.println("All sorted arrays are equal\n");
        }
        
        // stampa degli array ordinato e dei tempi impiegati
        System.out.println("Sorted Array:" + bubbleThreaded.getResult() + "\n");
        
        System.out.println("BubbleSort elapsed time:\t" + bubbleThreaded.getElapsedTime() + "ns");
        System.out.println("SelectionSort elapsed time:\t" + selectionThreaded.getElapsedTime() + "ns");
        System.out.println("InsertionSort elapsed time:\t" + insertionThreaded.getElapsedTime() + "ns");
        System.out.println("ArraysSort elapsed time:\t" + arraysThreaded.getElapsedTime() + "ns");
        
        System.out.print("\n");
        
        // mappa
        System.out.println("Elapsed time ConcurrentHashMap");
        System.out.println(mainThread.timeMap);
        System.out.print("\n");
        
        // lista ordinata
        Set<Entry<String, Long>> entrySet = mainThread.timeMap.entrySet();
        ArrayList<Map.Entry<String, Long> > listOfEntry = new ArrayList<Entry<String, Long> >(entrySet);
        listOfEntry.sort(Entry.comparingByValue());
        System.out.println("Elapsed time sorted ArrayList");
        System.out.println(listOfEntry);
        System.out.print("\n");
        System.out.println("In this case the fastest thread is " + listOfEntry.get(0));
        
        long endTime = System.nanoTime();
        
        long elapsedTime = (endTime - startTime);
        System.out.print("\n");
		System.out.println("Main elapsed time: " + elapsedTime + "ns\n");
	}

}
