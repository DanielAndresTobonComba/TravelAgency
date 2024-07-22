package com.agencia.RevisionMantenimiento.Adapter.In;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Adapter.Out.existeAvion;
import com.agencia.RevisionMantenimiento.Adapter.Out.repoCrearRevision;
import com.agencia.RevisionMantenimiento.Domain.revision;
import com.agencia.RevisionMantenimiento.Utilities.tomarDatosRevision;
import com.agencia.Verifiers.CheckString;

import java.util.Scanner;

public class controladorCrearRevision extends tomarDatosRevision {

    @Override
    public void tomarDatos() {

        Scanner sc = new Scanner(System.in);

        repoCrearRevision crearRevision = new repoCrearRevision(); 

        revision revision = new revision();

        System.out.println("Digita la placa del avion en revisión");
        String placaAvion = CheckString.check("Digita de nuevo el id del avion");

        existeAvion existeAvion = new existeAvion(); 
        
        if (!existeAvion.verficiar(placaAvion)) {
            System.out.println("Error con la placa ingresada");
            System.out.println("Presiona entrer para volver al menu");
            sc.nextLine(); 
            MainRevisionMantenimiento.main();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.setLenient(false);  // No permitir fechas no válidas

        String fecha = null;
        java.sql.Date sqlDate = null;

        while (true) {
            System.out.println("Ingresa la fecha de revisión en este formato yyyy/MM/dd");
            fecha = sc.nextLine();

            try {
                // Intentar parsear la fecha ingresada
                java.util.Date utilDate = dateFormat.parse(fecha);
                // Convertir java.util.Date a java.sql.Date
                sqlDate = new java.sql.Date(utilDate.getTime());
                break;  // Salir del bucle si la fecha es válida
            } catch (ParseException e) {
                System.out.println("Fecha no válida. Digita de nuevo la fecha en el formato correcto (yyyy/MM/dd).");
            }
        }

        System.out.println("Fecha válida: " + sqlDate);

        
        System.out.println("Digita la descripcion de la revisión");
        String descripcion = CheckString.check("Digita de nuevo la descripción"); 


        revision.setFecha(sqlDate);
        revision.setDescripcion(descripcion);
        revision.setPlacaAvion(placaAvion);
        

        crearRevision.ejecutarCrearRevision(revision);
       
    }




        
    }


