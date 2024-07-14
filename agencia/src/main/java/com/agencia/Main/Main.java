package com.agencia.Main;

import com.agencia.DataBaseConfig.DataBaseConfig;

public class Main {
    public static void main(String[] args) {
        
        //Confirmación de la conexión a la Base de datos 
        System.out.println(DataBaseConfig.getConnection().msjConnection);

        

    }
}