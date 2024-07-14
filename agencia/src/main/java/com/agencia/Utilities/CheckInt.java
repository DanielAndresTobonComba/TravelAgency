package com.agencia.Utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckInt {
    
    
    private CheckInt() {}
    
    public static int check() {
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        boolean introPermise = true;
        while (introPermise == true) {
            try {

                opcion = scanner.nextInt();
                scanner.nextLine();
                introPermise = false;
            } catch(InputMismatchException e) {
                System.out.println("\n********************************");
                System.out.println("Debe ingresar un número entero: ");
                System.out.println("********************************\n");
                System.out.println("\n. . . . . . . . . .");
                System.out.println(" Digite la opción");
                System.out.println(". . . . . . . . . . ");
                System.out.print(">>> ");
                scanner.next();
            }
        }
        return opcion;

    }

}
