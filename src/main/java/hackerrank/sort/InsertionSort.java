package hackerrank.sort;

import java.io.*;
import java.util.*;

public class InsertionSort {

    public static void insertionSortPart2(int[] ar) {

        for (int i =1 ; i < ar.length; i++) {

            int toBeInseted = ar[i];

            for (int j=i-1; j>=0; j--) {
                if (toBeInseted >= ar[j]) {
                    break;
                } else {
                    ar[j + 1] = ar[j];
                    ar[j] = toBeInseted;
                }
            }

            printArray(ar);

        }
    }
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }


    private static int binarySearch(List<Integer> array, int n) {

        int low=0, high = array.size()-1, center = 0;

        while (low <= high) {

            center = (high+low)/2;

            int cmp = array.get(center).compareTo(n);

            if (cmp == 0) {
                return center;
            } else if (cmp > 0) {
                high = center-1;
            } else {
                low = center+1;
            }

        }

        return center;
    }
}
