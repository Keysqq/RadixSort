package com.GC;
//Dev: Justin Fredericks
//Class: 171
//Date: 4/09/2022
//Script: Radix Sort
//Assignment: 23.12
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Test");
        int[] randIntArr = new int[100];
        Random rand = new Random();

        int temp=0;
        for (int i =0; i < randIntArr.length;i++){
            temp = rand.nextInt(101);
            randIntArr[i] = temp;
        }
        //print unsorted array
        for (int i =0; i < randIntArr.length;i++){
            System.out.println(randIntArr[i]+" "+i+1);
        }

        radixsort(randIntArr,100);

        //print sorted array
        for (int i =0; i < randIntArr.length;i++){
            System.out.println(randIntArr[i]+" "+i+1);
        }
    }//main

    // get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
