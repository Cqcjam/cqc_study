package com.cqc.learning.algorithm;

import java.util.Scanner;

public class ScanerUtils {

    public static String inputStr() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            return sc.next();
        }
        return null;
    }

    public static void main(String[] args) {
        int result = 1 % 10;
        System.out.println(result);
    }
}
