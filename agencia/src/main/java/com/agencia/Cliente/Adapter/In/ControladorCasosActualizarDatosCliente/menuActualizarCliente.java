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

        Scanner sc = new Scanner(System.in);

        System.out.println("ACTUALIZAR CLIENTE");
        System.out.println("Ingresa el numero de documento del cliente");
        String numeroDocumento = CheckString.check("Digita el numero de nuevo");



        existeCliente existenciaCliente = new existeCliente();

        List<actualizarDatosCliente> lista = CasesListController.getController().lstActualizarDatosClientes;




        if (!existenciaCliente.verificarCliente(numeroDocumento)) {
            System.out.println("Presiona Enter para volver al menú");
            sc.nextLine();
            MainCliente.main(null); // Llama al método main del Main para volver al menú principal
            return;
        }

        

        System.out.println("MENU DE ACTUALIZACIÓN");

        int item = 1;
        for (actualizarDatosCliente atributo : lista) {
            System.out.println(item + ". " + atributo.atributo + "\n");
            item++;
        }

        System.out.println(item + ". " + "Salir");

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
