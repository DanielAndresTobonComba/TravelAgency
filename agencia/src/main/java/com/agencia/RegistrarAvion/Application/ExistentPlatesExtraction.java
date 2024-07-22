package com.agencia.RegistrarAvion.Application;

import java.util.List;

import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;

public class ExistentPlatesExtraction {

    private PlatesExtractionService platesExtractionService;

    public ExistentPlatesExtraction(PlatesExtractionService platesExtractionService) {
        this.platesExtractionService = platesExtractionService;
    }

    public List<String> executeExtract(){

        return this.platesExtractionService.extractPlates();

    }

}
