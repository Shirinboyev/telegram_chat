package io.utils;

import java.util.Scanner;

public interface Utils {

    Scanner ScanStr = new Scanner(System.in);

     static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    static Integer enterInt(String hint) {
        Scanner scanInt = new Scanner(System.in);
        System.out.print(hint);
        if (scanInt.hasNextInt()) {
            return scanInt.nextInt();
        } else {
            return enterInt(hint);
        }
    }

    static String enterStr(String hint) {
        System.out.print(hint);
        return ScanStr.nextLine();
    }
}
