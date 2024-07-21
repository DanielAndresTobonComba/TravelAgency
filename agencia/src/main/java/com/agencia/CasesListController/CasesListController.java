package com.agencia.CasesListController;

import java.util.ArrayList;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Aeropuerto.Infraestructure.In.GoToActualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.GoToConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.GoToCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.GoToEliminarAeropuerto;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Contrasena;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Edad;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Nombre;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.NumeroDocumento;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.TipoDocumento;
import com.agencia.Cliente.Application.CasosActualizarDatosCliente.Usuario;
import com.agencia.EmployeeView.Domain.GestionarAeropuerto;
import com.agencia.EmployeeView.Domain.GestionarAvion;
import com.agencia.GestionAvion.Adapter.GoToEliminarAvion;
import com.agencia.GestionAvion.Adapter.GoToRegistrarAvion;
import com.agencia.IntroView.Domain.IntroLogIn;
import com.agencia.IntroView.Domain.Exit;

public class CasesListController {

    public static List<Funcionalidad> lstIntro;
    public static List<Funcionalidad> lstFuncionalidades;
    public static List<actualizarDatosCliente> lstActualizarDatosClientes;
    public static List<Funcionalidad> lstGestionarAeropuerto;
    public static List<Funcionalidad> lstGestionarAvion;

    private static CasesListController CONTROLLER = new CasesListController();

    private CasesListController() {
        lstIntro = new ArrayList<>();
        lstFuncionalidades = new ArrayList<>();
        lstActualizarDatosClientes = new ArrayList<>();
        lstGestionarAvion = new ArrayList<>();
        lstGestionarAeropuerto = new ArrayList<>();

        // Instanciación funciones del Login Inicial
        Funcionalidad introLogin = new IntroLogIn("Iniciar Sesión", "");
        Funcionalidad logOut = new Exit("Salir", "");

        // Instanciación funciones del empleado
        
        Funcionalidad gestionarAvion = new GestionarAvion("Gestionar Avión", "gav");
;       Funcionalidad gestionarAeropuerto = new GestionarAeropuerto("Gestionar Aeropuerto", "gae");


        // INSTANCICIÓN FUNCIONALIDADES ACTUALIZAR CLIENTE
        actualizarDatosCliente actualizarNombre = new Nombre("Actualizar nombre");       
        actualizarDatosCliente actualizarEdad = new Edad("Actualizar edad");
        actualizarDatosCliente actualizarTipoDocumento = new TipoDocumento("Actualizar tipo de documento");
        actualizarDatosCliente actualizarNumeroDocumento = new NumeroDocumento("Actualizar numero de documento"); 
        actualizarDatosCliente actualizarUsuario = new Usuario("Actualizar usuario");
        actualizarDatosCliente actualizarContraseña = new Contrasena("Actualizar contraseña");

        // INSTANCIACIÓN FUNCIONALIDADES ´PARA GESTIONAR AVIÓN
        Funcionalidad registrarAvion = new GoToRegistrarAvion("Registrar Avión", "");
        Funcionalidad eliminarAvion = new GoToEliminarAvion("Eliminar Avión", "");


        // INSTANCIACIÓN FUNCIONALIDADES PARA GESTIONAR AEROPUERTO
        Funcionalidad registrarAeropuerto = new GoToCrearAeropuerto("Registrar Aeropuerto", "");
        Funcionalidad actualizarAeropuerto = new GoToActualizarAeropuerto("Actualizar Aeropuerto", "");
        Funcionalidad consultarAeropuerto = new GoToConsultarAeropuerto("Consultar Aeropuerto", "");
        Funcionalidad eliminarAeropuerto = new GoToEliminarAeropuerto("Eliminar Aeropuerto", "");

        // AGREGAR LA FUNCIONALIDAD A LA LISTA DE CASOS DE USO DE ACTUALIZAR DATOS DEL CLIENTE 

        lstActualizarDatosClientes.add(actualizarNombre);
        lstActualizarDatosClientes.add(actualizarEdad);
        lstActualizarDatosClientes.add(actualizarTipoDocumento);
        lstActualizarDatosClientes.add(actualizarNumeroDocumento);
        lstActualizarDatosClientes.add(actualizarUsuario);
        lstActualizarDatosClientes.add(actualizarContraseña);

        // FUNCIONES DEL MENÚ INICIAL

        lstIntro.add(introLogin);
        lstIntro.add(logOut);

        // FUNCIONALIDADES DE LOS EMPLEADOS

        lstFuncionalidades.add(gestionarAvion);
        lstFuncionalidades.add(gestionarAeropuerto);

        //FUNCIONALIDADES PARA GESTIONAR AVIÓN
        lstGestionarAvion.add(registrarAvion);
        lstGestionarAvion.add(eliminarAvion);


        // FUNCIONALIDADES PARA GESTIONAR AEROPUERTO
        lstGestionarAeropuerto.add(registrarAeropuerto);
        lstGestionarAeropuerto.add(actualizarAeropuerto);
        lstGestionarAeropuerto.add(consultarAeropuerto);
        lstGestionarAeropuerto.add(eliminarAeropuerto);
        
    }

    public static CasesListController getController() {
        return CONTROLLER;
    }

    


}
