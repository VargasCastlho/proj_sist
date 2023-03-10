/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifes.repository;

import com.ifes.entidade.Fabricante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ferna
 */
public class FabricanteRepository {
    private static int id = 1;
    
    public Fabricante findById(int idFabricante) throws ClassNotFoundException, 
            SQLException{
        MyConnection myConnection = MyConnection.createMyConnection();
        Connection connection = myConnection.getConnection();
        Fabricante fabricante = new Fabricante();
        Statement statement = connection.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM fabricante "
                + "where idFabricante = " + idFabricante);
        while(rs.next()) {
            fabricante.setIdFabricante(rs.getInt(1));
            fabricante.setNome(rs.getString(2));
            fabricante.setPais(rs.getString(3));
        }
        rs.close();
        statement.close();
        
        return fabricante;
    }
    
    public Fabricante update(Fabricante fabricante) throws SQLException, ClassNotFoundException{
        String script = "UPDATE fabricante SET nome = '" + fabricante.getNome() 
            + "', pais = '"+ fabricante.getPais() +"' WHERE idFabricante = " + 
            fabricante.getIdFabricante();
        insertUpdateDelete(script);

        
        return findById(fabricante.getIdFabricante());
    }
    
    public Fabricante insert(Fabricante fabricante) throws SQLException, ClassNotFoundException{
        String script;
        fabricante.setIdFabricante(id++);
        script = "INSERT INTO fabricante(idFabricante, nome, pais) VALUES "
                + "('"+ fabricante.getIdFabricante() +"','"+ fabricante.getNome() 
                + "','" + fabricante.getPais() + "')";
        insertUpdateDelete(script);

        return findById(fabricante.getIdFabricante());
    }
    
    public void delete(int idFabricante) throws SQLException, ClassNotFoundException{
        String script;
        script = "DELETE FROM fabricante WHERE idFabricante = " + idFabricante;
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
