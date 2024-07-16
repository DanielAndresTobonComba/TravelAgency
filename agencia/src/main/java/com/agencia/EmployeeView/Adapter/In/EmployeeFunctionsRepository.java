package com.agencia.EmployeeView.Adapter.In;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.EmployeeView.Domain.MenuGenerated;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class EmployeeFunctionsRepository implements MenuGenerated {

    @Override
    public List<Funcionalidad> extractFunctions(String rol) {
        List<Funcionalidad> listEmployeeFunctions = new ArrayList<>();
        List<String> lstEmployeeFunctionsCodes = new ArrayList<>();
        InputStream configProperties = null;
        String  JSON_URL = "";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jNode = null;
        ArrayNode listaPersona = null;
        java.util.Iterator<Map.Entry<String, JsonNode>> fields = null;
        
        


        try {
            configProperties = new FileInputStream("./agencia/src/main/java/com/agencia/Resources/Config.properties");
            Properties properties = new Properties();
            properties.load(configProperties);
            JSON_URL = properties.getProperty("json.URL");
            jNode = objectMapper.readTree(new File(JSON_URL));
            fields = jNode.fields();
        } catch (IOException io) {
            io.printStackTrace();
        }

        while ((fields.hasNext())) {
            Map.Entry<String, JsonNode> entry = fields.next();
            if (rol.equals(entry.getKey()) ) {
                listaPersona = (ArrayNode) entry.getValue();
            }
        }

        

        if (listaPersona != null) {
            for (JsonNode element : listaPersona) {
                lstEmployeeFunctionsCodes.add(element.toString());
            }
        }

        for (Funcionalidad funcion : CasesListController.getController().lstFuncionalidades) {
            if (lstEmployeeFunctionsCodes.contains('"' + funcion.codigo + '"')) {
                
                listEmployeeFunctions.add(funcion);
            }
        }


        return listEmployeeFunctions;

    }

}
