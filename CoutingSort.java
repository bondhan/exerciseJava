import java.io.*;
import java.util.*;


/* 
Your previous Java content is preserved below:

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

Question:
Given a very large Integer Array, find the top 5 largest in descending order in O(N).

*/

class CoutingSort {
  
  //frequency couting
  public static int[] hitungElements(int[] input, int k) {
    int[] c = new int[k + 1];
    Arrays.fill(c, 0);
 
    for (int i : input) {
        c[i] += 1;
    }
 
    System.out.println(Arrays.toString(c));
    
    for (int i = 1; i < c.length; i++) {
      c[i] += c[i - 1];
    }
    
    System.out.println(Arrays.toString(c));
 
    return c;
  }
  
  
  //do the sorting
  public static int[] countingSort(int[] input, int k) {
        int[] c = hitungElements(input, k);    

        int[] sorted = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int current = input[i];
            sorted[c[current] - 1] = current;
            c[current] -= 1;
        }
      
        return sorted;
  }
     
  
  public static void main(String[] args) {
    System.out.println("Top 5 largest Int are: " );
    
    int []numbers;
    numbers = new int[]{5, 2, 1, 3, 9 ,10, 11, 11};    
  
    
    //finding the maximum value
    int min = -1;
    for (int i=0; i < numbers.length; i++){
      if (numbers[i] > min){
        min = numbers[i];
      }
    }
    
    //do a counting sort
    int[] res = countingSort(numbers, min);
    
    for (int j=res.length-1; j >=res.length-5 ; j--) {
      System.out.println(res[j]);
    }
  }
}
