package com.agencia.LogIn.Adapter.In;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.LogIn.Application.CheckEmployee;
import com.agencia.LogIn.Application.SearchRols;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.LogIn.Domain.VerifyEmployeeService;
import com.agencia.LogIn.Domain.ViewRolService;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckPassword;
import com.agencia.Verifiers.CheckString;
import com.agencia.Verifiers.PasswordEncripted;

public class LogInView {

    private final SearchRols searchRols;
    private final CheckEmployee checkEmployee;

    public LogInView(SearchRols searchRols, CheckEmployee checkEmployee) {
        this.searchRols = searchRols;
        this.checkEmployee = checkEmployee;
    }

    public void startLogIn() {
        List<String> rols = this.searchRols.extract();
        ResultSet employeeSet;
        String rolEmpleado = ""; 
        String usuarioEmpleado, passwordEmpleado;
        String passwordEncripted = "";
         
        boolean correctRol = false;
        int opcionRol = 0;
        int itemRol = 0;
        int countSet = 0;
        int idEmployee = 0;
        String nameEployee = "";
        String fechaIngreso = "0000-00-00";
        String cityEMployee = "";
        String aerolinea = "";
        String rolExtracted = "";
        String document = "";
        String userEmployee = "";
        String passwordExtracted = "";
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;

        System.out.println("\n____________________\n");
        System.out.println("  INICIO DE SESIÓN");
        System.out.println("____________________\n");

        System.out.println("\n--> Selecciona tu rol");
        System.out.println(".......................");

        System.out.println("\n===========================");
        System.out.println("         R O L E S");
        System.out.println("===========================");

        for (String rol : rols ) {
            itemRol = rols.indexOf(rol) + 1; 
            System.out.println(itemRol + ". " + rol + "\n");
        }

        itemRol += 1;
        System.out.println(itemRol + ". Cancelar" );
        System.out.println("----------------------------");

        

        

        while ( correctRol == false) {

            System.out.println("\n  Marque la opción del rol");
            System.out.println(". . . . . . . . . . . . . . .");
            System.out.print(">>> ");
            opcionRol = CheckInt.check("Ingrese la opción del rol nuevamente") - 1;

            if (opcionRol <= rols.size()) {
                correctRol = true;
            } else {
                System.out.println("\n*********************");
                System.out.println("  OPCIÓN INCORRECTA");
                System.out.println("*********************");
            }   
            
        }

        if (opcionRol <  rols.size()) {
            rolEmpleado = rols.get(opcionRol);

            System.out.println("\n--> Ingresa el nombre de Usuario");
            System.out.println("....................................");
            System.out.print(">>> ");
            usuarioEmpleado = CheckString.check("Ingresa de nuevo el nombre de usuario");

            employeeSet = this.checkEmployee.extract(rolEmpleado, usuarioEmpleado);

            try {
                while(employeeSet.next()) {
                    idEmployee = employeeSet.getInt("id");
                    nameEployee = employeeSet.getString("nombreEmpleado");
                    fechaIngreso = employeeSet.getString("fechaIngreso");
                    cityEMployee = employeeSet.getString("ciudadNombre");
                    rolExtracted = employeeSet.getString("rolNombre");
                    document = employeeSet.getString("tipodocumentoNombre");
                    userEmployee = employeeSet.getString("usuario");
                    passwordExtracted = employeeSet.getString("contraseña");
                    countSet ++;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            if (countSet == 0) {
                System.err.println("\n****************************************");
                System.out.println("*  Información de Empleado Incorrecta  *");
                System.out.println("****************************************");
                startLogIn();
            } else {
                

                passwordEmpleado = CheckPassword.check();

                passwordEncripted = PasswordEncripted.encript(passwordEmpleado);
                

                if (passwordEncripted.equals(passwordExtracted.toLowerCase())) {

                    System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("   INGRESO AUTENTICADO");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                    Empleado employee = new Empleado(idEmployee, nameEployee, cityEMployee, aerolinea, rolExtracted, document, usuarioEmpleado, passwordExtracted, fechaIngreso);
                } else {
                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x  CONTRASEÑA INCORRECTA  x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    startLogIn();
                }

            }
        }else {
            Intro intro = new Intro(listaFuncionesIntro);
            intro.start();
        }

    }
    
}


