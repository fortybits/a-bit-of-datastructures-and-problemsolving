package edu.bit.datastructures.dp;

/**
 * // Books = [120,180,240,160,180,140], M = 3
 * // D1 = 120,180; 240,160; 180,140 -> 400
 * // D2 = 120,180,240; 160,180; 140 -> 540
 * // - Contiguous  (per student)
 * // - at least one book
 * // - all the books must be distributed
 * <p>
 * M = 1 {} 1040
 * M = 2 {120,180,240 ; 160,180,140} 480. Min [ 120 M1[] , 120,180 M1[]..]
 * M = 3 {120 + M2 [180,240,160,180,140], 120,180 M2[] ]
 * // Mn = Min(Bi + Mn-1)
 */
public class BookDistribution {
}
