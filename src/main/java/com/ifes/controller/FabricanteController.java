/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifes.controller;


import com.ifes.entidade.Fabricante;
import com.ifes.repository.FabricanteRepository;
import com.ifes.service.FabricanteService;

import java.util.ArrayList;


/**
 *
 * @author 2022222760011
 */
public class FabricanteController {
    
   
    private FabricanteService fabricanteService = new FabricanteService();
    
    public ArrayList<Fabricante> getAllFabricantes() {
        ArrayList<Fabricante> result = this.fabricanteService.findAllFabricantes();
        return result;
    }
    
    public Fabricante insertFabricante(String nome, String pais){
        Fabricante result = this.fabricanteService.insertFabricante(nome, pais);
        return result;
    }
    
    public Fabricante findByFilterFabricante(Fabricante fabricante){
        Fabricante result = this.fabricanteService.findByFilterFabricante(fabricante);
        return result;
    }
    
    public Fabricante removeFabricante(Fabricante fabricante){
        Fabricante result = this.fabricanteService.removeFabricante(fabricante);
        return result;
    }
}
