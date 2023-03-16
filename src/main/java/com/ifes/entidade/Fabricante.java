/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.entidade;


/**
 *
 * @author 2022222760011
 */

public class Fabricante {
    private int idFabricante;
    private String nome;
    private String pais;

    public Fabricante(int idFabricante, String nome, String pais) {
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.pais = pais;
    }

    public Fabricante(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }
    

    public Fabricante() {
        
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void getNome(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getPais(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
}
