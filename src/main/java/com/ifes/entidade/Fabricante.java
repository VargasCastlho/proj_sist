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
    
    public Fabricante(int idFabricante, String nome) {
        this.idFabricante = idFabricante;
        this.nome = nome;
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
  
}
