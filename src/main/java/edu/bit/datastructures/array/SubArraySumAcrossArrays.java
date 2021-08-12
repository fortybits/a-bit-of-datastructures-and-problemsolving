package edu.bit.datastructures.array;

import edu.bit.annotations.organisation.Zeta;
import edu.bit.annotations.topics.Array;
import edu.bit.annotations.topics.PrefixSum;

/**
 * // A = [1,2,3,4,5,8,11], B = [2,3,4,5,1,11,9]
 * // i,j -> sum(Ai..j) == sum(Bi..j)
 *
 * Integers -i to i
 *
 * length N
 * Sum(A0..An) == Sum(B0..Bn)
 *
 * length N-1
 * Sum(A1...An)
 * Sum(A0...An-1)
 *
 * ...
 * length 1
 * Sum(A0)
 * Sum(A1)
 *
 *
 * => find all sub arrays of A with length 1 to N
 *
 * for(i=0....n-1)
 *    for(j=1 to n)
 *        find the sub array starting at i and length j
 *        sum the values [(O(s)]
 *
 * runtime O(N)
 * space O(N)
 * // AP=[0,1,3,6,10,15,23,36]
 * // BP=[0,2,5,9,8,15,26,34]
 *
 * length N
 * Sum(A0..An) == Sum(B0..Bn)
 * APn == BPn
 *
 * length N-1
 * Sum(A1...An) (APn - AP0) == (BPn -BP0) // 36
 * Sum(A0...An-1) APn-1 == BPn-1
 *
 * length N-2
 * Sum(A0...An-2) APn-2 == BPn-2
 * Sum(A1...An-1) APn-1 == BPn-1
 * Sum(A2...An) (APn-1 - AP0) == (BPn -BP0)
 *
 * ...
 * length 1
 * Sum(A0)
 * Sum(A1)
 *
 *
 * for(i=0 to N-1)
 *    create sumA and sumB
 *
 * for(i = N to 1) // N, N-1
 *   for(j = 0 to N-i) // 0
 *       // int endIn = i+j;
 *       int subArrraySumA =  sumA(i+j) - sumA(j);
 *       int subArraySumB = sumB(i+j) - sumB(j);
 *       if(subArrraySumA == subArraySumB)
 *           break; // return
 *
 */
@Array
@PrefixSum
@Zeta
public class SubArraySumAcrossArrays {
}
