package com.agencia.RevisionMantenimiento.Adapter.In;
import java.util.Scanner;

import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Adapter.Out.existeAvion;
import com.agencia.RevisionMantenimiento.Adapter.Out.repoCrearRevision;
import com.agencia.RevisionMantenimiento.Domain.revision;
import com.agencia.RevisionMantenimiento.Utilities.tomarDatosRevision;
import com.agencia.Verifiers.CheckDate;
import com.agencia.Verifiers.CheckString;

public class controladorCrearRevision extends tomarDatosRevision {

    @Override
    public void tomarDatos() {

        Scanner sc = new Scanner(System.in);

        repoCrearRevision crearRevision = new repoCrearRevision(); 

        revision revision = new revision();

        System.out.println("\n===================================");
        System.out.println("          CREAR REVISIÒN");
        System.out.println("===================================");

        System.out.print("Placa del aviòn >>>> ");
        String placaAvion = CheckString.check("Digita de nuevo la placa del aviòn.");

        existeAvion existeAvion = new existeAvion(); 
        
        if (!existeAvion.verficiar(placaAvion)) {
            System.out.println("Error con la placa ingresada");
            System.out.println("Presiona entrer para volver al menu");
            sc.nextLine(); 
            MainRevisionMantenimiento.main();
        }
/* 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");


        dateFormat.setLenient(false); 
 
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

     */   
        System.out.print("Descripciòn de la revisiòn >>>> ");
        String descripcion = CheckString.check("Digita de nuevo la descripción"); 
        
        System.out.print("Fecha de revisiòn [AAAA-MM-DD]  >>> ");
        String fecha = CheckDate.check("Digita de nuevo la fecha");


        revision.setFecha(fecha);
        revision.setDescripcion(descripcion);
        revision.setPlacaAvion(placaAvion);
        

        crearRevision.ejecutarCrearRevision(revision);
       
    }




        
    }


