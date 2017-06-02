package com.ngcomp.algo.recursion;

/**
 * Created by Ram Parashar on 5/31/17.
 */
public class LinearSum {
  
  public static int linearSum(int[] data, int n) {
    if (n == 0)
      return 0;
    else
      return linearSum(data, n-1 ) + data[ n-1 ];
  }
  
  
  public static void main(String... strings) {
    int[] arr = {1, 2, 3};
    System.out.println(linearSum(arr, arr.length));
  }
}
                                                  