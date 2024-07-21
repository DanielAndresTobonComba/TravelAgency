package com.agencia.Verifiers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckDecimal {

    public static double check(String msj) {
        double opcion = 0.0;
        Scanner scanner = new Scanner(System.in);
        boolean introPermise = true;
        
        while (introPermise == true) {
            try {
                opcion = scanner.nextDouble();
                scanner.nextLine();
                introPermise = false;
            } catch(InputMismatchException e) {
                System.out.println("\n********************************");
                System.out.println("Debe ingresar un número decimal: ");
                System.out.println("********************************\n");
                System.out.println("\n. . . . . . . . . . . . . . . . .");
                System.out.println(String.format("  %s", msj));
                System.out.println(". . . . . . . . . . . . . . . . .");
                System.out.print(">>> ");
                scanner.next();
            }
        }
        return opcion;
    }
}
