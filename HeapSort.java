package com.company;

public class HeapSort {

    public void sort(int[] arr) {
        int n = arr.length;

        long startTime = System.nanoTime();

        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for(int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        long stopTime = System.nanoTime();

        System.out.println("\nHeap Sort Start Time: " + startTime);
        System.out.println("\nHeap Sort Stop Time: " + stopTime);
        System.out.println("\nTime Taken To Heap sort: " + (stopTime - startTime));

        System.out.println("\nHeap Sorted Array Is: ");
        printArray(arr);
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < n && arr[l] > arr[largest])
            largest = l;

        if(r < n && arr[r] > arr[largest])
            largest = r;

        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println();
    }
}
