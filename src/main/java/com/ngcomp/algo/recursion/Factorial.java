package com.ngcomp.algo.recursion;

/**
 * Created by Ram Parashar on 5/31/17.
 */
public class Factorial {
  
  public static int factorial(int n){
    if(n < 0)
      throw new IllegalArgumentException();
    else if (n == 0)
      return 1;
    else return n * factorial(n -1 );
  }
  
  public static void main(String...strings){
    System.out.println(factorial(5));
  }
}
