package com.agencia.RegistrarAvion.Adapater.In;

import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;

public class FormAirplaneRegistration {

    private ExistentPlatesExtraction existentPlatesExtraction;

    public FormAirplaneRegistration(ExistentPlatesExtraction existentPlatesExtraction) {
        this.existentPlatesExtraction = existentPlatesExtraction;
    }

    public void SeeResults() {
        System.out.println(this.existentPlatesExtraction.executeExtract()); 
    }

}
