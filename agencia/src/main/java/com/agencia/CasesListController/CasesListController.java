package com.agencia.CasesListController;

import java.util.ArrayList;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Contrasena;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Edad;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Nombre;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.NumeroDocumento;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.TipoDocumento;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Usuario;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;
import com.agencia.EmployeeView.Domain.RegistrarAvion;
import com.agencia.IntroView.Domain.IntroLogIn;
import com.agencia.RevisionMantenimiento.Application.actualizarRevision;
import com.agencia.RevisionMantenimiento.Application.crearRevision;
import com.agencia.RevisionMantenimiento.Application.eliminarRevision;
import com.agencia.Tarifa.Application.Casos.ActualizarTarifa.actualizarDescripcionTarifa;
import com.agencia.Tarifa.Application.Casos.ActualizarTarifa.actualizarDetallesTarifa;
import com.agencia.Tarifa.Application.Casos.ActualizarTarifa.actualizarImpuestoTarifa;
import com.agencia.Tarifa.Application.Casos.ActualizarTarifa.actualizarPrecioTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;
import com.agencia.IntroView.Domain.Exit;

public class CasesListController {

    public static List<Funcionalidad> lstIntro;
    public static List<Funcionalidad> lstFuncionalidades;
    public static List<actualizarDatosCliente> lstActualizarDatosClientes;
    public static List<actualizarDatosTarifa> lstActualizarDatosTarifas;

    public static List<Funcionalidad> lstFuncionalidadRevisionMantenimiento;

    private static CasesListController CONTROLLER = new CasesListController();

    private CasesListController() {


        lstIntro = new ArrayList<>();
        lstFuncionalidades = new ArrayList<>();
        lstActualizarDatosClientes = new ArrayList<>();
        lstActualizarDatosTarifas = new ArrayList<>();

        lstFuncionalidadRevisionMantenimiento = new ArrayList<>();

        //Agregar FUNCIONALIDADES A REVISION MANTENIMIENTO 
        Funcionalidad crearRevision = new crearRevision("Crear revisión"); 
        Funcionalidad eliminarRevision = new eliminarRevision("Eliminar revisión");
        Funcionalidad actualizarRevision = new actualizarRevision("Actualizar revisión");


        // AGREGAR LAS FUNCIONALIDADE AL MENU

        lstFuncionalidadRevisionMantenimiento.add(crearRevision);
        lstFuncionalidadRevisionMantenimiento.add(eliminarRevision);
        lstFuncionalidadRevisionMantenimiento.add(actualizarRevision);




        // AGREGAR FUNCIONALIDADES A ACTUALIZAR TARIFA 
        actualizarDatosTarifa actualizarDescripcion = new actualizarDescripcionTarifa ("Actualizar descripción");
        actualizarDatosTarifa actualizarDetalles = new actualizarDetallesTarifa("Actualizar detalle"); 
        actualizarDatosTarifa actualizarPrecio = new actualizarPrecioTarifa("Actualizar precio");
        actualizarDatosTarifa actualizarImpuesto = new actualizarImpuestoTarifa("Actualizar impuesto");


        // AGREGAR LA FUNCIONALIDAD A LA LISTA DE CASOS DE USO DE ACTUALIZAR TATIFA

        lstActualizarDatosTarifas.add(actualizarDescripcion);
        lstActualizarDatosTarifas.add(actualizarDetalles);
        lstActualizarDatosTarifas.add(actualizarPrecio);
        lstActualizarDatosTarifas.add(actualizarImpuesto);


        // Crear las funciones del menu principal de inicio de sesion

        Funcionalidad introLogin = new IntroLogIn("Iniciar Sesión", "");
        Funcionalidad logOut = new Exit("Salir", "");
        Funcionalidad registrarAvion = new RegistrarAvion("Registrar Avión", "rav");


        // Agregar las funcionalidades al menu
        lstIntro.add(introLogin);
        lstIntro.add(logOut);
        lstFuncionalidades.add(registrarAvion);
;


        // FUNCIONALIDADES ACTUALIZAR CLIENTE
        actualizarDatosCliente actualizarNombre = new Nombre("Actualizar nombre");
        actualizarDatosCliente actualizarEdad = new Edad("Actualizar edad");
        actualizarDatosCliente actualizarTipoDocumento = new TipoDocumento("Actualizar tipo de documento");
        actualizarDatosCliente actualizarNumeroDocumento = new NumeroDocumento("Actualizar numero de documento"); 
        actualizarDatosCliente actualizarUsuario = new Usuario("Actualizar usuario");
        actualizarDatosCliente actualizarContraseña = new Contrasena("Actualizar contraseña");

        // AGREGAR LA FUNCIONALIDAD A LA LISTA DE CASOS DE USO DE ACTUALIZAR DATOS DEL CLIENTE 
        lstActualizarDatosClientes.add(actualizarNombre);
        lstActualizarDatosClientes.add(actualizarEdad);
        lstActualizarDatosClientes.add(actualizarTipoDocumento);
        lstActualizarDatosClientes.add(actualizarNumeroDocumento);
        lstActualizarDatosClientes.add(actualizarUsuario);
        lstActualizarDatosClientes.add(actualizarContraseña);


        

        
    }

    public static CasesListController getController() {
        return CONTROLLER;
    }

    


}
