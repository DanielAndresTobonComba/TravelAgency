package com.agencia.Verifiers;

import java.io.Console;

public class CheckPassword {

    public static String check() {
        String pwdString = "";
        Console newConsole = System.console();
        boolean verificacion = true;

        char [] pwd = null;

        String msj = "Escriba la cotraseña";
        
        while (verificacion == true) {
            pwd = newConsole.readPassword(String.format("\n. . . . . . . . . . . . . . . . . .\n%s\n. . . . . . . . . . . . . . . . . .\n>>> ", msj));
            for (char letter : pwd) {
                pwdString += letter;
            }

            if ("".equals(pwdString.trim())) {
                System.out.println("\n********************************");
                System.out.println("No se permiten entradas vacías ");
                System.out.println("********************************");
                msj = "Ingrese de nuevo la contraseña";
            } else  {
                verificacion = false;
            }
        }
        
        return pwdString;
    }

}
