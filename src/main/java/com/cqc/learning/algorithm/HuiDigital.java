package com.cqc.learning.algorithm;


public class HuiDigital {
    public static void main(String[] args) {
        //System.out.println(dealHuiDigital1(ScanerUtils.inputStr()));
        System.out.println(dealHuiDigital12(1211));
    }


    private static boolean dealHuiDigital12(int data) {
        if (0 > data) {
            return false;
        }
        int temp = data;
        int cur = 0;
        while (temp != 0) {
            cur = cur * 10 + temp%10;
            temp = temp / 10;
        }

        return data == cur;
    }

    public static boolean dealHuiDigital1(String digital) {
        if (null == digital || digital.length() == 0) {
            return false;
        }
        if (digital.contains("-") && digital.startsWith("-")) {
            return false;
        }

        char[] charStr = String.valueOf(digital).toCharArray();
        int low = 0;
        int high = digital.length() - 1;
        for (int index = 0; index <= high >> 1; index++) {
            while (low <= high) {
                if (charStr[low] == charStr[high]) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
