package io.utils;

import java.util.Scanner;

public interface Utils {

     static String enterStr(String hint){
         Scanner scanner = new Scanner(System.in);
         System.out.print(scanner);
         return scanner.nextLine();
     }

     static Integer enterInt(String hint){
         Scanner scanner = new Scanner(System.in);
         System.out.print(scanner);
         return scanner.nextInt();
     }

}
