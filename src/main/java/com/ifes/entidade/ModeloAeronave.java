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

public class ModeloAeronave {
    private int idModeloAeronave;
    private String nome;
    private int capPassageiros;
    private double capCargas;
    private double autonomia;
    private Fabricante fabricante;

    public ModeloAeronave(int idModeloAeronave, String nome, int capPassageiros, double capCargas, double autonomia, Fabricante fabricante) {
        this.idModeloAeronave = idModeloAeronave;
        this.nome = nome;
        this.capPassageiros = capPassageiros;
        this.capCargas = capCargas;
        this.autonomia = autonomia;
        this.fabricante = fabricante;
    }

    public int getIdModeloAeronave() {
        return idModeloAeronave;
    }

    public String getNome() {
        return nome;
    }

    public int getCapPassageiros() {
        return capPassageiros;
    }

    public double getCapCargas() {
        return capCargas;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setIdModeloAeronave(int idModeloAeronave) {
        this.idModeloAeronave = idModeloAeronave;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapPassageiros(int capPassageiros) {
        this.capPassageiros = capPassageiros;
    }

    public void setCapCargas(double capCargas) {
        this.capCargas = capCargas;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    
}
