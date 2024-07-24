package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractDocumentsService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractDocumentTypesList implements ExtractDocumentsService{

    @Override
    public List<Integer> extractDocuments() {

        List<Integer> listDocumentTypes = new ArrayList<>();
        int rowCount = 0;


        try {

                String SQLprocedure = "{CALL TraerTipoDocumento()}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                System.out.println("\n\n=========================================================");
                System.out.println("                   TIPOS DE DOCUMENTOS");
                System.out.println("=========================================================");
                System.err.println("  COD\t|    TIPO DE DOCUMENTO");
                System.out.println("---------------------------------------------------------");

                while (resultSet.next()) {

                    rowCount++;
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    listDocumentTypes.add(id);
                    System.out.println("  " + id + ".\t|  " + nombre);


                }

                if (rowCount == 0) {

                    System.out.println("\nNO HAY TIPOS DE DOCUMENTOS REGISTRADOS\n");
    
                }
    
                System.out.println("---------------------------------------------------------");

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
        return listDocumentTypes;
    }

    

}
