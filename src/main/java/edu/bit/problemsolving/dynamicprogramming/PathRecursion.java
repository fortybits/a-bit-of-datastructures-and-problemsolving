package edu.bit.problemsolving.dynamicprogramming;

public class PathRecursion {

    public static int numPaths(int east, int south) {

        if ((east == 1) || (south == 1)) {
            return 2;
        }
        if (south == 2) {
            return 3;
        } else {
            return (numPaths(east, south - 1) + numPaths(south - 1, east));
        }
    }

    public static void main(String[] args) {
        System.out.println(numPaths(6, 6));
    }
}
