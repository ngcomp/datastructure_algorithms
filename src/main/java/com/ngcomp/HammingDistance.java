package com.ngcomp;

/**
 * Hamming distance is equal to the number of ones (population count) in a XOR.
 * Created by Ram Parashar on 5/22/17.
 */

public class HammingDistance {

  
  public static int hammingDistance(int x, int y) {
    int dist = 0;
    int val = x ^ y;
    // Count the number of bits set
    while (val != 0)
    {
      // A bit is set, so increment the count and clear the bit
      dist++;
      val &= val - 1;
      System.out.println(val);
    }
    
    //Return the number of differing bits
    return dist;
  }
  
  
  public static void main(String...strings){
    System.out.println(hammingDistance(2, 10));
  }
  
  
}



