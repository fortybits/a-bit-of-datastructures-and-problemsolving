package edu.bit.problemsolving.competitive.hackerrank.certification.jv;

import edu.bit.datastructures.stack.ValidParenthesis;

import java.util.Scanner;

public class BracketParsingStack {

    public static void main(String[] args) {
        ValidParenthesis parser = new ValidParenthesis();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }
        in.close();
    }
}