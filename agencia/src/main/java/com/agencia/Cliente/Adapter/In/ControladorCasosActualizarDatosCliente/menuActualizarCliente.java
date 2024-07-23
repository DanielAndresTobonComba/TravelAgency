package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import java.util.List;
import java.util.Scanner;

import com.agencia.CasesListController.CasesListController;
import com.agencia.Cliente.MainCliente;
import com.agencia.Cliente.Adapter.Out.existeCliente;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class menuActualizarCliente {

    

    public void ejecutarMenu() {

        existeCliente existenciaCliente = new existeCliente();

        List<actualizarDatosCliente> lista = CasesListController.getController().lstActualizarDatosClientes;


        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("          ACTUALIZAR CLIENTE");
        System.out.println("===================================");

        System.out.print("Documento >>>> ");
        String numeroDocumento = CheckString.check("Digita el documento de nuevo");

        if (!existenciaCliente.verificarCliente(numeroDocumento)) {
            System.out.println("Presiona Enter para volver al menú");
            sc.nextLine();
            MainCliente.main(null); // Llama al método main del Main para volver al menú principal
            return;
        }

        System.out.println("===================================");
        System.out.println("          MENU DE ACTUALIZACIÓN");
        System.out.println("===================================");

        int item = 1;
        for (actualizarDatosCliente atributo : lista) {
            System.out.println(item + ". " + atributo.atributo + "\n");
            item++;
        }

        System.out.println(item + ". " + "Salir");

        System.out.print("\nOpcion >>>> ");

        int opcion = 0;
        boolean checkOption = false;

        while (!checkOption) {
            opcion = CheckInt.check("Digita de nuevo la opcion");
            if (opcion >= 1 && opcion <= lista.size() + 1) {
                checkOption = true;
            } else {
                System.out.println("Opcion incorrecta");
            }
        }

        if (opcion <= lista.size()) {
            lista.get(opcion - 1).actualizar(numeroDocumento);
        } else {
            MainCliente.main(null); // Llama al método main del Main para volver al menú principal
        }
    }
}
