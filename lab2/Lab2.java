package lab2;
import java.io.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * CECS 328 - Spring 2018 
 * @author Harvey Han
 * 012020981
 * Create two functions named quick_sort and insertion_sort
 * 1. request the user to enter a positive integer, and call it n
 * 2. generate n random integer between -7000 to 7000 and save them into an array a
 * 3. call quick_sort function to sort the array
 * 4. insertion_sort function to sort the array
 * 5. determine the average-running time of each function for n = 10000 and 100 repetition
 * 6. Calculate the growth of each function
 * 7. Calculate how many instructions your machine can run in a second using step 5 and 6
 */
public class Lab2 {

    /**
     * Main function for quick sort and insertion sort
     */
    public static void main(String[] args) 
    {
        int max = 7000;
        int min = -7000;
        int n = 1;
        int ch;
        long StartTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        n = in.nextInt();
        Random rand = new Random();
        
        int[] a = new int[n];
        
        for(int i = 0; i < a.length; i++)
        {
            a[i] = rand.nextInt(max + 1 - min) + min;
        }
        System.out.println("n =" + Arrays.toString(a));
        System.out.println(" 1: Quick sort function \n 2: Insertion sort function \n 3: determine the average-running time of each function for n = 10000 and 100 repetition ");
        ch = in.nextInt();
        switch(ch)
        {
            case 1:
                int start = 0;
                int end   = n -1;
                quickSort(a,start,end);
                print(a,n);
                long TotalTime = System.currentTimeMillis() - StartTime;
                System.out.println("\n Total elapsed time (milliseconds) is: " + TotalTime + "\n");
                break;
            case 2:
                insertionSort(a,n);
                break;
            case 3:
                for(int i = 0; i <= 100; i++)
                {
                    start = 0;
                    end   = n - 1;
                    quickSort(a,start,end);
                    print(a,n);
                }
                TotalTime = System.currentTimeMillis() - StartTime;
                System.out.println("\n Total elapsed time (milliseconds) is: " + TotalTime + "\n");
                break;
        }
    }
    public static int quickPart(int a[], int start, int end)
    {
        int temp;
        int pivot = a[end];
        int pIndex = start;
        for(int i = start; i < end; i++)
        {
            if(a[i]<= pivot)
            {
                //swaps a[i], apindex
                temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }
        temp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp;
        return pIndex;
    }
    public static void quickSort(int a[], int start, int end)
    {
        if(start < end)
        {
            int pIndex = quickPart(a,start,end);
            quickSort(a,start,pIndex-1);
            quickSort(a,pIndex+1,end);
        }
        else
        {
            return;
        }
    }
    public static void insertionSort(int a[], int n)
    {
        for(int i = 1; i < n;i++)
        {
            int val = a[i];
            int hole = i;
            while(hole > 0 && a[hole - 1]>val)
            {
                a[hole] = a[hole - 1];
                hole = hole - 1;
            }
            a[hole] = val;
            print(a,n);
        }
    }
    public static void print(int a[], int n)
    {
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(a[i]+"\t");
        }
    }
}
