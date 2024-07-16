package com.agencia.EmployeeView.Application;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.EmployeeView.Domain.MenuGenerated;

public class GeneratedMenu {

    private MenuGenerated menuGenerated;

    public GeneratedMenu(MenuGenerated menuGenerated) {
        this.menuGenerated = menuGenerated;
    }

    public List<Funcionalidad> generate(String rol) {

        return this.menuGenerated.extractFunctions(rol);
        
    }

    

}
