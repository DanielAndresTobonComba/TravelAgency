package com.agencia.CheckIn.Application;

import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractDocumentsService;

public class ExtractDocumentAction {

    private ExtractDocumentsService extractDocumentsService;

    public ExtractDocumentAction(ExtractDocumentsService extractDocumentsService) {
        this.extractDocumentsService = extractDocumentsService;
    }

    public List<Integer> extract() {

        return this.extractDocumentsService.extractDocuments();

    }

}
