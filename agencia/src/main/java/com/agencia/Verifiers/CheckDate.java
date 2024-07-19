package com.agencia.Verifiers;

import java.sql.Date;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class CheckDate {

    public static String check(String msj) {

        String date = "";
        boolean checkDate = false;
        
        Scanner scanner = new Scanner(System.in);
        
        while (checkDate == false) {
            try {

                date = scanner.nextLine();
                if (date.trim().toLowerCase().equals("exit") == false) {

                    Date verifiedDate = Date.valueOf(date.trim());
                    
                }
                checkDate = true;
                
            } catch(IllegalArgumentException e) {
                System.out.println("\n********************************");
                System.out.println("   Formato de fecha INCORRECTO ");
                System.out.println("*********************************\n");
                System.out.println("\n. . . . . . . . . . . . . . . . . . . . . . .");
                System.out.println(String.format("  %s", msj));
                System.out.println("                 [AAAA-MM-DD]");
                System.out.println(". . . . . . . . . . . . . . . . . . . . . . .");
                System.out.println("          [EXIT/exit] para Salir");
                System.out.print(">>> ");
                //scanner.next();
            }
        }



        return date;

    }

}
