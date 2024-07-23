package com.agencia.Cliente.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirEnPlaca;

public class imprimirEnPlacaCliente extends imprimirEnPlaca{

    @Override
    public void imprimir(ResultSet resultSet) {


        int countRows = 0;

        String nombre = "";
        int edad = 0; 
        int tipoDoc = 0;
        String numDoc = ""; 
        String usuario = ""; 



        try {

            while(resultSet.next()) {
                countRows ++;
                
                nombre = resultSet.getString("nombre");
                edad = resultSet.getInt("edad");
                tipoDoc = resultSet.getInt("TipoDocumento_id");
                numDoc  = resultSet.getString("numeroDocumento");
                usuario = resultSet.getString("usuario");
            }

            if (countRows == 1) {
                System.out.println("\n\n============================================");
                System.out.println("||        INFORMACIÓN DEL CLIENTE         ||");
                System.out.println("||----------------------------------------||");

                if (nombre.length() >= 12) {

                    System.out.println("||  Nombre:         " + nombre + "\t  ||");
                } else {
                    System.out.println("||  Nombre:         " + nombre + "\t\t\t  ||");
                }
                System.out.println("||  Edad:           " + edad + "\t\t\t  ||");
                System.out.println("||  Tipo documento: " + tipoDoc + "\t\t\t  ||");
                System.out.println("||  Documento:      " + numDoc + "\t\t  ||");

                if (usuario.length() >= 12) {
                    System.out.println("||  Usuario:        " + usuario + "\t\t\t ||");
                } else {
                    System.out.println("||  Usuario:        " + usuario + "\t\t  ||");
                }

                System.out.println("============================================\n");
            } else {
                System.out.println("*******************************************");
                System.out.println("  IMPOSIBLE MOSTRAR INFORMACIÓN DE ESTE CLIENTE");
                System.out.println("*******************************************");
            }


        } catch (SQLException e) {

            e.printStackTrace();

        }
        
    }

}
