/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifes.repository;

import com.ifes.entidade.ModeloAeronave;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class ModeloAeronaveRepository {
    private static int id = 1;
    
    public ModeloAeronave findById(int idModeloAeronave) throws ClassNotFoundException, 
            SQLException{
        MyConnection myConnection = MyConnection.createMyConnection();
        Connection connection = myConnection.getConnection();
        ModeloAeronave ModeloAeronave = new ModeloAeronave();
        Statement statement = connection.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM modeloAeronave "
                + "where idModeloAeronave = " + idModeloAeronave);
        while(rs.next()) {
            ModeloAeronave.setIdModeloAeronave(rs.getInt(1));
            ModeloAeronave.setNome(rs.getString(2));
            ModeloAeronave.setCapPassageiros(rs.getInt(3));
            ModeloAeronave.setCapCargas(rs.getDouble(4));
            ModeloAeronave.setAutonomia(rs.getDouble(5));
            
            FabricanteRepository fabricanteRepository = new FabricanteRepository();
            ModeloAeronave.setFabricante(fabricanteRepository.findById(rs.getInt(6)));
        }
        rs.close();
        statement.close();
        
        return ModeloAeronave;
    }
    
    public ModeloAeronave update(ModeloAeronave modeloAeronave) 
            throws SQLException, ClassNotFoundException{
        String script = "UPDATE ModeloAeronave SET nome = " + modeloAeronave.getNome() 
            + ", capPassageiros = "+ modeloAeronave.getCapPassageiros()+
                ", capCargas = "+modeloAeronave.getCapCargas()+", autonomia = " 
                +modeloAeronave.getAutonomia()+", idFabricante ="+ 
                modeloAeronave.getFabricante().getIdFabricante()+
                " WHERE idModeloAeronave = " + modeloAeronave.getIdModeloAeronave();
        insertUpdateDelete(script);

        return findById(modeloAeronave.getIdModeloAeronave());
    }
    
    public ModeloAeronave insert(ModeloAeronave modeloAeronave) 
            throws SQLException, ClassNotFoundException{
        String script;
        script = "INSERT INTO ModeloAeronave(idModeloAeronave, nome, "
                + "capPassageiros, capCargas, autonomia, idFabricante) VALUES "
                + "("+ id++ +","+ modeloAeronave.getNome() + "," 
                + modeloAeronave.getCapPassageiros() + ","+
                modeloAeronave.getCapCargas()+ ","+modeloAeronave.getAutonomia()
                + ","+modeloAeronave.getFabricante().getIdFabricante()+ ")";
        insertUpdateDelete(script);

        return findById(modeloAeronave.getIdModeloAeronave());
    }
    
    public void delete(int idModeloAeronave) throws SQLException, ClassNotFoundException{
        String script;
        script = "DELETE FROM ModeloAeronave WHERE idModeloAeronave = " + idModeloAeronave;
        insertUpdateDelete(script);
    }
    
    private void insertUpdateDelete (String script) throws SQLException, ClassNotFoundException{
        MyConnection myConnection = MyConnection.createMyConnection();
        Connection connection = myConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(script);
        statement.close();
        
    }
}
