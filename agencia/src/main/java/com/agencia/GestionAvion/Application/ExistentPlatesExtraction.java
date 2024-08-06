package com.agencia.GestionAvion.Application;

import java.util.List;

import com.agencia.GestionAvion.Domain.Service.PlatesExtractionService;

public class ExistentPlatesExtraction {

    private PlatesExtractionService platesExtractionService;

    public ExistentPlatesExtraction(PlatesExtractionService platesExtractionService) {
        this.platesExtractionService = platesExtractionService;
    }

    public List<String> executeExtract(){

        return this.platesExtractionService.extractPlates();

    }

}
